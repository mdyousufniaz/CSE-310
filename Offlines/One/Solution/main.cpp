#include <iostream>
#include <fstream>
#include <sstream>

#include "symbol_table.hpp"
#include "utils.hpp"

using namespace std;

int main(int argc, char* argv[]) {

    if (argc < 3) {
        cerr << "Usage ./main <input_file> <output_file>" << endl;
        return 1;
    }

    streambuf* coutbuf = cout.rdbuf();

    float mean_ratio = process_symbol_table(argv[1], argv[2], 1);
    
    cout.rdbuf(coutbuf);

    cout << "Mean Collision Ratio: " << mean_ratio << endl;

    generate_report(argv[1], "./temp");
    

    return 0;
}