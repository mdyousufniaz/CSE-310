#include <iostream>
#include <fstream>
#include <sstream>

#include "symbol_table.hpp"

using namespace std;

void mismatchCommand(char cmd) {
    cout << get_tabs(1) << "Number of parameters mismatch for the command " << cmd << endl;
}

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

    SymbolTable* symbol_table = new SymbolTable(num_buckets);

    string line;
    getline(input_file, line);
    unsigned int command_num = 1;
    char cmd = ' ';

    while(getline(input_file, line)) {
        if (cmd == 'Q') break;
        cout << "Cmd " << command_num++ << ": " << line << endl;

        istringstream tokens(line);
        
        tokens >> cmd;

        switch (cmd) {
            case 'I': {
                string name, type, value;
                tokens >> name;
                tokens >> type;

                if (type == "FUNCTION") {
                    string ret_type, arg_type;
                    tokens >> ret_type;
                    type += "," + ret_type + "<==(";

                    getline(tokens, arg_type);
                    arg_type.erase(0, 1);
                    for (unsigned i = 0; i < arg_type.length(); i++) if (arg_type[i] == ' ') arg_type[i] = ',';

                    type += arg_type + ")";
                } else if (type == "STRUCT" || type == "UNION") {
                    type += ",{";

                    while (tokens) {
                        string sub_type, sub_name;
                        tokens >> sub_type >> sub_name;
                        if (sub_type == "" || sub_name == "") break;
                        type += "(" + sub_type + "," + sub_name + ")";
                        if (tokens) type += ",";
                    }
                    
                    type += "}";
                }

                symbol_table->insert(new SymbolInfo(name, type));
                break;
            }
                
            case 'L': {
                string name, extra;
                tokens >> name;
                getline(tokens, extra);
                if (extra != "") {
                    mismatchCommand('L');
                } else {
                    symbol_table->lookUp(name);
                }
                break;
            }

            case 'D': {
                string name;
                tokens >> name;
                if (name == "") {
                    mismatchCommand('D');
                } else {
                    symbol_table->remove(name);
                }
                break;
            }

            case 'P': {
                char print_type;
                tokens >> print_type;
                switch (print_type) {
                    case 'C':
                        symbol_table->printCurrScope();
                        break;
                    case 'A':
                        symbol_table->printAllScope();
                        break;
                }
                break;
            }
            case 'S':
                symbol_table->enterScope();
                break;
            case 'E':
                symbol_table->exitScope();
                break;
            case 'Q':
                break;

        }
    }
    delete symbol_table;

    cout.rdbuf(coutbuf);
    input_file.close();

    return 0;
}