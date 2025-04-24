#include <iostream>
#include <fstream>
#include <sstream>

#include "symbol_table.hpp"
#include "utils.hpp"

using namespace std;

int main(int argc, char* argv[]) {

    if (argc < 4) {
        cerr << "Usage ./main <input_file> <output_file> <hash_func_num>" << endl;
        return 1;
    }


    streambuf* coutbuf = cout.rdbuf();

    float mean_ratio = process_symbol_table(argv[1], argv[2], stoi(argv[3]));
    
    cout.rdbuf(coutbuf);

    cout << "Mean Collision Ratio: " << mean_ratio << endl;
    

    return 0;
}