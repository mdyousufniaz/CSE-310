parser grammar C2105125Parser;

options {
    tokenVocab = C2105125Lexer;
}

@header {
    import java.io.BufferedWriter;
    import java.io.IOException;
    import org.antlr.v4.runtime.Token;
    import java.util.LinkedList;
    import java.util.List;
}

@members {
    // helper to write into parserLogFile
    void writeIntoParserLogFile(String message) {
        try {
            Main.parserLogFile.write(message);
            Main.parserLogFile.newLine();
            Main.parserLogFile.flush();
        } catch (IOException e) {
            System.err.println("Parser log error: " + e.getMessage());
        }
    }

    // helper to write into Main.errorFile
    void writeIntoErrorFile(String message) {
        try {
            Main.errorFile.write(message);
            Main.errorFile.newLine();
            Main.errorFile.flush();
        } catch (IOException e) {
            System.err.println("Error file write error: " + e.getMessage());
        }
    }

    void parseLog(
        int line,
        String head,
        String bodyName,
        String bodyText
    ) {
        writeIntoParserLogFile(
            "Line "
            + line
            + ": "
            + head
            + " : "
            + bodyName
            + "\n".repeat(2)
            + bodyText
            + '\n'
        );
    }

    void parseLog(
        int line,
        String head,
        String bodyName,
        String bodyText,
        String errorName
    ) {
        if (errorName == null) {
            parseLog(line, head, bodyName, bodyText);
            return;
        }

        Main.errorCount++;

        String errorMessage = "Error at line " + line + ": " + errorName + '\n';
        writeIntoErrorFile(errorMessage);

        writeIntoParserLogFile(
            "Line "
            + line
            + ": "
            + head
            + " : "
            + bodyName
            + "\n".repeat(2)
            + errorMessage
            + '\n'
            + bodyText
            + '\n'
        );
    }

    String getType(Token token) {
        String type = getVocabulary().getSymbolicName(token.getType());
        if (type == null) {
            type = "UNKNOWN";
        }
        return type;
    }

    boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean insertId(Identifier Id) {
        return Main.symbolTable.insertId(Id);
    }

    void enterScope() {
        Main.symbolTable.enterScope();
    }

    void exitScope() {
        writeIntoParserLogFile(
            Main.symbolTable.toString()
        );
        Main.symbolTable.exitScope();
    }

    Identifier getId(String idName) {
        return Main.symbolTable.getId(idName);
    }

}   

start
    : pm=program
      {
        parseLog(
            $pm.line,
            "start",
            "program",
            Main.symbolTable.toString()
        );

        writeIntoParserLogFile(
            "Total number of lines: "
            + $pm.line
            + "\nTotal number of errors: "
            + Main.errorCount
        );

      }
    ;

program returns [int line, String content] 
    : pm=program unit { 
        $line = $unit.line;
        $content = $pm.content + '\n' + $unit.content;

        parseLog(
            $line,
            "program",
            "program unit",
            $content
        );
    }

    | unit {
        $line = $unit.line;
        $content = $unit.content;

        parseLog(
            $line,
            "program",
            "unit",
            $content
        );
    }

    ;

unit returns [int line, String content]
    : vd=var_declaration 
    {
        $line = $vd.line;
        $content = $vd.content;
        
        parseLog(
            $line,
            "unit",
            "var_declaration",
            $content
        );
    }

    | f_dec=func_declaration 
    {
        $content = $f_dec.content;
        $line = $f_dec.line;

        parseLog(
            $line,
            "unit",
            "func_declaration",
            $content
        );
    }        
    | f_def=func_definition
    {   
        $content = $f_def.content;
        $line = $f_def.line;

        parseLog(
            $line,
            "unit",
            "func_definition",
            $content
        );
    }
    ;

