#!/bin/bash -i

source ~/.bashrc
antlr4 C2105125Lexer.g4 C2105125Parser.g4
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar C2105125*.java SymbolTable.java Types.java Main.java 
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar Main $1
