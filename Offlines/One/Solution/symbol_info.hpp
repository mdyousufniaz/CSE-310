#ifndef SYMBOL_INFO_HPP
#define SYMBOL_INFO_HPP

#include <iostream>
#include <string>

template <typename NameType = std::string, typename TypeType = std::string>
class SymbolInfo {

    private:
    NameType name;
    TypeType type;
    SymbolInfo* next_symbol_info = nullptr;

    public:
    SymbolInfo(const NameType& name, const TypeType& type)
        : name(name), type(type) {}

    NameType getName() const {
        return this->name;
    }

    void setName(const NameType& name) {
        this->name = name;
    }

    TypeType getType() const {
        return this->type;
    }

    void setType(const TypeType& type) {
        this->type = type;
    }

    SymbolInfo* getNext() const {
        return this->next_symbol_info;
    }

    void setNext(SymbolInfo* next_sym_info) {
        this->next_symbol_info = next_sym_info;
    } 

    friend std::ostream& operator<<(std::ostream& os, const SymbolInfo<NameType, TypeType>& sym_info) {
        os << "<" << sym_info.getName() << "," << sym_info.getType() << ">";
        return os;
    }

};


#endif