func_declaration returns [int line, String content]
    : ts=type_specifier ID LPAREN pl=parameter_list RPAREN sm=SEMICOLON 
    {          
        insertId(
            new Identifier(
                $ID.getText(), $ts.tokenType, $pl.parameters
            )
        );

        $content = $ts.content + ' ' + $ID.getText() + "();";
        $line = $sm.getLine();

        parseLog(
            $line,
            "func_declaration",
            "type_specifier ID LPAREN RPAREN SEMICOLON",
            $content
        );
    }
    | ts=type_specifier ID LPAREN RPAREN sm=SEMICOLON 
    {
         insertId(
            new Identifier(
                $ID.getText(), $ts.tokenType, null
            )
        );

        $content = $ts.content + ' ' + $ID.getText() + "();";
        $line = $sm.getLine();

        parseLog(
            $line,
            "func_declaration",
            "type_specifier ID LPAREN RPAREN SEMICOLON",
            $content
        );
    }

    ;

func_definition returns [int line, String content] 
    : ts=type_specifier ID
    {
        Identifier funcid = new Identifier(
            $ID.getText(), $ts.tokenType, null
        );

        insertId(funcid);
    } 
    LPAREN pl=parameter_list { funcid.parameters = $pl.parameters; } 
    RPAREN cs=compound_statement [$pl.parameters]
    {
        $line = $cs.line;
        $content = $ts.content 
                    + ' '
                    + $ID.getText()
                    + '('
                    + $pl.content
                    + ')'
                    + $cs.content;

        parseLog(
            $line,
            "func_definition",
            "type_specifier ID LPAREN parameter_list RPAREN compound_statement",
            $content
        );
    }
    | ts=type_specifier ID LPAREN RPAREN cs=compound_statement [null]
    { 
        insertId(
            new Identifier(
                $ID.getText(), $ts.tokenType, null
            )
        );

        $line = $cs.line;
        $content = $ts.content 
                    + ' '
                    + $ID.getText()
                    + "()"
                    + $cs.content;
        
        parseLog(
            $line,
            "func_definition",
            "type_specifier ID LPAREN RPAREN compound_statement",
            $content
        );
    }
    ;

parameter_list returns [String content, List<Identifier> parameters]
    : pl=parameter_list COMMA ts=type_specifier ID
    {
        $parameters = $pl.parameters;
        $parameters.add(
            new Identifier($ID.getText(), $ts.tokenType, null)
        );
        $content = $pl.content + ',' + $ts.content + ' '  + $ID.getText();

        parseLog(
            $ID.getLine(),
            "parameter_list",
            "parameter_list COMMA type_specifier ID",
            $content
        );
    }
    
    | pl=parameter_list COMMA ts=type_specifier
    {
        $content = $pl.content + ',' + $ts.content;

        $parameters = null;
        parseLog(
            $ts.line,
            "parameter_list",
            "parameter_list COMMA type_specifier",
            $content
        );
    }
    | ts=type_specifier ID
    {
        $parameters = new LinkedList<>();
        $parameters.add(
            new Identifier($ID.getText(), $ts.tokenType, null)
        );

        $content = $ts.content + ' ' + $ID.getText();

        parseLog(
            $ID.getLine(),
            "parameter_list",
            "type_specifier ID",
            $content
        );
    }
    | ts=type_specifier
    {
        $parameters = null;
        $content = $ts.content;

        parseLog(
            $ts.line,
            "parameter_list",
            "type_specifier",
            $content
        );
    }
    ;

compound_statement [List<Identifier> parameters]
    returns [int line, String content]
    : LCURL 
    { 
        enterScope();
        if (parameters != null) {
            for (Identifier param : parameters) {
                insertId(param);
                System.out.println(param);
            }
        }
    }
    ss=statements RCURL
    {   
        $line = $RCURL.getLine();
        $content = "{\n" + $ss.content + '\n' + "}";

        parseLog(
            $line,
            "compound_statement",
            "LCURL statements RCURL",
            $content
        );

        exitScope();
    }
    | LCURL
    { 
        enterScope();
    }
     RCURL
    {
        $line = $RCURL.getLine();
        $content = "{\n}\n";

        parseLog(
            $line,
            "compound_statement",
            "LCURL RCURL",
            $content
        );

        exitScope();
    }
    ;

