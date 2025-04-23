#ifndef UTILS_HPP
#define UTILS_HPP

#include <string>
#include <fstream>
#include <iostream>
#include <sstream>

#include "symbol_table.hpp"

using namespace std;

void mismatchCommand(char cmd) {
    cout << get_tabs(1) << "Number of parameters mismatch for the command " << cmd << endl;
}

ofstream get_output_file(const string& output_file_name) {
    ofstream output_file(output_file_name);
    cout.rdbuf(output_file.rdbuf());
    return output_file;
}

float process_symbol_table(
    const string& in_file_name,
    const string output_file_name,
    unsigned int hash_func_num
) {
    ifstream input_file(in_file_name);

    if (!input_file.is_open()) {
        cerr << "File is not found!" << endl;
        exit(0);
    }

    unsigned int num_buckets;
    input_file >> num_buckets;

    ofstream output_file = get_output_file(output_file_name);

    SymbolTable* symbol_table = new SymbolTable(num_buckets, hash_func_num);

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
                    type.erase(type.length() - 1, 1);
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
    float mean_ratio = symbol_table ->mean_collision_ratio();

    delete symbol_table;
    input_file.close();

    return mean_ratio;
}

void generate_report(const string& input_file_name, const string& output_dir) {
    string hash_func_names[] = {
        "SDBM_Hash"
    };
    unsigned int hash_func_count = 1;
    float mean_ratios[hash_func_count];
    streambuf* coutbuf = cout.rdbuf();

    for (unsigned int i = 0; i < hash_func_count; i++) {
        const string output_file_name = "" + hash_func_names[i] + ".csv";
        ofstream output_file = get_output_file(output_file_name);
        mean_ratios[i] = process_symbol_table(input_file_name, output_file_name, i + 1);
    }

    cout.rdbuf(coutbuf);
    cout << mean_ratios[0] << endl;
}

#endif