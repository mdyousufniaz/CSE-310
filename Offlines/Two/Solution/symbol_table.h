#ifndef SYMBOL_TABLE_H
#define SYMBOL_TABLE_H

#include <stdio.h>

extern const unsigned char num_buckets;

char* __create_string(const char* str);
unsigned int sdbmHash(const char* p);

typedef struct SymbolInfo {
    char* name;
    char* type;
    struct SymbolInfo* next;
} SymbolInfo;

SymbolInfo* create_symbol_info(
    const char* name, 
    const char* type, 
    SymbolInfo* next
);

void free_symbol_info(SymbolInfo* symbol_info);
void print_symbol_info(FILE* o_file, SymbolInfo* symbol_info);

typedef struct ScopeTable {
    SymbolInfo** hashmap;
    struct ScopeTable* parent_scope;
    char* id;
    unsigned short child_count;
} ScopeTable;

ScopeTable* create_scope_table(
    ScopeTable* parent_scope,
    const char* id,
    unsigned short child_count
);

void free_scope_table(ScopeTable* scope_table);
unsigned char insert_scope_table(
    FILE* o_file,
    ScopeTable* scope_table,
    const char* name,
    const char* type
);

void print_scope_table(FILE* o_file, ScopeTable* scope_table);

typedef struct {
    ScopeTable* curr_scope_table;
    unsigned int curr_childs;
} SymbolTable;

SymbolTable* create_symbol_table();
void free_symbol_table(SymbolTable* symbol_table);
void enter_scope(SymbolTable* symbol_table);
void exit_scope(SymbolTable* symbol_table);
unsigned char insert_symbol_table(
    FILE* o_file,
    SymbolTable* symbol_table,
    const char* name,
    const char* type
);
void print_symbol_table(FILE* o_file, SymbolTable* symbol_table);

#endif