var_declaration returns [int line, String content]
    : t=type_specifier dl=declaration_list sm=SEMICOLON
      {
        for (String idName : $dl.idNames) {
            int dataType = $t.tokenType;
            if (idName.endsWith("[]")) {
                switch (dataType) {
                    case INT:
                        dataType = INT_ARRAY;
                        break;
                    case FLOAT:
                        dataType = FLOAT_ARRAY;
                        break;
                }
            }
            insertId(
                new Identifier(idName, dataType, null)
            );
            
        }

        String type = $t.content;
        $line = $sm.getLine();
        $content = type + ' ' + $dl.content + $sm.getText();

        String errorName = null;
        if (type.equals("void")) errorName = "Variable type cannot be void";
       
        parseLog(
            $line,
            "var_declaration",
            "type_specifier declaration_list SEMICOLON",
            $content,
            errorName
        );
      }
    | t=type_specifier de=declaration_list_err sm=SEMICOLON
      {
        // later
        writeIntoErrorFile(
            "Line# "
            + $sm.getLine()
            + " with error name: "
            + $de.error_name
            + " - Syntax error at declaration list of variable declaration"
        );
        Main.errorCount++;
      }
    ;

declaration_list_err
    returns [String error_name]
    : { $error_name = "Error in declaration list"; }
    ;

type_specifier
    returns [int line, String content, int tokenType]
    : t=(INT | FLOAT | VOID)
      {
        $tokenType = $t.getType();
        $line = $t.getLine();
        $content = $t.getText();
        
        parseLog(
            $line,
            "type_specifier",
            getType($t),
            $content
        );
      }
    ;

declaration_list returns [String content, List<String> idNames]
    : dl=declaration_list COMMA ID 
    {
        $content = $dl.content + "," + $ID.getText();
        $idNames = $dl.idNames;
        $idNames.add($ID.getText());

        parseLog(
            $ID.getLine(),
            "declaration_list",
            "declaration_list COMMA ID",
            $content
        );
    }

    | dl=declaration_list COMMA ID LTHIRD ci=CONST_INT RTHIRD 
    {
        $content = $dl.content + "," + $ID.getText() + '[' + $ci.getText() + ']';

        $idNames = $dl.idNames;
        $idNames.add($ID.getText() + "[]");    

        parseLog(
            $RTHIRD.getLine(),
            "declaration_list",
            "declaration_list COMMA ID LTHIRD CONST_INT RTHIRD",
            $content
        );
    }
    | ID 
    {
        $content = $ID.getText();
        $idNames = new LinkedList<>();

        if (getId($content) != null) { 
            String errorMessage = "Error at line " + $ID.getLine() + " Multiple declaration of " + $content + '\n';

            writeIntoErrorFile(errorMessage);
            writeIntoParserLogFile(errorMessage);

            Main.errorCount++;
        } else {
            $idNames.add($content);
        }
        
        parseLog(
            $ID.getLine(),
            "declaration_list",
            "ID",
            $content
        );
    }
    | ID LTHIRD ci=CONST_INT RTHIRD
    {
        $content = $ID.getText() + '[' + $ci.getText() + ']';

        $idNames = new LinkedList<>();
        $idNames.add($ID.getText() + "[]");

        parseLog(
            $RTHIRD.getLine(),
            "declaration_list",
            "ID LTHIRD CONST_INT RTHIRD",
            $content
        );
    }
    ;

statements returns [int line, String content]
    : s=statement
    {
        $line = $s.line;
        $content = $s.content;

        parseLog(
            $line,
            "statements",
            "statement",
            $content
        );
    }
    | ss=statements s=statement
    {
        $line = $s.line;
        $content = $ss.content + '\n' + $s.content;

        parseLog(
            $line,
            "statements",
            "statements statement",
            $content
        );
    }
    ;

