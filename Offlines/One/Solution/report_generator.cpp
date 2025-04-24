#include "utils.hpp"
#include <iostream>

#include <sys/stat.h>

using namespace std;

int main(int argc, char* argv[]) {

    string hash_func_names[] = {
        "SDBM_Hash",
        "DJB2aHash",
        "FNV1aHash"
    };

    unsigned int hash_func_count = 3;
    float mean_ratios[hash_func_count];
    streambuf* coutbuf = cout.rdbuf();
    const string output_dir = "Outputs";

    struct stat sb;
    if (!(stat("Outputs", &sb) == 0 && S_ISDIR(sb.st_mode))) mkdir("Outputs", 0777);

    for (unsigned int i = 0; i < hash_func_count; i++) {
        const string output_file_name = output_dir + '/' + hash_func_names[i] + ".txt";
        mean_ratios[i] = process_symbol_table(argv[1], output_file_name, i + 1);
    }

    ofstream report_file = get_output_file("report.csv");
    cout << "Hash Function,Mean Ratio" << endl;
    for (unsigned int i = 0; i < hash_func_count; i++) 
        cout << hash_func_names[i] << "," << mean_ratios[i] << endl;

    report_file.close();
    cout.rdbuf(coutbuf);

    return 0;
}