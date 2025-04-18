#!/bin/bash

# Use the first argument as the filename (default to 'main' if not provided)
filename=${1}

# Compile the corresponding .cpp file
g++ -fsanitize=address "$filename.cpp" -o "$filename"