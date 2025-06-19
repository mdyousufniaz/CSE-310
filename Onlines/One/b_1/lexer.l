%option noyywrap

%{
    
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char bracket_buff[1024];
unsigned short curr_pos = 0;

void push() {
    bracket_buff[curr_pos++] = yytext[0];
   // bracket_buff[curr_pos] = '\0';
}

void error() {
    printf("Unmatched brackets\n");
    exit(1);
}

void pop() {
    if (curr_pos == 0) error();
    
    switch (bracket_buff[--curr_pos]) {
        case '(':
            if (yytext[0] != ')') error();
            break;
        case '{':
            if (yytext[0] != '}') error();
            break;
        case '[':
            if (yytext[0] != ']') error();
            break;
    }
}

%}

%%

\(|\{|\[ {
    push();
}

\)|\}|\] {
    pop();
}

<<EOF>> {
    if (curr_pos != 0) error();
    printf("Matched!\n");
    exit(0);
}



%%

int main() {

    yylex();
    return 0;
}