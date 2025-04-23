#ifndef SYMBOL_INFO_HPP
#define SYMBOL_INFO_HPP

#include <iostream>
#include <string>

using namespace std;

class SymbolInfo {

    private:
    string name;
    string type;
    SymbolInfo* next_symbol_info = nullptr;

    public:
    SymbolInfo(const string& name, const string& type)
        : name(name), type(type) {}

    string getName() const {
        return this->name;
    }

    void setName(const string& name) {
        this->name = name;
    }

    string getType() const {
        return this->type;
    }

    void setType(const string& type) {
        this->type = type;
    }

    SymbolInfo* getNext() const {
        return this->next_symbol_info;
    }

    void setNext(SymbolInfo* next_sym_info) {
        this->next_symbol_info = next_sym_info;
    } 

    friend std::ostream& operator<<(std::ostream& os, const SymbolInfo& sym_info) {
        os << "<" << sym_info.getName() << "," << sym_info.getType() << ">";
        return os;
    }

};


#endif