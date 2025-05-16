#!/bin/bash

# Exit immediately if a command exits with a non-zero status.
set -e

readonly INPUT_DIR="../IO/sample_input"
readonly OUTPUT_DIR="../IO/sample_output"

readonly DIFF_HEAD_LINES=10 # You can change this number, e.g., to 5

# Ensure input and output directories exist
if [ ! -d "$INPUT_DIR" ]; then
    echo "Error: Input directory not found: $INPUT_DIR"
    exit 1
fi

if [ ! -d "$OUTPUT_DIR" ]; then
    echo "Error: Output directory not found: $OUTPUT_DIR"
    exit 1
fi

# --- Compilation ---
echo "Compiling lexer..."
flex lexer.flex
if [ $? -ne 0 ]; then
    echo "Error: flex compilation failed."
    exit 1
fi

gcc lex.yy.c symbol_table.c -o lexer -lm
if [ $? -ne 0 ]; then
    echo "Error: g++ compilation failed."
    exit 1
fi
echo "Compilation successful."

# --- Processing and Testing ---
echo "Running lexer and comparing outputs..."

# Find all input files matching the pattern
input_files=$(find "$INPUT_DIR" -maxdepth 1 -name "input*.txt" | sort)

if [ -z "$input_files" ]; then
    echo "No input files found matching input*.txt in $INPUT_DIR"
    exit 1
fi

# Loop through each input file
for input_file in $input_files; do
    # Extract the base name (e.g., input1 from ../IO/sample_input/input1.txt)
    input_base=$(basename "$input_file" .txt)

    echo "Processing $input_file..."

    # Define expected output file paths
    expected_log_output="$OUTPUT_DIR/${input_base}_log.txt"
    expected_token_output="$OUTPUT_DIR/${input_base}_token.txt"

    # Check if expected output files exist
    if [ ! -f "$expected_log_output" ]; then
        echo "Warning: Expected log output file not found: $expected_log_output. Skipping comparison for this input."
        continue # Skip to the next input file
    fi
    if [ ! -f "$expected_token_output" ]; then
         echo "Warning: Expected token output file not found: $expected_token_output. Skipping comparison for this input."
         continue # Skip to the next input file
    fi


    # Run the lexer on the input file
    # The lexer C code is assumed to write to _log.txt and _token.txt
    ./lexer "$input_file"
    lexer_exit_status=$?

    # Check if the lexer ran successfully
    if [ $lexer_exit_status -ne 0 ]; then
        echo "Error: Lexer exited with status $lexer_exit_status for input $input_file"
        # Clean up potential partial output files before exiting
        if [ -f "_log.txt" ]; then rm "_log.txt"; fi
        if [ -f "_token.txt" ]; then rm "_token.txt"; fi
        exit 1
    fi

    # Define temporary actual output file paths
    actual_log_output="${input_base}_log.actual.txt"
    actual_token_output="${input_base}_token.actual.txt"

    # Rename/move the lexer's output files to temporary files
    if [ -f "_log.txt" ]; then
        cp "_log.txt" "$actual_log_output"
    else
        echo "Error: Lexer did not produce expected output file _log.txt for input $input_file"
        exit 1
    fi

     if [ -f "_token.txt" ]; then
        cp "_token.txt" "$actual_token_output"
    else
        echo "Error: Lexer did not produce expected output file _token.txt for input $input_file"
        # Clean up the moved log file
        if [ -f "$actual_log_output" ]; then rm "$actual_log_output"; fi
        exit 1
    fi


    # Compare the generated log file with the expected log file
    echo "Comparing log output for $input_base..."

    if diff_log_output=$(diff -u "$actual_log_output" "$expected_log_output"); then
        # Files match
        echo "Log outputs for $input_base match."
         # Clean up temporary files if they matched
        # rm "$actual_log_output"
    else
        # Files do NOT match
        echo "Mismatch found in log output for $input_base!"
        echo "Showing head of differences (first ${DIFF_HEAD_LINES} lines):"
        echo "$diff_log_output" | head -n "$DIFF_HEAD_LINES"
        # Clean up temporary files before exiting
        if [ -f "$actual_log_output" ]; then rm "$actual_log_output"; fi
        if [ -f "$actual_token_output" ]; then rm "$actual_token_output"; fi # Clean up the token file too
        exit 1 # Exit immediately on first mismatch
    fi

    # --- Compare Token File ---
    # Only compare token file if log file matched and was cleaned up
    echo "Comparing token output for $input_base..."
    # Run diff and capture output and status
    if diff_token_output=$(diff -u "$actual_token_output" "$expected_token_output"); then
        # Files match
        echo "Token outputs for $input_base match."
        # Clean up temporary files if they matched
        # rm "$actual_token_output"
    else
         # Files do NOT match
        echo "Mismatch found in token output for $input_base!"
        echo "Showing head of differences (first ${DIFF_HEAD_LINES} lines):"
        echo "$diff_token_output" | head -n "$"
         # Clean up temporary files before exiting
        if [ -f "$actual_log_output" ]; then rm "$actual_log_output"; fi # Should already be gone if log matched, but safe check
        if [ -f "$actual_token_output" ]; then rm "$actual_token_output"; fi
        exit 1 # Exit immediately on first mismatch
    fi

done

echo "All tests passed! Generated outputs match sample outputs."

# Optional: Clean up the generated lexer executable and C file
# rm lexer lex.yy.c