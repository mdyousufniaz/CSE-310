#!/bin/bash -i

source ~/.bashrc
antlr4 C8086Lexer.g4 C8086Parser.g4
javac -cp .:/usr/local/lib/antlr-4.13.2-complete.jar  C8086*.java Main.java
java -cp .:/usr/local/lib/antlr-4.13.2-complete.jar Main ../input/test1_i.c