statement returns [int line, String content]
    : vd=var_declaration
    {
        $line = $vd.line;
        $content = $vd.content;

        parseLog(
            $line,
            "statement",
            "var_declaration",
            $content
        );
    }
    | es=expression_statement
    {
        $line = $es.line;
        $content = $es.content;

        parseLog(
            $line,
            "statement",
            "expression_statement",
            $content
        );
    }
    | cs=compound_statement [null]
    {
        $line = $cs.line;
        $content = $cs.content;

        parseLog(
            $line,
            "statement",
            "compound_statement",
            $content
        );
    }
    | FOR LPAREN es1=expression_statement es2=expression_statement es3=expression RPAREN s=statement
    {
        $line = $s.line;
        $content = "for (" + $es1.content + $es2.content + $es3.content + ") " + $s.content;

        parseLog(
            $line,
            "statement",
            "FOR LPAREN expression_statement expression_statement expression RPAREN statement",
            $content
        );
    }
    | IF LPAREN e=expression RPAREN s=statement
    {
        $line = $s.line;
        $content = "if (" + $e.content + ") " + $s.content;

        parseLog(
            $line,
            "statement",
            "IF LPAREN expression RPAREN statement",
            $content
        );
    }
    | IF LPAREN e=expression RPAREN s1=statement ELSE s2=statement
    {   
        $line = $s2.line;
        $content = "if (" + $e.content + ") " + $s1.content + "else " + $s2.content;

        parseLog(
            $line,
            "statement",
            "IF LPAREN expression RPAREN statement ELSE statement",
            $content
        );
    } 
    | WHILE LPAREN e=expression RPAREN s=statement
    {
        $line = $s.line;
        $content = "while (" + $e.content + ") " + $s.content;

        parseLog(
            $line,
            "statement",
            "WHILE LPAREN expression RPAREN statement",
            $content
        );
    }
    | PRINTLN LPAREN ID RPAREN sm=SEMICOLON
    {
        $line = $sm.getLine();
        $content = "println(" + $ID.getText() + ");\n";

        parseLog(
            $line,
            "statement",
            "PRINTLN LPAREN ID RPAREN SEMICOLON",
            $content
        );
    }
    | RETURN e=expression sm=SEMICOLON
    {
        $line = $sm.getLine();
        $content = "return " + $e.content + ";";

        parseLog(
            $line,
            "statement",
            "RETURN expression SEMICOLON",
            $content
        );
    }
    ;

expression_statement returns [int line, String content]
    : sm=SEMICOLON
    {
        $line = $sm.getLine();
        $content = ";";

        parseLog(
            $line,
            "expression_statement",
            "SEMICOLON",
            $content
        );
    }
    | e=expression sm=SEMICOLON
    {
        $line = $sm.getLine();
        $content = $e.content + ';';

        parseLog(
            $line,
            "expression_statement",
            "expression SEMICOLON",
            $content
        );
    }
    ;

variable returns [int line, String content]
    : ID
    {

        $line = $ID.getLine();
        $content = $ID.getText();

        parseLog(
            $line,
            "variable",
            "ID",
            $content
        );
    }

    | ID LTHIRD e=expression RTHIRD
    {

        $line = $RTHIRD.getLine();
        String index = $e.content;
        $content = $ID.getText() + '[' + index + ']';

        String errorName;
        if (!isInteger(index)) {
            errorName = "Expression inside third brackets not an integer";
        } else {
            errorName = null;
        }

        parseLog(
            $line,
            "variable",
            "ID LTHIRD expression RTHIRD",
            $content,
            errorName
        );
    }
    ;

expression returns [int line, String content]
    : le=logic_expression
    {
        $line = $le.line;
        $content = $le.content;

        parseLog(
            $line,
            "expression",
            "logic_expression",
            $content
        );
    }
    | var=variable ASSIGNOP le=logic_expression
    {

        $line = $le.line;
        $content = $var.content + '=' + $le.content;

        String errorName = null;
        Identifier id = getId($var.content);
        if (id != null) {
            if (
                (id.type == INT && !isInteger($le.content)) ||
                (id.type == FLOAT && isInteger($le.content))
            ) errorName = "Type Mismatch";
        }

        parseLog(
            $line,
            "expression",
            "variable ASSIGNOP logic_expression",
            $content,
            errorName
        );
    }
    ;

logic_expression returns [int line, String content]
    : re=rel_expression
    {
        $line = $re.line;
        $content = $re.content;

        parseLog(
            $line,
            "logic_expression",
            "rel_expression",
            $content
        );
    }
    | re1=rel_expression LOGICOP re2=rel_expression
    {
        $line = $re2.line;
        $content = $re1.content + $LOGICOP.getText() + $re2.content;

        parseLog(
            $line,
            "logic_expression",
            "rel_expression LOGICOP rel_expression",
            $content
        );
    }
    ;

