%option noyywrap

%{
    #include <stdio.h>
    int word_count = 0, line_count = 1;
    
    void inc_word_count() {
        word_count++;
    }
    
%}

Letter [a-zA-Z]

%%

[ \t\v] {}

{Letter}+ {
    inc_word_count();
    printf("%s word found.\n", yytext);
}

[\n] {
    line_count++;
}

<<EOF>> {
    printf("Total Line Number: %d and Total Word count: %i", line_count, word_count);
    return 0;
}

. {}

%%

int main(int argc, char* argv[]) {

    if (argc < 2) {
        printf("Usage ./main <input_file_name>");
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
