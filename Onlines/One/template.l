%option noyywrap
%option yylineno

%{
    
#include <stdio.h>


%}

%%

%%

int main(int argc, char* argv[]) {
    if (argc < 2) {
        printf("Usage ./lexer <input_file_name>");
        return 0;
    }

    FILE* f_in = fopen(argv[1], "r");
    if (f_in == NULL) {
        printf("File can not be opened!");
        return 0;
    }

    yyin = f_in;
    yylex();
    fclose(yyin);
    return 0;
}