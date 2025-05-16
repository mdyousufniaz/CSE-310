#include "symbol_table.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

const unsigned char num_buckets = 7;

char* __create_string(const char* str) {
    char* new_str = (char*) malloc(strlen(str) + 1);
    strcpy(new_str, str);
    return new_str;
}

unsigned int sdbmHash(const char* p) {
    unsigned int hash = 0;
    unsigned char* str = (unsigned char*) p;
    int c ;

    while ((c = *str++)) hash = c + (hash << 6) + (hash << 16) -hash;
    return hash;
}


SymbolInfo* create_symbol_info(
    const char* name,
    const char* type, 
    SymbolInfo* next
) {
    SymbolInfo* symbol_info = (SymbolInfo*) malloc(sizeof(SymbolInfo));

    symbol_info->name = __create_string(name);
    symbol_info->type = __create_string(type);
    symbol_info->next = next;

    return symbol_info;
}

void free_symbol_info(SymbolInfo* symbol_info) {
    if (symbol_info == NULL) return;

    free(symbol_info->name);
    free(symbol_info->type);

    free(symbol_info);
}

void print_symbol_info(FILE* o_file, SymbolInfo* symbol_info) {
    fprintf(o_file, "< %s : %s >", symbol_info->name, symbol_info->type);
}

ScopeTable* create_scope_table(
    ScopeTable* parent_scope,
    const char* id,
    unsigned short child_count
) {
    ScopeTable* scope_table = (ScopeTable*) malloc(sizeof(ScopeTable));

    scope_table->hashmap = (SymbolInfo**) malloc(sizeof(SymbolInfo*) * num_buckets);
    for (unsigned char i = 0; i < num_buckets; i++) scope_table->hashmap[i] = NULL;

    scope_table->parent_scope = parent_scope;
    scope_table->id = __create_string(id);
    scope_table->child_count = child_count;

    return scope_table;
}

void free_scope_table(ScopeTable* scope_table) {
    for (unsigned char i = 0; i < num_buckets; i++) {
        SymbolInfo* curr = scope_table->hashmap[i];
        while(curr != NULL) {
            SymbolInfo* next = curr->next;
            free_symbol_info(curr);
            curr = next;
        }
    }

    free(scope_table->hashmap);
    free(scope_table->id);

    free(scope_table);
}

unsigned char insert_scope_table(
    FILE* o_file,
    ScopeTable* scope_table,
    const char* name,
    const char* type
) {
    unsigned char bucket_index = sdbmHash(name) % num_buckets;
    SymbolInfo* curr = scope_table->hashmap[bucket_index];
    if (curr == NULL) {
        scope_table->hashmap[bucket_index] = create_symbol_info(name, type, NULL);
        return 1;
    }

    SymbolInfo* prev = NULL;
    unsigned short col = 0;
    
    while (curr != NULL) {
        if (strcmp(curr->name, name) == 0) {
            fprintf(o_file, "< %s : %s > already exists in ScopeTable# %s at position %hhu, %hu\n\n", name, type, scope_table->id, bucket_index, col);
            return 0;
        }
        col++;
        prev = curr;
        curr = curr->next;
    }
    
    prev->next = create_symbol_info(name, type, NULL);
    return 1;
}

void print_scope_table(FILE* o_file, ScopeTable* scope_table) {
    fprintf(o_file, "ScopeTable # %s\n", scope_table->id);

    for (unsigned char i = 0; i < num_buckets; i++) {
        SymbolInfo* curr = scope_table->hashmap[i];
        if (curr == NULL) continue;
        fprintf(o_file, "%i --> ", i);

        while (curr != NULL) {
            print_symbol_info(o_file, curr);
            curr = curr->next;
        }
        fprintf(o_file, "\n");
    }
}

SymbolTable* create_symbol_table() {
    SymbolTable* symbol_table = (SymbolTable*) malloc(sizeof(SymbolTable));

    symbol_table->curr_childs = 1;
    symbol_table->curr_scope_table = create_scope_table(NULL, "1", symbol_table->curr_childs);

    return symbol_table;
}

void free_symbol_table(SymbolTable* symbol_table) {
    ScopeTable* curr = symbol_table->curr_scope_table;
    while(curr != NULL) {
        ScopeTable* parent = curr->parent_scope;
        free_scope_table(curr);
        curr = parent;
    }

    free(symbol_table);
}

void enter_scope(SymbolTable* symbol_table) {
    char* old_id = symbol_table->curr_scope_table->id;
    unsigned int curr_child_count = symbol_table->curr_childs;

    char* new_id = (char*) malloc((strlen(old_id) + 2 + (int) ceil(log10(curr_child_count)) * sizeof(char)));
    sprintf(new_id, "%s%c%i", old_id, '.', curr_child_count);

    ScopeTable* new_scope = create_scope_table(
        symbol_table->curr_scope_table,
        new_id,
        symbol_table->curr_childs
    );
    free(new_id);

    symbol_table->curr_scope_table = new_scope;
}

void exit_scope(SymbolTable* symbol_table) {
    ScopeTable* parent_scope = symbol_table->curr_scope_table->parent_scope;

    if (parent_scope != NULL) {
        symbol_table->curr_childs = symbol_table->curr_scope_table->child_count + 1;
        free(symbol_table->curr_scope_table);
        symbol_table->curr_scope_table = parent_scope;
    }
}

unsigned char insert_symbol_table(
    FILE* o_file,
    SymbolTable* symbol_table,
    const char* name,
    const char* type
) {
    return insert_scope_table(o_file, symbol_table->curr_scope_table, name, type);
}

void print_symbol_table(FILE* o_file, SymbolTable* symbol_table) {
    ScopeTable* curr = symbol_table->curr_scope_table;
    while (curr != NULL) {
        print_scope_table(o_file, curr);
        curr = curr->parent_scope;
    }
    fprintf(o_file, "\n");
}

// int main(void) {
//     SymbolTable* symbol_table = create_symbol_table();

//     // insert_symbol_table(symbol_table, "main", "ID");
//     // print_symbol_table(symbol_table);
//     // enter_scope(symbol_table);
//     // insert_symbol_table(symbol_table, "_i", "ID");
//     // insert_symbol_table(symbol_table, "672", "CONST_INT");
//     // print_symbol_table(symbol_table);

//     free_symbol_table(symbol_table);
//     return 0;
// }
