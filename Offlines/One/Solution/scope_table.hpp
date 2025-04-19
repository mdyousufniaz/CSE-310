#ifndef SCOPE_TABLE_HPP
#define SCOPE_TABLE_HPP

#include "symbol_info.hpp"
#include "hash_functions.hpp"

using namespace std;

string get_tabs(unsigned int tab_len) {
    const string TAB = "    ";
    string result = "";

    for (unsigned int i = 0; i < tab_len; i++) result += TAB;
    return result;
}

template <typename NameType = string, typename TypeType = string>
class ScopeTable {

    private:
    static unsigned int scope_counter;

    unsigned int scope_id;
    SymbolInfo<NameType, TypeType> **hashmap;
    unsigned int num_buckets;
    ScopeTable* parent_scope;
    unsigned int (*hashFunc) (string);


    unsigned int hash(string name) {
        return hashFunc(name) % num_buckets;
    }

    string get_pos(SymbolInfo<NameType, TypeType>* symbol) {
        unsigned int hash_value = hash(symbol->getName());
        SymbolInfo<NameType, TypeType>* current = hashmap[hash_value];
        unsigned int pos = 1;

        while (current != nullptr) {
            if (current->getName() == symbol->getName()) return to_string(hash_value + 1) + ", " + to_string(pos);
            current = current->getNext();
            pos++;
        }

        return nullptr;
    }

    public:

    ScopeTable(unsigned int num_buckets, ScopeTable* parent, unsigned int hash_func_num)
        :   num_buckets(num_buckets), parent_scope(parent) {
            this->hashmap = new SymbolInfo<NameType, TypeType>*[num_buckets];
            for (unsigned int i = 0; i < num_buckets; i++) hashmap[i] = nullptr;

            hashFunc = getHashFunc(hash_func_num);
            scope_id = ++scope_counter;
            cout << get_tabs(1) << "ScopeTable# " << scope_id  << " created" << endl;
        }

    ~ScopeTable() {
        for (unsigned int i = 0; i < num_buckets; i++) {
            SymbolInfo<NameType, TypeType>* current = hashmap[i];

            while (current != nullptr) {
                SymbolInfo<NameType, TypeType>* temp = current;
                current = current->getNext();
                delete temp;
            }
        }
        
        delete[] hashmap;
        cout << get_tabs(1) << "ScopeTable# " << scope_id  << " removed" << endl;
    }

    ScopeTable<NameType, TypeType>* getParentScope() {
        return this->parent_scope;
    }

    bool insert(SymbolInfo<NameType, TypeType>* symbol) {
        string tabs = get_tabs(1);
        if (lookUp(symbol->getName(), false) != nullptr) {
            cout << tabs << "'" << symbol->getName() << "' already exists in the current ScopeTable" << endl;
            return false;
        }

        unsigned int hash_value = hash(symbol->getName());
        symbol->setNext(hashmap[hash_value]);
        hashmap[hash_value] = symbol;

        cout << tabs << "Inserted in ScopeTable# " << this->scope_id << " at position " << get_pos(symbol) << endl;
        return true;
    }

    SymbolInfo<NameType, TypeType>* lookUp(string name, bool print_log = true) {
        unsigned int hash_value = hash(name);
        SymbolInfo<NameType, TypeType>* current = hashmap[hash_value];
        string tabs = get_tabs(1);

        while (current != nullptr) {
            if (current->getName() == name) { 
                if (print_log) {
                    cout << tabs << "'" << name << "' found in ScopeTable# " << this->scope_id << " at position " << get_pos(current) << endl;
                }
                return current;
            }
            current = current->getNext();
        }

        return nullptr;
    }

    bool Delete(const string& name) {
        unsigned int hash_value = hash(name);
        SymbolInfo<NameType, TypeType>* current = hashmap[hash_value];
        SymbolInfo<NameType, TypeType>* prev = nullptr;
        string tabs = get_tabs(1);
        string pos;

        while (current != nullptr) {
            if (current->getName() == name) {
                pos = get_pos(current);
                if (prev == nullptr) {
                    hashmap[hash_value] = current->getNext();
                } else {
                    prev->setNext(current->getNext());
                }

                cout << tabs << "Deleted '" << current->getName() << "' from ScopeTable# " << this->scope_id << " at position " << pos << endl;
                delete current;
                return true;
            }
            prev = current;
            current = current->getNext();
        }
        cout << tabs << "Not found in the current ScopeTable" << endl;
        return false;
    }

    void print(unsigned int level) const {
        string tabs = get_tabs(level);

        cout << tabs << "ScopeTable# " << scope_id << endl;

        for (unsigned int i = 0; i < num_buckets; ++i) {
            cout << tabs << i + 1 << "-->"; // print bucket index (1-based)
    
            SymbolInfo<NameType, TypeType>* current = hashmap[i];
            while (current != nullptr) {
                cout << " " << *current; // relies on your overloaded <<
                current = current->getNext();
            }
            cout << endl;
        }
    }
    
};

template <typename NameType, typename TypeType>
unsigned int ScopeTable<NameType, TypeType>:: scope_counter = 0;


#endif