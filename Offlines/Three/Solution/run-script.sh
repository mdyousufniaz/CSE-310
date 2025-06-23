#!/bin/bash -i

source ~/.bashrc
antlr4 C12105125Lexer.g4 C12105125Parser.g4
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar C12105125*.java SymbolTable.java Types.java Main.java 
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar Main $1
