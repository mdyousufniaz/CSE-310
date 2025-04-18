#include <iostream>
#include <fstream>
#include <sstream>

#include "SymbolTable.hpp"

using namespace std;

int main(int argc, char* argv[]) {

    if (argc < 3) {
        cerr << "Usage ./main <input_file> <output_file>" << endl;
        return 1;
    }

    ifstream input_file(argv[1]);
    ofstream output_file(argv[2]);

    if (!input_file.is_open()) {
        cerr << "File is not found!" << endl;
        return 1;
    }

    streambuf* coutbuf = cout.rdbuf();
    cout.rdbuf(output_file.rdbuf());

    unsigned int num_buckets;
    input_file >> num_buckets;
    cout << num_buckets << endl;

    SymbolTable<> symbol_table(num_buckets);

    string line;
    unsigned int command_num = 1;

    while(getline(input_file, line)) {
        cout << "Cmd " << command_num++ << ": " << line << endl;

        istringstream tokens(line);
        char cmd;
        tokens >> cmd;

        switch (cmd) {
            case 'I': {
                string name, type, value;
                tokens >> name;
                tokens >> type;

                if (type == "FUNCTION") {
                    string ret_type, arg_type;
                    tokens >> ret_type;
                    type = type + "," + ret_type + "<==(";

                    getline(tokens, arg_type);
                    for (unsigned i = 0; i < arg_type.length(); i++) if (arg_type[i] == ' ') arg_type[i] = ',';

                    type = type + arg_type + ")";
                } 
                break;
            }
                
            case 'L': {
                string name, extra;
                tokens >> name;
                getline(tokens, extra);
                cout << name << (extra == "") << endl;
                break;
            }

        }

        // string word;
        // while (tokens >> word) cout << word << "   ";
        // cout << endl;
    }

    input_file.close();

    return 0;
}