#ifndef SCOPE_TABLE_HPP
#define SCOPE_TABLE_HPP

#include "symbol_info.hpp"
#include "hash_functions.hpp"

using namespace std;

string get_tabs(unsigned int tab_len) {
    string result = "";

    for (unsigned int i = 0; i < tab_len; i++) result += '\t';
    return result;
}

class ScopeTable {

    private:
    static unsigned int scope_counter;

    SymbolInfo **hashmap;
    unsigned int num_buckets;
    ScopeTable* parent_scope;
    unsigned int (*hashFunc) (string, unsigned int);

    unsigned int hash(string name) {
        return hashFunc(name, num_buckets);
    }

    string get_pos(const string& name) {
        unsigned int hash_value = hash(name);
        SymbolInfo* current = hashmap[hash_value];
        unsigned int pos = 1;

        while (current != nullptr) {
            if (current->getName() == name) return to_string(hash_value + 1) + ", " + to_string(pos);
            current = current->getNext();
            pos++;
        }

        return "";
    }

    

    public:
    unsigned int scope_id;
    unsigned int collision_num = 0;

    ScopeTable(unsigned int num_buckets, unsigned int hash_func_num, ScopeTable* parent)
        :   num_buckets(num_buckets), parent_scope(parent) {
            this->hashmap = new SymbolInfo*[num_buckets];
            for (unsigned int i = 0; i < num_buckets; i++) hashmap[i] = nullptr;

            hashFunc = getHashFunc(hash_func_num);
            scope_id = ++scope_counter;
            cout << get_tabs(1) << "ScopeTable# " << scope_id  << " created" << endl;
        }

    ~ScopeTable() {
        for (unsigned int i = 0; i < num_buckets; i++) {
            SymbolInfo* current = hashmap[i];

            while (current != nullptr) {
                SymbolInfo* temp = current;
                current = current->getNext();
                delete temp;
            }
        }
        
        delete[] hashmap;
        cout << get_tabs(1) << "ScopeTable# " << scope_id  << " removed" << endl;
    }

    ScopeTable* getParentScope() {
        return this->parent_scope;
    }

    bool insert(SymbolInfo* symbol) {
        string tabs = get_tabs(1);
        string symbol_name = symbol->getName();
        if (get_pos(symbol_name) != "") {
            cout << tabs << "'" << symbol_name << "' already exists in the current ScopeTable" << endl;
            delete symbol;
            return false;
        }

        unsigned int hash_value = hash(symbol_name);

        SymbolInfo* temp = hashmap[hash_value];
        if (temp == nullptr) hashmap[hash_value] = symbol;
        else {
            collision_num++;
            while (temp->getNext() != nullptr) temp = temp->getNext();
            temp->setNext(symbol);
        }

        cout << tabs << "Inserted in ScopeTable# " << this->scope_id << " at position " << get_pos(symbol->getName()) << endl;
        return true;
    }

    SymbolInfo* lookUp(string name) {
        unsigned int hash_value = hash(name);
        SymbolInfo* current = hashmap[hash_value];
        string tabs = get_tabs(1);

        while (current != nullptr) {
            if (current->getName() == name) { 
                cout << tabs << "'" << name << "' found in ScopeTable# " << this->scope_id << " at position " << get_pos(current->getName()) << endl;
                return current;
            }
            current = current->getNext();
        }

        return nullptr;
    }

    bool Delete(const string& name) {
        unsigned int hash_value = hash(name);
        SymbolInfo* current = hashmap[hash_value];
        SymbolInfo* prev = nullptr;
        string tabs = get_tabs(1);
        string pos;

        while (current != nullptr) {
            if (current->getName() == name) {
                pos = get_pos(current->getName());
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
            cout << tabs << i + 1 << "--> "; 
    
            SymbolInfo* current = hashmap[i];
            while (current != nullptr) {
                cout << *current << ' '; 
                current = current->getNext();
            }
            cout << endl;
        }
    }


    
};

unsigned int ScopeTable:: scope_counter = 0;


#endif