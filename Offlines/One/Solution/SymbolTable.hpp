#ifndef SYMBOL_TABLE_HPP
#define SYMBOL_TABLE_HPP

#include "scope_table.hpp"



template <typename NameType = string, typename TypeType = string>
class SymbolTable {

    private:
    ScopeTable<NameType, TypeType>* curr_scope_table;
    unsigned int num_buckets;
    unsigned int hash_func_num;

    public:

    SymbolTable(unsigned int num_buckets, ScopeTable<NameType, TypeType>* parent = nullptr, unsigned int hash_func_num = 1) 
        :   num_buckets(num_buckets), hash_func_num(hash_func_num) {
        curr_scope_table = new ScopeTable<NameType, TypeType>(num_buckets, parent, hash_func_num);
    }

    ~SymbolTable() {
        while (curr_scope_table != nullptr) {
            ScopeTable<NameType, TypeType>* temp = curr_scope_table;
            curr_scope_table = curr_scope_table->getParentScope();
            delete temp;
        }
    }

    void enterScope() {
        curr_scope_table = new ScopeTable<NameType, TypeType>(
            this->num_buckets,
            this->curr_scope_table,
            this->hash_func_num
        );
    }

    void exitScope() {
        ScopeTable<NameType, TypeType>* temp = curr_scope_table;
        curr_scope_table = curr_scope_table->getParentScope();
        delete temp;
    }

    bool insert(SymbolInfo<NameType, TypeType>* symbol) {
        return curr_scope_table->insert(symbol);
    }

    bool Remove(const string& name) {
        return curr_scope_table->Delete(name);
    }

    SymbolInfo<NameType, TypeType>* lookUp(const string& name) {
        ScopeTable<NameType, TypeType>* temp = curr_scope_table;
        while (temp != nullptr) {
            SymbolInfo<NameType, TypeType>* symbol = temp->lookUp(name);
            if (symbol != nullptr) return symbol;
            temp = temp->getParentScope();
        }

        return nullptr;
    }

    void printCurrScope() const {
        curr_scope_table->print(1);
    }

    void printAllScope() const {
        ScopeTable<NameType, TypeType>* temp = curr_scope_table;
        unsigned int level = 1;
        while (temp != nullptr) {
            temp->print(level++);
            temp = temp->getParentScope();
        }
    }


};

#endif