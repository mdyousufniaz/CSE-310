#!/bin/bash

# Use the first argument as the filename (default to 'main' if not provided)
filename=${1}

# Compile the corresponding .cpp file
g++ -fsanitize=address "$filename.cpp" -o "$filename"

# Path to input file
input_file="/workspaces/CSE-310/Offlines/One/Solution/demo.txt"

# Run the compiled binary
./"$filename" "$input_file"
