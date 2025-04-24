#ifndef SYMBOL_TABLE_HPP
#define SYMBOL_TABLE_HPP

#include "scope_table.hpp"

class SymbolTable {

    private:
    ScopeTable* curr_scope_table;
    unsigned int num_buckets;
    unsigned int hash_func_num;
    unsigned int prev_collisions = 0;
    unsigned int scope_table_counter = 1;

    public:

    SymbolTable(unsigned int num_buckets, unsigned int hash_func_num = 1) 
        :   num_buckets(num_buckets), hash_func_num(hash_func_num) {
        curr_scope_table = new ScopeTable(num_buckets, hash_func_num, scope_table_counter, nullptr);
    }

    ~SymbolTable() {
        while (curr_scope_table != nullptr) {
            ScopeTable* temp = curr_scope_table;
            curr_scope_table = curr_scope_table->getParentScope();
            delete temp;
        }
    }

    void enterScope() {
        curr_scope_table = new ScopeTable(
            this->num_buckets,
            this->hash_func_num,
            ++this->scope_table_counter,
            this->curr_scope_table
        );
    }

    void exitScope() {
        prev_collisions += curr_scope_table->collision_num;
        ScopeTable* temp = curr_scope_table;
        curr_scope_table = curr_scope_table->getParentScope();
        delete temp;
    }

    bool insert(SymbolInfo* symbol) {
        return curr_scope_table->insert(symbol);
    }

    bool remove(const string& name) {
        return curr_scope_table->Delete(name);
    }

    SymbolInfo* lookUp(const string& name) {
        ScopeTable* temp = curr_scope_table;
        while (temp != nullptr) {
            SymbolInfo* symbol = temp->lookUp(name);
            if (symbol != nullptr) return symbol;
            temp = temp->getParentScope();
        }

        cout << get_tabs(1) << "'" << name << "' not found in any of the ScopeTables" << endl;
        return nullptr;
    }

    void printCurrScope() const {
        curr_scope_table->print(1);
    }

    void printAllScope() const {
        ScopeTable* temp = curr_scope_table;
        unsigned int level = 1;
        while (temp != nullptr) {
            temp->print(level++);
            temp = temp->getParentScope();
        }
    }

    float mean_collision_ratio() {
        unsigned int curr_collisions = 0;
        ScopeTable* temp = curr_scope_table;
        while (temp != nullptr) {
            curr_collisions += temp->collision_num;
            temp = temp->getParentScope();
        }

        return (float) (curr_collisions + prev_collisions) / (this->scope_table_counter * num_buckets);
    }


};

#endif