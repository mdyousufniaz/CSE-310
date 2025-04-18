#include <iostream>
#include <cassert>

#include "symbol_info.hpp"
#include "scope_table.hpp"
#include "SymbolTable.hpp"
#include "hash_functions.hpp"

using namespace std;

void test_SDBM_hash() {
    cout << "Running SDBM Hash Function tests..." << endl;
    unsigned int num_buckets = 7;

    assert(SDBMHash("brand") % num_buckets == 3);
    assert(SDBMHash("23") % num_buckets == 4);

    cout << "All tests passed successfully!" << endl;

}

int main() {
    // ScopeTable<> st(7);
    // st.insert(new SymbolInfo<>("var", "VAR"));
    // st.print();
    // st.Delete("var");
    // st.print();

    SymbolTable<> ST(7);
    ST.enterScope();
    ST.enterScope();
    ST.printCurrScope();
    ST.printAllScope();

    return 0;
}