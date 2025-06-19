%option noyywrap
%option yylineno

%x IN_VECTOR

%{
#include <stdio.h>
#include <string.h>
char vector_buff[1024];
unsigned int nested_level = 0;
%}

WS      [ \t]+
TYPE    (int|float|double|char)
VECTOR  vector
ANGLE_OPEN <
ANGLE_CLOSE >

%%

<INITIAL>{VECTOR} {
    strcpy(vector_buff, "vector");
    nested_level = 0;
    BEGIN(IN_VECTOR);
}

<INITIAL>\n {
    /* Ignore empty lines */
}

<INITIAL>. {
    printf("Line no: %d: Invalid input\n", yylineno);
}

<IN_VECTOR>{WS} {
    strcat(vector_buff, yytext);
}

<IN_VECTOR>{ANGLE_OPEN} {
    strcat(vector_buff, "<");
    nested_level++;
}

<IN_VECTOR>{ANGLE_CLOSE} {
    strcat(vector_buff, ">");  // Fixed: was adding "<" instead of ">"
    nested_level--;

    if (nested_level == 0) {
        printf("Line no %d: Token <VECTOR_TYPE> Lexeme %s found\n", yylineno, vector_buff);
        BEGIN(INITIAL);
    }
}

<IN_VECTOR>{TYPE} {
    strcat(vector_buff, yytext);
}

<IN_VECTOR>{VECTOR} {
    strcat(vector_buff, "vector");  // Fixed: was resetting instead of appending
}

<IN_VECTOR>.|\n {
    printf("Line no %d: Error in <VECTOR_TYPE> declaration\n", yylineno);
    BEGIN(INITIAL);
}

<INITIAL><<EOF>> {
    return 0;
}

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