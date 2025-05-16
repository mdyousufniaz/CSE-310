%option noyywrap
%option yylineno

%x COMMENT_SINGLE
%x COMMENT_MULTI

%{

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "symbol_table.h"

#define BUF_SIZE 8192
char comment_buf[BUF_SIZE];
int comment_pos = 0;
unsigned short comment_line;


void reset_comment_buf() {
    comment_pos = 0;
    comment_buf[0] = '\0';
}

void append_to_comment_buf(const char* text) {
    int len = strlen(text);
    if (comment_pos + len < BUF_SIZE - 1) {
        strcpy(&comment_buf[comment_pos], text);
        comment_pos += len;
    }
}

const char* IF = "IF";
const char* FOR = "FOR";
const char* DO = "DO";
const char* INT = "INT";
const char* FLOAT = "FLOAT";
const char* VOID = "VOID";
const char* SWITCH = "SWITCH";
const char* DEFAULT = "DEFAULT";
const char* ELSE = "ELSE";
const char* WHILE = "WHILE";
const char* BREAK = "BREAK";
const char* CHAR = "CHAR";
const char* DOUBLE = "DOUBLE";
const char* RETURN = "RETURN";
const char* CASE = "CASE";
const char* CONTINUE = "CONTINUE";
const char* GOTO = "GOTO";
const char* LONG = "LONG";
const char* SHORT = "SHORT";
const char* STATIC = "STATIC";
const char* UNSIGNED = "UNSIGNED";

const char* CONST_INT = "CONST_INT";
const char* CONST_FLOAT = "CONST_FLOAT";
const char* CONST_CHAR = "CONST_CHAR";

const char* ADDOP = "ADDOP";
const char* MULOP = "MULOP";
const char* INCOP = "INCOP";
const char* RELOP = "RELOP";
const char* ASSIGNOP = "ASSIGNOP";
const char* LOGICOP = "LOGICOP";
const char* NOT = "NOT";
const char* LPAREN = "LPAREN";
const char* RPAREN = "RPAREN";
const char* LCURL = "LCURL";
const char* RCURL = "RCURL";
const char* LTHIRD = "LTHIRD";
const char* RTHIRD = "RTHIRD";

const char* COMMA = "COMMA";
const char* SEMICOLON = "SEMICOLON";

const char* ID = "ID";
const char* STRING = "STRING";
const char* COMMENT = "COMMENT";

const unsigned char LOG_WITHOUT_VALUE = 0;
const unsigned char LOG_WITH_VALUE = 1;
const unsigned char INSERT_IN_SYMBOL_TABLE = 2;

FILE* log_file = NULL;
FILE* token_file = NULL;

SymbolTable* symbol_table = NULL;
unsigned short error_count = 0;

unsigned char is_same(const char* first, const char* second) {
    return strcmp(first, second) == 0;
}

char get_char() {
    char first_char = yytext[1];
    if (first_char != '\\') return first_char;

    switch (yytext[2]) {
        case 'n': return '\n';
        case 't': return '\t';
        case '\\': return '\\';
        case '\'': return '\'';
        case 'a': return '\a';
        case 'f': return '\f';
        case 'r': return '\r';
        case 'b': return '\b';
        case 'v': return '\v';
        case '0': return '\0';
        default: return '\0';
    }
}

unsigned char get_priority(const char* token_name) {
    if (
        is_same(token_name, ADDOP) ||
        is_same(token_name, MULOP) ||
        is_same(token_name, INCOP) ||
        is_same(token_name, RELOP) ||
        is_same(token_name, ASSIGNOP) ||
        is_same(token_name, LOGICOP) ||
        is_same(token_name, NOT) ||
        is_same(token_name, LPAREN) ||
        is_same(token_name, RPAREN) ||
        is_same(token_name, LCURL) ||
        is_same(token_name, RCURL) ||
        is_same(token_name, LTHIRD) ||
        is_same(token_name, RTHIRD) ||
        is_same(token_name, COMMA) ||
        is_same(token_name, SEMICOLON) ||
        is_same(token_name, STRING)
    ) return LOG_WITH_VALUE;

    if (
        is_same(token_name, CONST_INT) ||
        is_same(token_name, CONST_FLOAT) ||
        is_same(token_name, CONST_CHAR) ||
        is_same(token_name, ID)
    ) return INSERT_IN_SYMBOL_TABLE;

    return LOG_WITHOUT_VALUE;
}

void process_token(const char* token_name) {
    if (is_same(token_name, COMMENT)) {
        fprintf(log_file, "Line no %i: Token <%s> Lexeme %s found\n\n", comment_line, token_name, comment_buf);
        return;
    } 
    unsigned char priority = get_priority(token_name);

    unsigned int token_size = strlen(token_name) + 3;
    if (priority >= LOG_WITH_VALUE) token_size += strlen(yytext) + 2;

    char* token = (char*) malloc(token_size * sizeof(char));
    if (priority >= LOG_WITH_VALUE) {
        if (is_same(token_name, CONST_CHAR)) sprintf(token, "<%s, %c>", token_name, get_char());
        else if (is_same(token_name, STRING)) {
            char* modified_string = (char*) malloc(strlen(yytext) * sizeof(char));;
            unsigned short curr_len = 0;
            for (unsigned short i = 1; i < strlen(yytext) - 1; i++) {
                char ch = yytext[i];
                if (ch == '\\' || ch == '\n') continue;
                modified_string[curr_len++] = ch;
            }
            modified_string[curr_len] = '\0';
            sprintf(token, "<%s, %s>", token_name, modified_string);
            free(modified_string);
        }
        else sprintf(token, "<%s, %s>", token_name, yytext);
    }
    else sprintf(token, "<%s>", token_name);
    fprintf(token_file, "%s ", token);
    fprintf(log_file, "Line no %i: Token <%s> Lexeme %s found", yylineno, token_name, yytext);

    if (is_same(token_name, CONST_CHAR) || is_same(token_name, STRING)) fprintf(log_file, " --> %s", token);

    fprintf(log_file, "\n\n");

    free(token);

    if (priority >= INSERT_IN_SYMBOL_TABLE) {
        if (insert_symbol_table(log_file, symbol_table, yytext, token_name) == 1) 
        print_symbol_table(log_file, symbol_table);
    }  
}

int count_newlines(const char *str) {
    int count = 0;
    while (*str) {
        if (*str == '\n') {
            count++;
        }
        str++;
    }
    return count;
}

%}

