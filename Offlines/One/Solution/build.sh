#!/bin/bash

# builds main.cpp -> main
g++ -fsanitize=address main.cpp -o main