rel_expression returns [int line, String content]
    : se=simple_expression
    {
        $line = $se.line;
        $content = $se.content;

        parseLog(
            $line,
            "rel_expression",
            "simple_expression",
            $content
        );
    }
    | se1=simple_expression RELOP se2=simple_expression
    {
        $line = $se2.line;
        $content = $se1.content + $RELOP.getText() + $se2.content;

        parseLog(
            $line,
            "rel_expression",
            "simple_expression RELOP simple_expression",
            $content
        );
    }
    ;

simple_expression returns [int line, String content]
    : t=term
    {
        $line = $t.line;
        $content = $t.content;

        parseLog(
            $line,
            "simple_expression",
            "term",
            $content
        );
    }
    | se=simple_expression ADDOP t=term
    {
        $line = $t.line;
        $content = $se.content + $ADDOP.getText() + $t.content;

        parseLog(
            $line,
            "simple_expression",
            "simple_expression ADDOP term",
            $content
        );
    }
    ;

term returns [int line, String content]
    : ue=unary_expression
    {
        $line = $ue.line;
        $content = $ue.content;

        parseLog(
            $line,
            "term",
            "unary_expression",
            $content
        );
    }
    | t=term m=MULOP ue=unary_expression
    {
        $line = $ue.line;
        String op = $m.getText();
        String second = $ue.content;
        
        $content = $t.content + op + second;

        String errorName = null;
        if (op.equals("%")) {
            if (!isInteger(second)) {
                errorName = "Non-Integer operand on modulus operator";
            } else if (Integer.parseInt(second) == 0) {
                errorName = "Modulus by Zero";
            }
        }

        parseLog(
            $line,
            "term",
            "term MULOP unary_expression",
            $content,
            errorName
        );
    }
    ;

unary_expression returns [int line, String content]
    : ADDOP ue=unary_expression
    {
        $line = $ue.line;
        $content = $ADDOP.getText() + $ue.content;

        parseLog(
            $line,
            "unary_expression",
            "ADDOP unary_expression",
            $content
        );
    }
    | NOT ue=unary_expression
    {
        $line = $ue.line;
        $content = $NOT.getText() + $ue.content;

        parseLog(
            $line,
            "unary_expression",
            "NOT unary_expression",
            $content
        );
    }
    | f=factor
    {
        $line = $f.line;
        $content = $f.content;

        parseLog(
            $line,
            "unary_expression",
            "factor",
            $content
        );
    }

    ;

factor returns [int line, String content]
    : var=variable
    {
        $line = $var.line;
        $content = $var.content;

        parseLog(
            $line,
            "factor",
            "variable",
            $content
        );
    }

    | ID LPAREN al=argument_list RPAREN
    {
        $line = $RPAREN.getLine();
        $content = $ID.getText() + '(' + $al.content + ')';

        parseLog(
            $line,
            "factor",
            "ID LPAREN argument_list RPAREN",
            $content
        );
    }
    | LPAREN e=expression RPAREN
    {
        $line = $RPAREN.getLine();
        $content = '(' + $e.content + ')';

        parseLog(
            $line,
            "factor",
            "LPAREN expression RPAREN",
            $content
        );
    }
    | cl=( CONST_INT | CONST_FLOAT )
    {
        $line = $cl.getLine();
        $content = $cl.getText();

        parseLog(
            $line,
            "factor",
            getType($cl),
            $content
        );
    }
    | var=variable do=( INCOP | DECOP )
    {
        $line = $var.line;
        $content = $var.content + $do.getText();

        parseLog(
            $line,
            "factor",
            "variable " + getType($do),
            $content
        );
    }
    ;

argument_list returns [int line, String content]
    : as=arguments
    {
        $line = $as.line;
        $content = $as.content;

        parseLog(
            $line,
            "argument_list",
            "arguments",
            $content
        );
    }
    | /* empty */
    ;

arguments returns [int line, String content]
    : as=arguments COMMA le=logic_expression
    {
        $line = $le.line;
        $content = $as.content + ',' + $le.content;
        parseLog(
            $line,
            "arguments",
            "arguments COMMA logic_expression",
            $content
        );
    }
    | le=logic_expression
    {
        $line = $le.line;
        $content = $le.content;

        parseLog(
            $line,
            "arguments",
            "logic_expression",
            $content
        );
    }
    ;