ALPHA [_[:alpha:]]
ALNUM [_[:alnum:]]
PLUS \+
MINUS \-
PLUS_MINUS [+-]
GREATER \>
LESS \<
EQUAL \=
BANG \!
AND \&
OR \|
DIGIT [0-9]
INTEGER {DIGIT}+
EXPONENT E{PLUS_MINUS}?{INTEGER}
DOT \.
SINGLE_QUOTE '
BACK_SLASH \\
DQUOTE \"
STRING_ORDINARY_CHAR [^"\\\n]
STRING_ESCAPE \\([nt\\\'afbrv0?"])
LINE_CONTINUATION \\[\ \t]*\n

%%

if { process_token(IF); }
for { process_token(FOR); }
do { process_token(DO); }
int { process_token(INT); }
float { process_token(FLOAT); }
void { process_token(VOID); }
switch { process_token(SWITCH); }
default { process_token(DEFAULT); }
else { process_token(ELSE); }
while { process_token(WHILE); }
break { process_token(BREAK); }
char { process_token(CHAR); }
double { process_token(DOUBLE); }
return { process_token(RETURN); }
case { process_token(CASE); }
continue { process_token(CONTINUE); }
goto { process_token(GOTO); }
long { process_token(LONG); }
short { process_token(SHORT); }
static { process_token(STATIC); }
unsigned { process_token(UNSIGNED); }

"//"            {
                    reset_comment_buf();
                    append_to_comment_buf(yytext);
                    BEGIN(COMMENT_SINGLE);
                }

"/*"            {
                    reset_comment_buf();
                    append_to_comment_buf(yytext);
                    comment_line = yylineno;
                    BEGIN(COMMENT_MULTI);
                }

<COMMENT_SINGLE>"\\\n"  {
                    append_to_comment_buf(yytext);
                }

<COMMENT_SINGLE>\n      {
                    append_to_comment_buf(yytext);
                    
                    int len = strlen(comment_buf);
                    if (len > 0 && comment_buf[len - 1] == '\n') {
                        comment_buf[len - 1] = '\0';
                    }
                    comment_line = yylineno - 1;
                    process_token(COMMENT);
                    BEGIN(INITIAL);
                }

<COMMENT_SINGLE><<EOF>> {
                    comment_line = yylineno;
                    process_token(COMMENT);
                    BEGIN(INITIAL);
                }

<COMMENT_SINGLE>.       {
                    append_to_comment_buf(yytext);
                }

<COMMENT_MULTI>"*/"     {
                    append_to_comment_buf(yytext);
                    comment_line = yylineno;
                    process_token(COMMENT);
                    BEGIN(INITIAL);
                }

<COMMENT_MULTI>\n       {
                    append_to_comment_buf(yytext);
                }

<COMMENT_MULTI><<EOF>>  {
                    fprintf(log_file, "Error at line no %d: Unterminated comment %s\n\n", comment_line, comment_buf);
    error_count++;
                    BEGIN(INITIAL);
                }

<COMMENT_MULTI>.        {
                    append_to_comment_buf(yytext);
                }


{PLUS}{2}|{MINUS}{2} { process_token(INCOP); }
{PLUS_MINUS} { process_token(ADDOP); }
[*/%] { process_token(MULOP); }

{LESS}|{LESS}{EQUAL}|{GREATER}|{GREATER}{EQUAL}|{EQUAL}{2}|{BANG}{EQUAL} {
    process_token(RELOP);
}

{EQUAL} { process_token(ASSIGNOP); }
{AND}{2}|{OR}{2} { process_token(LOGICOP); }
{BANG} { process_token(NOT); }
\( { process_token(LPAREN); }
\) { process_token(RPAREN); }

\{ {
    process_token(LCURL);
    enter_scope(symbol_table);
}

\} {
    process_token(RCURL);
    exit_scope(symbol_table);
}

\[ { process_token(LTHIRD); }
\] { process_token(RTHIRD); }
\, { process_token(COMMA); }
\; { process_token(SEMICOLON); }

{INTEGER}{ALPHA}{ALNUM}* {
    fprintf(log_file, "Error at line no %d: Invalid prefix on ID or invalid suffix on Number %s\n\n", yylineno, yytext);
    error_count++;
}

({DIGIT}*(\.){DIGIT}*){2,}([E][+-]?({DIGIT}*(\.){DIGIT}*)+)? {
    fprintf(log_file, "Error at line no %d: Too many decimal points %s\n\n\n", yylineno, yytext);
    error_count++;
}

([E][+-]?({DIGIT}*(\.){DIGIT}*)+) {
    fprintf(log_file, "Error at line no %d: Malformed exponent part in number %s\n\n\n", yylineno, yytext);
    error_count++;
}



{INTEGER}{EXPONENT}\.{DIGIT}+ {
    fprintf(log_file, "Error at line no %d: Ill formed number %s\n\n\n", yylineno, yytext);
    error_count++;
}


{INTEGER}{DOT}{DIGIT}*({EXPONENT})?|{DOT}{INTEGER}({EXPONENT})?|{INTEGER}{EXPONENT} {
     process_token(CONST_FLOAT); 
}

{INTEGER} { process_token(CONST_INT); }

{SINGLE_QUOTE}\n {
    fprintf(log_file, "Error at line no %d: Unterminated character %s\n\n", yylineno - 1, yytext);
    error_count++;
}

{SINGLE_QUOTE}([^\\'\n]|{BACK_SLASH}.)?\n {
    fprintf(log_file, "Error at line no %d: Unterminated character %s\n\n", yylineno - 1, yytext);
    error_count++;
}

{SINGLE_QUOTE}([^\\'\n]|{BACK_SLASH}.{2,}){2,}{SINGLE_QUOTE} {
    fprintf(log_file, "Error at line no %d: Multi character constant error %s\n\n\n", yylineno, yytext);
    error_count++;
}

{SINGLE_QUOTE}{SINGLE_QUOTE} {
    fprintf(log_file, "Error at line no %d: Empty character constant error %s\n\n\n", yylineno, yytext);
    error_count++;
}

{SINGLE_QUOTE}[^{SINGLE_QUOTE}{BACK_SLASH}\n]{SINGLE_QUOTE}|{SINGLE_QUOTE}{BACK_SLASH}[{BACK_SLASH}{SINGLE_QUOTE}ntafbrv0?]{SINGLE_QUOTE} {
    process_token(CONST_CHAR);
}

{DQUOTE}([^"\\\n]|{STRING_ESCAPE}|{LINE_CONTINUATION})* {
    unsigned short count = 0;

    fprintf(log_file, "Error at line no %d: Unterminated string %s\n\n", yylineno -  count_newlines(yytext), yytext);
    error_count++;
}


{DQUOTE}({STRING_ORDINARY_CHAR}|{STRING_ESCAPE}|{LINE_CONTINUATION})*{DQUOTE} {
    process_token(STRING);
}

{ALPHA}{ALNUM}* {
    process_token(ID);
}

[^a-zA-Z0-9_{}();,+\-*/%<>=!&|^~\[\]'" \t\r\n] {
    fprintf(log_file, "Error at line no %d: Unrecognized character %s\n\n", yylineno, yytext);
    error_count++;
}


[ \n] { }



<<EOF>> {
    print_symbol_table(log_file, symbol_table);
    fprintf(log_file, "Total lines: %d\n", yylineno);
    fprintf(log_file, "Total errors: %d\n", error_count);
    return 0;
}

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

    log_file = fopen("_log.txt", "w");
    token_file = fopen("_token.txt", "w");
    symbol_table = create_symbol_table();
    yyin = f_in;
    yylex();
    fclose(yyin);

    if (log_file != NULL) fclose(log_file);
    if (token_file != NULL) fclose(token_file);
    free_symbol_table(symbol_table);

    return 0;
}