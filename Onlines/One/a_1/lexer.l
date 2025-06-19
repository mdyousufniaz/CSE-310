%option noyywrap
%option yylineno


%{

char stack[1024];
unsigned short curr_pos=0;

void push(){
    switch (stack[curr_pos++]) {
        case 'v': 
            if (yytext[0] == '<') stack[curr_pos] = '<';
            break;
        case '<':
            if (
                yytext[0] == 'i' ||
                yytext[0] == 'f' ||
                yytext[0] == 'd' ||
                yytext[0] == 'c' ||
                yytext[0] == 'v'
            ) stack[curr_pos] = yytext[0];
            break;
        case 'i':
        case 'd':
        case 'f':
        case 'c':
            if (stack[curr_pos])
    }
}

%}





%%

"vector" {
    push();
}
\< {
    push()
}

\n { }

. {
    printf("Line No. i: Invalid input", yylineno)
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