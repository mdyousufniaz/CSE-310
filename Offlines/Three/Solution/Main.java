import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main {
    public static BufferedWriter parserLogFile;
    public static BufferedWriter errorFile;
    public static BufferedWriter lexLogFile;
    public static SymbolTable symbolTable;

    public static int errorCount = 0;
    public static boolean newScope = true;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java Main <input_file>");
            return;
        }

        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.err.println("Error opening input file: " + args[0]);
            return;
        }

        String outputDirectory = "output/";
        String parserLogFileName = outputDirectory + "parserLog.txt";
        String errorFileName = outputDirectory + "errorLog.txt";
        String lexLogFileName = outputDirectory + "lexerLog.txt";

        new File(outputDirectory).mkdirs();

        parserLogFile = new BufferedWriter(new FileWriter(parserLogFileName));
        errorFile = new BufferedWriter(new FileWriter(errorFileName));
        lexLogFile = new BufferedWriter(new FileWriter(lexLogFileName));

        symbolTable = new SymbolTable();

        // Create lexer and parser
        CharStream input = CharStreams.fromFileName(args[0]);
        C12105125Lexer lexer = new C12105125Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        C12105125Parser parser = new C12105125Parser(tokens);

        // Remove default error listener
        parser.removeErrorListeners();

        // Begin parsing
        ParseTree tree = parser.start();
        // parserLogFile.write("Parse tree: " + tree.toStringTree(parser) + "\n");

        // Close files
        parserLogFile.close();
        errorFile.close();
        lexLogFile.close();

        System.out.println("Parsing completed. Check the output files for details.");
    }
}
