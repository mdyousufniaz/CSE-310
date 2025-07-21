// Generated from C2105125Parser.g4 by ANTLR 4.13.2

    import java.io.BufferedWriter;
    import java.io.IOException;
    import org.antlr.v4.runtime.Token;
    import java.util.LinkedList;
    import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class C2105125Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, FOR=7, 
		WHILE=8, PRINTLN=9, RETURN=10, INT=11, FLOAT=12, VOID=13, LPAREN=14, RPAREN=15, 
		LCURL=16, RCURL=17, LTHIRD=18, RTHIRD=19, SEMICOLON=20, COMMA=21, ADDOP=22, 
		SUBOP=23, MULOP=24, INCOP=25, DECOP=26, NOT=27, RELOP=28, LOGICOP=29, 
		ASSIGNOP=30, ID=31, CONST_INT=32, CONST_FLOAT=33, INT_ARRAY=34, FLOAT_ARRAY=35;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_declaration_list_err = 8, RULE_type_specifier = 9, 
		RULE_declaration_list = 10, RULE_statements = 11, RULE_statement = 12, 
		RULE_expression_statement = 13, RULE_variable = 14, RULE_expression = 15, 
		RULE_logic_expression = 16, RULE_rel_expression = 17, RULE_simple_expression = 18, 
		RULE_term = 19, RULE_unary_expression = 20, RULE_factor = 21, RULE_argument_list = 22, 
		RULE_arguments = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "declaration_list_err", "type_specifier", 
			"declaration_list", "statements", "statement", "expression_statement", 
			"variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
			"term", "unary_expression", "factor", "argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'println'", 
			"'return'", "'int'", "'float'", "'void'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "','", null, null, null, "'++'", "'--'", "'!'", 
			null, null, "'='", null, null, null, "'INT_ARRAY'", "'FLOAT_ARRAY'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "LPAREN", 
			"RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", 
			"ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
			"ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT", "INT_ARRAY", "FLOAT_ARRAY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C2105125Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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


	public C2105125Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext pm;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((StartContext)_localctx).pm = program(0);

			        parseLog(
			            ((StartContext)_localctx).pm.line,
			            "start",
			            "program",
			            Main.symbolTable.toString()
			        );

			        writeIntoParserLogFile(
			            "Total number of lines: "
			            + ((StartContext)_localctx).pm.line
			            + "\nTotal number of errors: "
			            + Main.errorCount
			        );

			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public int line;
		public String content;
		public ProgramContext pm;
		public UnitContext unit;
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(52);
			((ProgramContext)_localctx).unit = unit();

			        ((ProgramContext)_localctx).line =  ((ProgramContext)_localctx).unit.line;
			        ((ProgramContext)_localctx).content =  ((ProgramContext)_localctx).unit.content;

			        parseLog(
			            _localctx.line,
			            "program",
			            "unit",
			            _localctx.content
			        );
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					_localctx.pm = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(55);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(56);
					((ProgramContext)_localctx).unit = unit();
					 
					                  ((ProgramContext)_localctx).line =  ((ProgramContext)_localctx).unit.line;
					                  ((ProgramContext)_localctx).content =  ((ProgramContext)_localctx).pm.content + '\n' + ((ProgramContext)_localctx).unit.content;

					                  parseLog(
					                      _localctx.line,
					                      "program",
					                      "program unit",
					                      _localctx.content
					                  );
					              
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public int line;
		public String content;
		public Var_declarationContext vd;
		public Func_declarationContext f_dec;
		public Func_definitionContext f_def;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((UnitContext)_localctx).vd = var_declaration();

				        ((UnitContext)_localctx).line =  ((UnitContext)_localctx).vd.line;
				        ((UnitContext)_localctx).content =  ((UnitContext)_localctx).vd.content;
				        
				        parseLog(
				            _localctx.line,
				            "unit",
				            "var_declaration",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				((UnitContext)_localctx).f_dec = func_declaration();

				        ((UnitContext)_localctx).content =  ((UnitContext)_localctx).f_dec.content;
				        ((UnitContext)_localctx).line =  ((UnitContext)_localctx).f_dec.line;

				        parseLog(
				            _localctx.line,
				            "unit",
				            "func_declaration",
				            _localctx.content
				        );
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				((UnitContext)_localctx).f_def = func_definition();
				   
				        ((UnitContext)_localctx).content =  ((UnitContext)_localctx).f_def.content;
				        ((UnitContext)_localctx).line =  ((UnitContext)_localctx).f_def.line;

				        parseLog(
				            _localctx.line,
				            "unit",
				            "func_definition",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_declarationContext extends ParserRuleContext {
		public int line;
		public String content;
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public Token sm;
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105125Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105125Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105125Parser.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterFunc_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitFunc_declaration(this);
		}
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((Func_declarationContext)_localctx).ts = type_specifier();
				setState(76);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(77);
				match(LPAREN);
				setState(78);
				((Func_declarationContext)_localctx).pl = parameter_list(0);
				setState(79);
				match(RPAREN);
				setState(80);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);
				          
				        insertId(
				            new Identifier(
				                ((Func_declarationContext)_localctx).ID.getText(), ((Func_declarationContext)_localctx).ts.tokenType, ((Func_declarationContext)_localctx).pl.parameters
				            )
				        );

				        ((Func_declarationContext)_localctx).content =  ((Func_declarationContext)_localctx).ts.content + ' ' + ((Func_declarationContext)_localctx).ID.getText() + "();";
				        ((Func_declarationContext)_localctx).line =  ((Func_declarationContext)_localctx).sm.getLine();

				        parseLog(
				            _localctx.line,
				            "func_declaration",
				            "type_specifier ID LPAREN RPAREN SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				((Func_declarationContext)_localctx).ts = type_specifier();
				setState(84);
				((Func_declarationContext)_localctx).ID = match(ID);
				setState(85);
				match(LPAREN);
				setState(86);
				match(RPAREN);
				setState(87);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

				         insertId(
				            new Identifier(
				                ((Func_declarationContext)_localctx).ID.getText(), ((Func_declarationContext)_localctx).ts.tokenType, null
				            )
				        );

				        ((Func_declarationContext)_localctx).content =  ((Func_declarationContext)_localctx).ts.content + ' ' + ((Func_declarationContext)_localctx).ID.getText() + "();";
				        ((Func_declarationContext)_localctx).line =  ((Func_declarationContext)_localctx).sm.getLine();

				        parseLog(
				            _localctx.line,
				            "func_declaration",
				            "type_specifier ID LPAREN RPAREN SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public Compound_statementContext cs;
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105125Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105125Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterFunc_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitFunc_definition(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				((Func_definitionContext)_localctx).ts = type_specifier();
				setState(93);
				((Func_definitionContext)_localctx).ID = match(ID);

				        Identifier funcid = new Identifier(
				            ((Func_definitionContext)_localctx).ID.getText(), ((Func_definitionContext)_localctx).ts.tokenType, null
				        );

				        insertId(funcid);
				    
				setState(95);
				match(LPAREN);
				setState(96);
				((Func_definitionContext)_localctx).pl = parameter_list(0);
				 funcid.parameters = ((Func_definitionContext)_localctx).pl.parameters; 
				setState(98);
				match(RPAREN);
				setState(99);
				((Func_definitionContext)_localctx).cs = compound_statement(((Func_definitionContext)_localctx).pl.parameters);

				        ((Func_definitionContext)_localctx).line =  ((Func_definitionContext)_localctx).cs.line;
				        ((Func_definitionContext)_localctx).content =  ((Func_definitionContext)_localctx).ts.content 
				                    + ' '
				                    + ((Func_definitionContext)_localctx).ID.getText()
				                    + '('
				                    + ((Func_definitionContext)_localctx).pl.content
				                    + ')'
				                    + ((Func_definitionContext)_localctx).cs.content;

				        parseLog(
				            _localctx.line,
				            "func_definition",
				            "type_specifier ID LPAREN parameter_list RPAREN compound_statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((Func_definitionContext)_localctx).ts = type_specifier();
				setState(103);
				((Func_definitionContext)_localctx).ID = match(ID);
				setState(104);
				match(LPAREN);
				setState(105);
				match(RPAREN);
				setState(106);
				((Func_definitionContext)_localctx).cs = compound_statement(null);
				 
				        insertId(
				            new Identifier(
				                ((Func_definitionContext)_localctx).ID.getText(), ((Func_definitionContext)_localctx).ts.tokenType, null
				            )
				        );

				        ((Func_definitionContext)_localctx).line =  ((Func_definitionContext)_localctx).cs.line;
				        ((Func_definitionContext)_localctx).content =  ((Func_definitionContext)_localctx).ts.content 
				                    + ' '
				                    + ((Func_definitionContext)_localctx).ID.getText()
				                    + "()"
				                    + ((Func_definitionContext)_localctx).cs.content;
				        
				        parseLog(
				            _localctx.line,
				            "func_definition",
				            "type_specifier ID LPAREN RPAREN compound_statement",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public String content;
		public List<Identifier> parameters;
		public Parameter_listContext pl;
		public Type_specifierContext ts;
		public Token ID;
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C2105125Parser.COMMA, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitParameter_list(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(112);
				((Parameter_listContext)_localctx).ts = type_specifier();
				setState(113);
				((Parameter_listContext)_localctx).ID = match(ID);

				        ((Parameter_listContext)_localctx).parameters =  new LinkedList<>();
				        _localctx.parameters.add(
				            new Identifier(((Parameter_listContext)_localctx).ID.getText(), ((Parameter_listContext)_localctx).ts.tokenType, null)
				        );

				        ((Parameter_listContext)_localctx).content =  ((Parameter_listContext)_localctx).ts.content + ' ' + ((Parameter_listContext)_localctx).ID.getText();

				        parseLog(
				            ((Parameter_listContext)_localctx).ID.getLine(),
				            "parameter_list",
				            "type_specifier ID",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				{
				setState(116);
				((Parameter_listContext)_localctx).ts = type_specifier();

				        ((Parameter_listContext)_localctx).parameters =  null;
				        ((Parameter_listContext)_localctx).content =  ((Parameter_listContext)_localctx).ts.content;

				        parseLog(
				            ((Parameter_listContext)_localctx).ts.line,
				            "parameter_list",
				            "type_specifier",
				            _localctx.content
				        );
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(121);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(122);
						match(COMMA);
						setState(123);
						((Parameter_listContext)_localctx).ts = type_specifier();
						setState(124);
						((Parameter_listContext)_localctx).ID = match(ID);

						                  ((Parameter_listContext)_localctx).parameters =  ((Parameter_listContext)_localctx).pl.parameters;
						                  _localctx.parameters.add(
						                      new Identifier(((Parameter_listContext)_localctx).ID.getText(), ((Parameter_listContext)_localctx).ts.tokenType, null)
						                  );
						                  ((Parameter_listContext)_localctx).content =  ((Parameter_listContext)_localctx).pl.content + ',' + ((Parameter_listContext)_localctx).ts.content + ' '  + ((Parameter_listContext)_localctx).ID.getText();

						                  parseLog(
						                      ((Parameter_listContext)_localctx).ID.getLine(),
						                      "parameter_list",
						                      "parameter_list COMMA type_specifier ID",
						                      _localctx.content
						                  );
						              
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(127);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(128);
						match(COMMA);
						setState(129);
						((Parameter_listContext)_localctx).ts = type_specifier();

						                  ((Parameter_listContext)_localctx).content =  ((Parameter_listContext)_localctx).pl.content + ',' + ((Parameter_listContext)_localctx).ts.content;

						                  ((Parameter_listContext)_localctx).parameters =  null;
						                  parseLog(
						                      ((Parameter_listContext)_localctx).ts.line,
						                      "parameter_list",
						                      "parameter_list COMMA type_specifier",
						                      _localctx.content
						                  );
						              
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public List<Identifier> parameters;
		public int line;
		public String content;
		public StatementsContext ss;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C2105125Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105125Parser.RCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState, List<Identifier> parameters) {
			super(parent, invokingState);
			this.parameters = parameters;
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement(List<Identifier> parameters) throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState(), parameters);
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(LCURL);
				 
				        enterScope();
				        if (parameters != null) {
				            for (Identifier param : parameters) {
				                insertId(param);
				                System.out.println(param);
				            }
				        }
				    
				setState(139);
				((Compound_statementContext)_localctx).ss = statements(0);
				setState(140);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);
				   
				        ((Compound_statementContext)_localctx).line =  ((Compound_statementContext)_localctx).RCURL.getLine();
				        ((Compound_statementContext)_localctx).content =  "{\n" + ((Compound_statementContext)_localctx).ss.content + '\n' + "}";

				        parseLog(
				            _localctx.line,
				            "compound_statement",
				            "LCURL statements RCURL",
				            _localctx.content
				        );

				        exitScope();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(LCURL);
				 
				        enterScope();
				    
				setState(145);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

				        ((Compound_statementContext)_localctx).line =  ((Compound_statementContext)_localctx).RCURL.getLine();
				        ((Compound_statementContext)_localctx).content =  "{\n}\n";

				        parseLog(
				            _localctx.line,
				            "compound_statement",
				            "LCURL RCURL",
				            _localctx.content
				        );

				        exitScope();
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declarationContext extends ParserRuleContext {
		public int line;
		public String content;
		public Type_specifierContext t;
		public Declaration_listContext dl;
		public Token sm;
		public Declaration_list_errContext de;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105125Parser.SEMICOLON, 0); }
		public Declaration_list_errContext declaration_list_err() {
			return getRuleContext(Declaration_list_errContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterVar_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitVar_declaration(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(150);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(151);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        for (String idName : ((Var_declarationContext)_localctx).dl.idNames) {
				            int dataType = ((Var_declarationContext)_localctx).t.tokenType;
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

				        String type = ((Var_declarationContext)_localctx).t.content;
				        ((Var_declarationContext)_localctx).line =  ((Var_declarationContext)_localctx).sm.getLine();
				        ((Var_declarationContext)_localctx).content =  type + ' ' + ((Var_declarationContext)_localctx).dl.content + ((Var_declarationContext)_localctx).sm.getText();

				        String errorName = null;
				        if (type.equals("void")) errorName = "Variable type cannot be void";
				       
				        parseLog(
				            _localctx.line,
				            "var_declaration",
				            "type_specifier declaration_list SEMICOLON",
				            _localctx.content,
				            errorName
				        );
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(155);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(156);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        // later
				        writeIntoErrorFile(
				            "Line# "
				            + ((Var_declarationContext)_localctx).sm.getLine()
				            + " with error name: "
				            + ((Var_declarationContext)_localctx).de.error_name
				            + " - Syntax error at declaration list of variable declaration"
				        );
				        Main.errorCount++;
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_list_errContext extends ParserRuleContext {
		public String error_name;
		public Declaration_list_errContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_err; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterDeclaration_list_err(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitDeclaration_list_err(this);
		}
	}

	public final Declaration_list_errContext declaration_list_err() throws RecognitionException {
		Declaration_list_errContext _localctx = new Declaration_list_errContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration_list_err);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Declaration_list_errContext)_localctx).error_name =  "Error in declaration list"; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public int line;
		public String content;
		public int tokenType;
		public Token t;
		public TerminalNode INT() { return getToken(C2105125Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C2105125Parser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C2105125Parser.VOID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterType_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitType_specifier(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			((Type_specifierContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
				((Type_specifierContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			        ((Type_specifierContext)_localctx).tokenType =  ((Type_specifierContext)_localctx).t.getType();
			        ((Type_specifierContext)_localctx).line =  ((Type_specifierContext)_localctx).t.getLine();
			        ((Type_specifierContext)_localctx).content =  ((Type_specifierContext)_localctx).t.getText();
			        
			        parseLog(
			            _localctx.line,
			            "type_specifier",
			            getType(((Type_specifierContext)_localctx).t),
			            _localctx.content
			        );
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public String content;
		public List<String> idNames;
		public Declaration_listContext dl;
		public Token ID;
		public Token ci;
		public Token RTHIRD;
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105125Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105125Parser.RTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C2105125Parser.CONST_INT, 0); }
		public TerminalNode COMMA() { return getToken(C2105125Parser.COMMA, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterDeclaration_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitDeclaration_list(this);
		}
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(167);
				((Declaration_listContext)_localctx).ID = match(ID);

				        ((Declaration_listContext)_localctx).content =  ((Declaration_listContext)_localctx).ID.getText();
				        ((Declaration_listContext)_localctx).idNames =  new LinkedList<>();

				        if (getId(_localctx.content) != null) { 
				            String errorMessage = "Error at line " + ((Declaration_listContext)_localctx).ID.getLine() + " Multiple declaration of " + _localctx.content + '\n';

				            writeIntoErrorFile(errorMessage);
				            writeIntoParserLogFile(errorMessage);

				            Main.errorCount++;
				        } else {
				            _localctx.idNames.add(_localctx.content);
				        }
				        
				        parseLog(
				            ((Declaration_listContext)_localctx).ID.getLine(),
				            "declaration_list",
				            "ID",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				{
				setState(169);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(170);
				match(LTHIRD);
				setState(171);
				((Declaration_listContext)_localctx).ci = match(CONST_INT);
				setState(172);
				((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

				        ((Declaration_listContext)_localctx).content =  ((Declaration_listContext)_localctx).ID.getText() + '[' + ((Declaration_listContext)_localctx).ci.getText() + ']';

				        ((Declaration_listContext)_localctx).idNames =  new LinkedList<>();
				        _localctx.idNames.add(((Declaration_listContext)_localctx).ID.getText() + "[]");

				        parseLog(
				            ((Declaration_listContext)_localctx).RTHIRD.getLine(),
				            "declaration_list",
				            "ID LTHIRD CONST_INT RTHIRD",
				            _localctx.content
				        );
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(187);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(176);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(177);
						match(COMMA);
						setState(178);
						((Declaration_listContext)_localctx).ID = match(ID);

						                  ((Declaration_listContext)_localctx).content =  ((Declaration_listContext)_localctx).dl.content + "," + ((Declaration_listContext)_localctx).ID.getText();
						                  ((Declaration_listContext)_localctx).idNames =  ((Declaration_listContext)_localctx).dl.idNames;
						                  _localctx.idNames.add(((Declaration_listContext)_localctx).ID.getText());

						                  parseLog(
						                      ((Declaration_listContext)_localctx).ID.getLine(),
						                      "declaration_list",
						                      "declaration_list COMMA ID",
						                      _localctx.content
						                  );
						              
						}
						break;
					case 2:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181);
						match(COMMA);
						setState(182);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(183);
						match(LTHIRD);
						setState(184);
						((Declaration_listContext)_localctx).ci = match(CONST_INT);
						setState(185);
						((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

						                  ((Declaration_listContext)_localctx).content =  ((Declaration_listContext)_localctx).dl.content + "," + ((Declaration_listContext)_localctx).ID.getText() + '[' + ((Declaration_listContext)_localctx).ci.getText() + ']';

						                  ((Declaration_listContext)_localctx).idNames =  ((Declaration_listContext)_localctx).dl.idNames;
						                  _localctx.idNames.add(((Declaration_listContext)_localctx).ID.getText() + "[]");    

						                  parseLog(
						                      ((Declaration_listContext)_localctx).RTHIRD.getLine(),
						                      "declaration_list",
						                      "declaration_list COMMA ID LTHIRD CONST_INT RTHIRD",
						                      _localctx.content
						                  );
						              
						}
						break;
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public int line;
		public String content;
		public StatementsContext ss;
		public StatementContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(193);
			((StatementsContext)_localctx).s = statement();

			        ((StatementsContext)_localctx).line =  ((StatementsContext)_localctx).s.line;
			        ((StatementsContext)_localctx).content =  ((StatementsContext)_localctx).s.content;

			        parseLog(
			            _localctx.line,
			            "statements",
			            "statement",
			            _localctx.content
			        );
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					_localctx.ss = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(196);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(197);
					((StatementsContext)_localctx).s = statement();

					                  ((StatementsContext)_localctx).line =  ((StatementsContext)_localctx).s.line;
					                  ((StatementsContext)_localctx).content =  ((StatementsContext)_localctx).ss.content + '\n' + ((StatementsContext)_localctx).s.content;

					                  parseLog(
					                      _localctx.line,
					                      "statements",
					                      "statements statement",
					                      _localctx.content
					                  );
					              
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public int line;
		public String content;
		public Var_declarationContext vd;
		public Expression_statementContext es;
		public Compound_statementContext cs;
		public Expression_statementContext es1;
		public Expression_statementContext es2;
		public ExpressionContext es3;
		public StatementContext s;
		public ExpressionContext e;
		public StatementContext s1;
		public StatementContext s2;
		public Token ID;
		public Token sm;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public TerminalNode FOR() { return getToken(C2105125Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(C2105125Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105125Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(C2105125Parser.IF, 0); }
		public TerminalNode ELSE() { return getToken(C2105125Parser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(C2105125Parser.WHILE, 0); }
		public TerminalNode PRINTLN() { return getToken(C2105125Parser.PRINTLN, 0); }
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105125Parser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(C2105125Parser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				((StatementContext)_localctx).vd = var_declaration();

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).vd.line;
				        ((StatementContext)_localctx).content =  ((StatementContext)_localctx).vd.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "var_declaration",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				((StatementContext)_localctx).es = expression_statement();

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).es.line;
				        ((StatementContext)_localctx).content =  ((StatementContext)_localctx).es.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "expression_statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				((StatementContext)_localctx).cs = compound_statement(null);

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).cs.line;
				        ((StatementContext)_localctx).content =  ((StatementContext)_localctx).cs.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "compound_statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				match(FOR);
				setState(215);
				match(LPAREN);
				setState(216);
				((StatementContext)_localctx).es1 = expression_statement();
				setState(217);
				((StatementContext)_localctx).es2 = expression_statement();
				setState(218);
				((StatementContext)_localctx).es3 = expression();
				setState(219);
				match(RPAREN);
				setState(220);
				((StatementContext)_localctx).s = statement();

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).s.line;
				        ((StatementContext)_localctx).content =  "for (" + ((StatementContext)_localctx).es1.content + ((StatementContext)_localctx).es2.content + ((StatementContext)_localctx).es3.content + ") " + ((StatementContext)_localctx).s.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "FOR LPAREN expression_statement expression_statement expression RPAREN statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(223);
				match(IF);
				setState(224);
				match(LPAREN);
				setState(225);
				((StatementContext)_localctx).e = expression();
				setState(226);
				match(RPAREN);
				setState(227);
				((StatementContext)_localctx).s = statement();

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).s.line;
				        ((StatementContext)_localctx).content =  "if (" + ((StatementContext)_localctx).e.content + ") " + ((StatementContext)_localctx).s.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "IF LPAREN expression RPAREN statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				match(IF);
				setState(231);
				match(LPAREN);
				setState(232);
				((StatementContext)_localctx).e = expression();
				setState(233);
				match(RPAREN);
				setState(234);
				((StatementContext)_localctx).s1 = statement();
				setState(235);
				match(ELSE);
				setState(236);
				((StatementContext)_localctx).s2 = statement();
				   
				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).s2.line;
				        ((StatementContext)_localctx).content =  "if (" + ((StatementContext)_localctx).e.content + ") " + ((StatementContext)_localctx).s1.content + "else " + ((StatementContext)_localctx).s2.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "IF LPAREN expression RPAREN statement ELSE statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(239);
				match(WHILE);
				setState(240);
				match(LPAREN);
				setState(241);
				((StatementContext)_localctx).e = expression();
				setState(242);
				match(RPAREN);
				setState(243);
				((StatementContext)_localctx).s = statement();

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).s.line;
				        ((StatementContext)_localctx).content =  "while (" + ((StatementContext)_localctx).e.content + ") " + ((StatementContext)_localctx).s.content;

				        parseLog(
				            _localctx.line,
				            "statement",
				            "WHILE LPAREN expression RPAREN statement",
				            _localctx.content
				        );
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(246);
				match(PRINTLN);
				setState(247);
				match(LPAREN);
				setState(248);
				((StatementContext)_localctx).ID = match(ID);
				setState(249);
				match(RPAREN);
				setState(250);
				((StatementContext)_localctx).sm = match(SEMICOLON);

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).sm.getLine();
				        ((StatementContext)_localctx).content =  "println(" + ((StatementContext)_localctx).ID.getText() + ");\n";

				        parseLog(
				            _localctx.line,
				            "statement",
				            "PRINTLN LPAREN ID RPAREN SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(252);
				match(RETURN);
				setState(253);
				((StatementContext)_localctx).e = expression();
				setState(254);
				((StatementContext)_localctx).sm = match(SEMICOLON);

				        ((StatementContext)_localctx).line =  ((StatementContext)_localctx).sm.getLine();
				        ((StatementContext)_localctx).content =  "return " + ((StatementContext)_localctx).e.content + ";";

				        parseLog(
				            _localctx.line,
				            "statement",
				            "RETURN expression SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public int line;
		public String content;
		public Token sm;
		public ExpressionContext e;
		public TerminalNode SEMICOLON() { return getToken(C2105125Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitExpression_statement(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression_statement);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				((Expression_statementContext)_localctx).sm = match(SEMICOLON);

				        ((Expression_statementContext)_localctx).line =  ((Expression_statementContext)_localctx).sm.getLine();
				        ((Expression_statementContext)_localctx).content =  ";";

				        parseLog(
				            _localctx.line,
				            "expression_statement",
				            "SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				((Expression_statementContext)_localctx).e = expression();
				setState(262);
				((Expression_statementContext)_localctx).sm = match(SEMICOLON);

				        ((Expression_statementContext)_localctx).line =  ((Expression_statementContext)_localctx).sm.getLine();
				        ((Expression_statementContext)_localctx).content =  ((Expression_statementContext)_localctx).e.content + ';';

				        parseLog(
				            _localctx.line,
				            "expression_statement",
				            "expression SEMICOLON",
				            _localctx.content
				        );
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public int line;
		public String content;
		public Token ID;
		public ExpressionContext e;
		public Token RTHIRD;
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105125Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105125Parser.RTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				((VariableContext)_localctx).ID = match(ID);


				        ((VariableContext)_localctx).line =  ((VariableContext)_localctx).ID.getLine();
				        ((VariableContext)_localctx).content =  ((VariableContext)_localctx).ID.getText();

				        parseLog(
				            _localctx.line,
				            "variable",
				            "ID",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				((VariableContext)_localctx).ID = match(ID);
				setState(270);
				match(LTHIRD);
				setState(271);
				((VariableContext)_localctx).e = expression();
				setState(272);
				((VariableContext)_localctx).RTHIRD = match(RTHIRD);


				        ((VariableContext)_localctx).line =  ((VariableContext)_localctx).RTHIRD.getLine();
				        String index = ((VariableContext)_localctx).e.content;
				        ((VariableContext)_localctx).content =  ((VariableContext)_localctx).ID.getText() + '[' + index + ']';

				        String errorName;
				        if (!isInteger(index)) {
				            errorName = "Expression inside third brackets not an integer";
				        } else {
				            errorName = null;
				        }

				        parseLog(
				            _localctx.line,
				            "variable",
				            "ID LTHIRD expression RTHIRD",
				            _localctx.content,
				            errorName
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Logic_expressionContext le;
		public VariableContext var;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C2105125Parser.ASSIGNOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				((ExpressionContext)_localctx).le = logic_expression();

				        ((ExpressionContext)_localctx).line =  ((ExpressionContext)_localctx).le.line;
				        ((ExpressionContext)_localctx).content =  ((ExpressionContext)_localctx).le.content;

				        parseLog(
				            _localctx.line,
				            "expression",
				            "logic_expression",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				((ExpressionContext)_localctx).var = variable();
				setState(281);
				match(ASSIGNOP);
				setState(282);
				((ExpressionContext)_localctx).le = logic_expression();


				        ((ExpressionContext)_localctx).line =  ((ExpressionContext)_localctx).le.line;
				        ((ExpressionContext)_localctx).content =  ((ExpressionContext)_localctx).var.content + '=' + ((ExpressionContext)_localctx).le.content;

				        String errorName = null;
				        Identifier id = getId(((ExpressionContext)_localctx).var.content);
				        if (id != null) {
				            if (
				                (id.type == INT && !isInteger(((ExpressionContext)_localctx).le.content)) ||
				                (id.type == FLOAT && isInteger(((ExpressionContext)_localctx).le.content))
				            ) errorName = "Type Mismatch";
				        }

				        parseLog(
				            _localctx.line,
				            "expression",
				            "variable ASSIGNOP logic_expression",
				            _localctx.content,
				            errorName
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_expressionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Rel_expressionContext re;
		public Rel_expressionContext re1;
		public Token LOGICOP;
		public Rel_expressionContext re2;
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(C2105125Parser.LOGICOP, 0); }
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterLogic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitLogic_expression(this);
		}
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logic_expression);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				((Logic_expressionContext)_localctx).re = rel_expression();

				        ((Logic_expressionContext)_localctx).line =  ((Logic_expressionContext)_localctx).re.line;
				        ((Logic_expressionContext)_localctx).content =  ((Logic_expressionContext)_localctx).re.content;

				        parseLog(
				            _localctx.line,
				            "logic_expression",
				            "rel_expression",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				((Logic_expressionContext)_localctx).re1 = rel_expression();
				setState(291);
				((Logic_expressionContext)_localctx).LOGICOP = match(LOGICOP);
				setState(292);
				((Logic_expressionContext)_localctx).re2 = rel_expression();

				        ((Logic_expressionContext)_localctx).line =  ((Logic_expressionContext)_localctx).re2.line;
				        ((Logic_expressionContext)_localctx).content =  ((Logic_expressionContext)_localctx).re1.content + ((Logic_expressionContext)_localctx).LOGICOP.getText() + ((Logic_expressionContext)_localctx).re2.content;

				        parseLog(
				            _localctx.line,
				            "logic_expression",
				            "rel_expression LOGICOP rel_expression",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rel_expressionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Simple_expressionContext se;
		public Simple_expressionContext se1;
		public Token RELOP;
		public Simple_expressionContext se2;
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(C2105125Parser.RELOP, 0); }
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterRel_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitRel_expression(this);
		}
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel_expression);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				((Rel_expressionContext)_localctx).se = simple_expression(0);

				        ((Rel_expressionContext)_localctx).line =  ((Rel_expressionContext)_localctx).se.line;
				        ((Rel_expressionContext)_localctx).content =  ((Rel_expressionContext)_localctx).se.content;

				        parseLog(
				            _localctx.line,
				            "rel_expression",
				            "simple_expression",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				((Rel_expressionContext)_localctx).se1 = simple_expression(0);
				setState(301);
				((Rel_expressionContext)_localctx).RELOP = match(RELOP);
				setState(302);
				((Rel_expressionContext)_localctx).se2 = simple_expression(0);

				        ((Rel_expressionContext)_localctx).line =  ((Rel_expressionContext)_localctx).se2.line;
				        ((Rel_expressionContext)_localctx).content =  ((Rel_expressionContext)_localctx).se1.content + ((Rel_expressionContext)_localctx).RELOP.getText() + ((Rel_expressionContext)_localctx).se2.content;

				        parseLog(
				            _localctx.line,
				            "rel_expression",
				            "simple_expression RELOP simple_expression",
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Simple_expressionContext se;
		public TermContext t;
		public Token ADDOP;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C2105125Parser.ADDOP, 0); }
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterSimple_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitSimple_expression(this);
		}
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(308);
			((Simple_expressionContext)_localctx).t = term(0);

			        ((Simple_expressionContext)_localctx).line =  ((Simple_expressionContext)_localctx).t.line;
			        ((Simple_expressionContext)_localctx).content =  ((Simple_expressionContext)_localctx).t.content;

			        parseLog(
			            _localctx.line,
			            "simple_expression",
			            "term",
			            _localctx.content
			        );
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Simple_expressionContext(_parentctx, _parentState);
					_localctx.se = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(311);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(312);
					((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
					setState(313);
					((Simple_expressionContext)_localctx).t = term(0);

					                  ((Simple_expressionContext)_localctx).line =  ((Simple_expressionContext)_localctx).t.line;
					                  ((Simple_expressionContext)_localctx).content =  ((Simple_expressionContext)_localctx).se.content + ((Simple_expressionContext)_localctx).ADDOP.getText() + ((Simple_expressionContext)_localctx).t.content;

					                  parseLog(
					                      _localctx.line,
					                      "simple_expression",
					                      "simple_expression ADDOP term",
					                      _localctx.content
					                  );
					              
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public int line;
		public String content;
		public TermContext t;
		public Unary_expressionContext ue;
		public Token m;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(C2105125Parser.MULOP, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(322);
			((TermContext)_localctx).ue = unary_expression();

			        ((TermContext)_localctx).line =  ((TermContext)_localctx).ue.line;
			        ((TermContext)_localctx).content =  ((TermContext)_localctx).ue.content;

			        parseLog(
			            _localctx.line,
			            "term",
			            "unary_expression",
			            _localctx.content
			        );
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(325);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(326);
					((TermContext)_localctx).m = match(MULOP);
					setState(327);
					((TermContext)_localctx).ue = unary_expression();

					                  ((TermContext)_localctx).line =  ((TermContext)_localctx).ue.line;
					                  String op = ((TermContext)_localctx).m.getText();
					                  String second = ((TermContext)_localctx).ue.content;
					                  
					                  ((TermContext)_localctx).content =  ((TermContext)_localctx).t.content + op + second;

					                  String errorName = null;
					                  if (op.equals("%")) {
					                      if (!isInteger(second)) {
					                          errorName = "Non-Integer operand on modulus operator";
					                      } else if (Integer.parseInt(second) == 0) {
					                          errorName = "Modulus by Zero";
					                      }
					                  }

					                  parseLog(
					                      _localctx.line,
					                      "term",
					                      "term MULOP unary_expression",
					                      _localctx.content,
					                      errorName
					                  );
					              
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public int line;
		public String content;
		public Token ADDOP;
		public Unary_expressionContext ue;
		public Token NOT;
		public FactorContext f;
		public TerminalNode ADDOP() { return getToken(C2105125Parser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(C2105125Parser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unary_expression);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				((Unary_expressionContext)_localctx).ADDOP = match(ADDOP);
				setState(336);
				((Unary_expressionContext)_localctx).ue = unary_expression();

				        ((Unary_expressionContext)_localctx).line =  ((Unary_expressionContext)_localctx).ue.line;
				        ((Unary_expressionContext)_localctx).content =  ((Unary_expressionContext)_localctx).ADDOP.getText() + ((Unary_expressionContext)_localctx).ue.content;

				        parseLog(
				            _localctx.line,
				            "unary_expression",
				            "ADDOP unary_expression",
				            _localctx.content
				        );
				    
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				((Unary_expressionContext)_localctx).NOT = match(NOT);
				setState(340);
				((Unary_expressionContext)_localctx).ue = unary_expression();

				        ((Unary_expressionContext)_localctx).line =  ((Unary_expressionContext)_localctx).ue.line;
				        ((Unary_expressionContext)_localctx).content =  ((Unary_expressionContext)_localctx).NOT.getText() + ((Unary_expressionContext)_localctx).ue.content;

				        parseLog(
				            _localctx.line,
				            "unary_expression",
				            "NOT unary_expression",
				            _localctx.content
				        );
				    
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				((Unary_expressionContext)_localctx).f = factor();

				        ((Unary_expressionContext)_localctx).line =  ((Unary_expressionContext)_localctx).f.line;
				        ((Unary_expressionContext)_localctx).content =  ((Unary_expressionContext)_localctx).f.content;

				        parseLog(
				            _localctx.line,
				            "unary_expression",
				            "factor",
				            _localctx.content
				        );
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public int line;
		public String content;
		public VariableContext var;
		public Token ID;
		public Argument_listContext al;
		public Token RPAREN;
		public ExpressionContext e;
		public Token cl;
		public Token do_;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C2105125Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105125Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105125Parser.RPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST_INT() { return getToken(C2105125Parser.CONST_INT, 0); }
		public TerminalNode CONST_FLOAT() { return getToken(C2105125Parser.CONST_FLOAT, 0); }
		public TerminalNode INCOP() { return getToken(C2105125Parser.INCOP, 0); }
		public TerminalNode DECOP() { return getToken(C2105125Parser.DECOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				((FactorContext)_localctx).var = variable();

				        ((FactorContext)_localctx).line =  ((FactorContext)_localctx).var.line;
				        ((FactorContext)_localctx).content =  ((FactorContext)_localctx).var.content;

				        parseLog(
				            _localctx.line,
				            "factor",
				            "variable",
				            _localctx.content
				        );
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				((FactorContext)_localctx).ID = match(ID);
				setState(352);
				match(LPAREN);
				setState(353);
				((FactorContext)_localctx).al = argument_list();
				setState(354);
				((FactorContext)_localctx).RPAREN = match(RPAREN);

				        ((FactorContext)_localctx).line =  ((FactorContext)_localctx).RPAREN.getLine();
				        ((FactorContext)_localctx).content =  ((FactorContext)_localctx).ID.getText() + '(' + ((FactorContext)_localctx).al.content + ')';

				        parseLog(
				            _localctx.line,
				            "factor",
				            "ID LPAREN argument_list RPAREN",
				            _localctx.content
				        );
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(LPAREN);
				setState(358);
				((FactorContext)_localctx).e = expression();
				setState(359);
				((FactorContext)_localctx).RPAREN = match(RPAREN);

				        ((FactorContext)_localctx).line =  ((FactorContext)_localctx).RPAREN.getLine();
				        ((FactorContext)_localctx).content =  '(' + ((FactorContext)_localctx).e.content + ')';

				        parseLog(
				            _localctx.line,
				            "factor",
				            "LPAREN expression RPAREN",
				            _localctx.content
				        );
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				((FactorContext)_localctx).cl = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CONST_INT || _la==CONST_FLOAT) ) {
					((FactorContext)_localctx).cl = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				        ((FactorContext)_localctx).line =  ((FactorContext)_localctx).cl.getLine();
				        ((FactorContext)_localctx).content =  ((FactorContext)_localctx).cl.getText();

				        parseLog(
				            _localctx.line,
				            "factor",
				            getType(((FactorContext)_localctx).cl),
				            _localctx.content
				        );
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(364);
				((FactorContext)_localctx).var = variable();
				setState(365);
				((FactorContext)_localctx).do_ = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCOP || _la==DECOP) ) {
					((FactorContext)_localctx).do_ = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

				        ((FactorContext)_localctx).line =  ((FactorContext)_localctx).var.line;
				        ((FactorContext)_localctx).content =  ((FactorContext)_localctx).var.content + ((FactorContext)_localctx).do_.getText();

				        parseLog(
				            _localctx.line,
				            "factor",
				            "variable " + getType(((FactorContext)_localctx).do_),
				            _localctx.content
				        );
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public int line;
		public String content;
		public ArgumentsContext as;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterArgument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitArgument_list(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument_list);
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((Argument_listContext)_localctx).as = arguments(0);

				        ((Argument_listContext)_localctx).line =  ((Argument_listContext)_localctx).as.line;
				        ((Argument_listContext)_localctx).content =  ((Argument_listContext)_localctx).as.content;

				        parseLog(
				            _localctx.line,
				            "argument_list",
				            "arguments",
				            _localctx.content
				        );
				    
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public int line;
		public String content;
		public ArgumentsContext as;
		public Logic_expressionContext le;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C2105125Parser.COMMA, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof C2105125ParserListener ) ((C2105125ParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(377);
			((ArgumentsContext)_localctx).le = logic_expression();

			        ((ArgumentsContext)_localctx).line =  ((ArgumentsContext)_localctx).le.line;
			        ((ArgumentsContext)_localctx).content =  ((ArgumentsContext)_localctx).le.content;

			        parseLog(
			            _localctx.line,
			            "arguments",
			            "logic_expression",
			            _localctx.content
			        );
			    
			}
			_ctx.stop = _input.LT(-1);
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					_localctx.as = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(380);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(381);
					match(COMMA);
					setState(382);
					((ArgumentsContext)_localctx).le = logic_expression();

					                  ((ArgumentsContext)_localctx).line =  ((ArgumentsContext)_localctx).le.line;
					                  ((ArgumentsContext)_localctx).content =  ((ArgumentsContext)_localctx).as.content + ',' + ((ArgumentsContext)_localctx).le.content;
					                  parseLog(
					                      _localctx.line,
					                      "arguments",
					                      "arguments COMMA logic_expression",
					                      _localctx.content
					                  );
					              
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 10:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 11:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 18:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 19:
			return term_sempred((TermContext)_localctx, predIndex);
		case 23:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u0187\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001"+
		"?\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003[\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004n\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005x\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0085\b\u0005\n\u0005"+
		"\f\u0005\u0088\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u0094\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00a0\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00af"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00bc\b\n\n\n\f\n\u00bf\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00c9\b\u000b\n\u000b\f\u000b\u00cc\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0102\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u010a\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0114\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u011e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0128\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0132\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u013d\b\u0012\n\u0012\f\u0012\u0140\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u014b\b\u0013\n\u0013\f\u0013\u014e\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u015b\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0171\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0177\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u0182\b\u0017\n\u0017\f\u0017\u0185"+
		"\t\u0017\u0001\u0017\u0000\u0007\u0002\n\u0014\u0016$&.\u0018\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.\u0000\u0003\u0001\u0000\u000b\r\u0001\u0000 !\u0001\u0000\u0019"+
		"\u001a\u0193\u00000\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000"+
		"\u0004I\u0001\u0000\u0000\u0000\u0006Z\u0001\u0000\u0000\u0000\bm\u0001"+
		"\u0000\u0000\u0000\nw\u0001\u0000\u0000\u0000\f\u0093\u0001\u0000\u0000"+
		"\u0000\u000e\u009f\u0001\u0000\u0000\u0000\u0010\u00a1\u0001\u0000\u0000"+
		"\u0000\u0012\u00a3\u0001\u0000\u0000\u0000\u0014\u00ae\u0001\u0000\u0000"+
		"\u0000\u0016\u00c0\u0001\u0000\u0000\u0000\u0018\u0101\u0001\u0000\u0000"+
		"\u0000\u001a\u0109\u0001\u0000\u0000\u0000\u001c\u0113\u0001\u0000\u0000"+
		"\u0000\u001e\u011d\u0001\u0000\u0000\u0000 \u0127\u0001\u0000\u0000\u0000"+
		"\"\u0131\u0001\u0000\u0000\u0000$\u0133\u0001\u0000\u0000\u0000&\u0141"+
		"\u0001\u0000\u0000\u0000(\u015a\u0001\u0000\u0000\u0000*\u0170\u0001\u0000"+
		"\u0000\u0000,\u0176\u0001\u0000\u0000\u0000.\u0178\u0001\u0000\u0000\u0000"+
		"01\u0003\u0002\u0001\u000012\u0006\u0000\uffff\uffff\u00002\u0001\u0001"+
		"\u0000\u0000\u000034\u0006\u0001\uffff\uffff\u000045\u0003\u0004\u0002"+
		"\u000056\u0006\u0001\uffff\uffff\u00006=\u0001\u0000\u0000\u000078\n\u0002"+
		"\u0000\u000089\u0003\u0004\u0002\u00009:\u0006\u0001\uffff\uffff\u0000"+
		":<\u0001\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0003\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0003\u000e\u0007\u0000"+
		"AB\u0006\u0002\uffff\uffff\u0000BJ\u0001\u0000\u0000\u0000CD\u0003\u0006"+
		"\u0003\u0000DE\u0006\u0002\uffff\uffff\u0000EJ\u0001\u0000\u0000\u0000"+
		"FG\u0003\b\u0004\u0000GH\u0006\u0002\uffff\uffff\u0000HJ\u0001\u0000\u0000"+
		"\u0000I@\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000IF\u0001\u0000"+
		"\u0000\u0000J\u0005\u0001\u0000\u0000\u0000KL\u0003\u0012\t\u0000LM\u0005"+
		"\u001f\u0000\u0000MN\u0005\u000e\u0000\u0000NO\u0003\n\u0005\u0000OP\u0005"+
		"\u000f\u0000\u0000PQ\u0005\u0014\u0000\u0000QR\u0006\u0003\uffff\uffff"+
		"\u0000R[\u0001\u0000\u0000\u0000ST\u0003\u0012\t\u0000TU\u0005\u001f\u0000"+
		"\u0000UV\u0005\u000e\u0000\u0000VW\u0005\u000f\u0000\u0000WX\u0005\u0014"+
		"\u0000\u0000XY\u0006\u0003\uffff\uffff\u0000Y[\u0001\u0000\u0000\u0000"+
		"ZK\u0001\u0000\u0000\u0000ZS\u0001\u0000\u0000\u0000[\u0007\u0001\u0000"+
		"\u0000\u0000\\]\u0003\u0012\t\u0000]^\u0005\u001f\u0000\u0000^_\u0006"+
		"\u0004\uffff\uffff\u0000_`\u0005\u000e\u0000\u0000`a\u0003\n\u0005\u0000"+
		"ab\u0006\u0004\uffff\uffff\u0000bc\u0005\u000f\u0000\u0000cd\u0003\f\u0006"+
		"\u0000de\u0006\u0004\uffff\uffff\u0000en\u0001\u0000\u0000\u0000fg\u0003"+
		"\u0012\t\u0000gh\u0005\u001f\u0000\u0000hi\u0005\u000e\u0000\u0000ij\u0005"+
		"\u000f\u0000\u0000jk\u0003\f\u0006\u0000kl\u0006\u0004\uffff\uffff\u0000"+
		"ln\u0001\u0000\u0000\u0000m\\\u0001\u0000\u0000\u0000mf\u0001\u0000\u0000"+
		"\u0000n\t\u0001\u0000\u0000\u0000op\u0006\u0005\uffff\uffff\u0000pq\u0003"+
		"\u0012\t\u0000qr\u0005\u001f\u0000\u0000rs\u0006\u0005\uffff\uffff\u0000"+
		"sx\u0001\u0000\u0000\u0000tu\u0003\u0012\t\u0000uv\u0006\u0005\uffff\uffff"+
		"\u0000vx\u0001\u0000\u0000\u0000wo\u0001\u0000\u0000\u0000wt\u0001\u0000"+
		"\u0000\u0000x\u0086\u0001\u0000\u0000\u0000yz\n\u0004\u0000\u0000z{\u0005"+
		"\u0015\u0000\u0000{|\u0003\u0012\t\u0000|}\u0005\u001f\u0000\u0000}~\u0006"+
		"\u0005\uffff\uffff\u0000~\u0085\u0001\u0000\u0000\u0000\u007f\u0080\n"+
		"\u0003\u0000\u0000\u0080\u0081\u0005\u0015\u0000\u0000\u0081\u0082\u0003"+
		"\u0012\t\u0000\u0082\u0083\u0006\u0005\uffff\uffff\u0000\u0083\u0085\u0001"+
		"\u0000\u0000\u0000\u0084y\u0001\u0000\u0000\u0000\u0084\u007f\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u000b\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0010"+
		"\u0000\u0000\u008a\u008b\u0006\u0006\uffff\uffff\u0000\u008b\u008c\u0003"+
		"\u0016\u000b\u0000\u008c\u008d\u0005\u0011\u0000\u0000\u008d\u008e\u0006"+
		"\u0006\uffff\uffff\u0000\u008e\u0094\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0005\u0010\u0000\u0000\u0090\u0091\u0006\u0006\uffff\uffff\u0000\u0091"+
		"\u0092\u0005\u0011\u0000\u0000\u0092\u0094\u0006\u0006\uffff\uffff\u0000"+
		"\u0093\u0089\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000"+
		"\u0094\r\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u0012\t\u0000\u0096"+
		"\u0097\u0003\u0014\n\u0000\u0097\u0098\u0005\u0014\u0000\u0000\u0098\u0099"+
		"\u0006\u0007\uffff\uffff\u0000\u0099\u00a0\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0003\u0012\t\u0000\u009b\u009c\u0003\u0010\b\u0000\u009c\u009d"+
		"\u0005\u0014\u0000\u0000\u009d\u009e\u0006\u0007\uffff\uffff\u0000\u009e"+
		"\u00a0\u0001\u0000\u0000\u0000\u009f\u0095\u0001\u0000\u0000\u0000\u009f"+
		"\u009a\u0001\u0000\u0000\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0006\b\uffff\uffff\u0000\u00a2\u0011\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0007\u0000\u0000\u0000\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5"+
		"\u0013\u0001\u0000\u0000\u0000\u00a6\u00a7\u0006\n\uffff\uffff\u0000\u00a7"+
		"\u00a8\u0005\u001f\u0000\u0000\u00a8\u00af\u0006\n\uffff\uffff\u0000\u00a9"+
		"\u00aa\u0005\u001f\u0000\u0000\u00aa\u00ab\u0005\u0012\u0000\u0000\u00ab"+
		"\u00ac\u0005 \u0000\u0000\u00ac\u00ad\u0005\u0013\u0000\u0000\u00ad\u00af"+
		"\u0006\n\uffff\uffff\u0000\u00ae\u00a6\u0001\u0000\u0000\u0000\u00ae\u00a9"+
		"\u0001\u0000\u0000\u0000\u00af\u00bd\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\n\u0004\u0000\u0000\u00b1\u00b2\u0005\u0015\u0000\u0000\u00b2\u00b3\u0005"+
		"\u001f\u0000\u0000\u00b3\u00bc\u0006\n\uffff\uffff\u0000\u00b4\u00b5\n"+
		"\u0003\u0000\u0000\u00b5\u00b6\u0005\u0015\u0000\u0000\u00b6\u00b7\u0005"+
		"\u001f\u0000\u0000\u00b7\u00b8\u0005\u0012\u0000\u0000\u00b8\u00b9\u0005"+
		" \u0000\u0000\u00b9\u00ba\u0005\u0013\u0000\u0000\u00ba\u00bc\u0006\n"+
		"\uffff\uffff\u0000\u00bb\u00b0\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u0015\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0006"+
		"\u000b\uffff\uffff\u0000\u00c1\u00c2\u0003\u0018\f\u0000\u00c2\u00c3\u0006"+
		"\u000b\uffff\uffff\u0000\u00c3\u00ca\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\n\u0001\u0000\u0000\u00c5\u00c6\u0003\u0018\f\u0000\u00c6\u00c7\u0006"+
		"\u000b\uffff\uffff\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u0017"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0003\u000e\u0007\u0000\u00ce\u00cf\u0006\f\uffff\uffff\u0000\u00cf\u0102"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003\u001a\r\u0000\u00d1\u00d2\u0006"+
		"\f\uffff\uffff\u0000\u00d2\u0102\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003"+
		"\f\u0006\u0000\u00d4\u00d5\u0006\f\uffff\uffff\u0000\u00d5\u0102\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0005\u0007\u0000\u0000\u00d7\u00d8\u0005"+
		"\u000e\u0000\u0000\u00d8\u00d9\u0003\u001a\r\u0000\u00d9\u00da\u0003\u001a"+
		"\r\u0000\u00da\u00db\u0003\u001e\u000f\u0000\u00db\u00dc\u0005\u000f\u0000"+
		"\u0000\u00dc\u00dd\u0003\u0018\f\u0000\u00dd\u00de\u0006\f\uffff\uffff"+
		"\u0000\u00de\u0102\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0005\u0000"+
		"\u0000\u00e0\u00e1\u0005\u000e\u0000\u0000\u00e1\u00e2\u0003\u001e\u000f"+
		"\u0000\u00e2\u00e3\u0005\u000f\u0000\u0000\u00e3\u00e4\u0003\u0018\f\u0000"+
		"\u00e4\u00e5\u0006\f\uffff\uffff\u0000\u00e5\u0102\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005\u0005\u0000\u0000\u00e7\u00e8\u0005\u000e\u0000\u0000"+
		"\u00e8\u00e9\u0003\u001e\u000f\u0000\u00e9\u00ea\u0005\u000f\u0000\u0000"+
		"\u00ea\u00eb\u0003\u0018\f\u0000\u00eb\u00ec\u0005\u0006\u0000\u0000\u00ec"+
		"\u00ed\u0003\u0018\f\u0000\u00ed\u00ee\u0006\f\uffff\uffff\u0000\u00ee"+
		"\u0102\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\b\u0000\u0000\u00f0\u00f1"+
		"\u0005\u000e\u0000\u0000\u00f1\u00f2\u0003\u001e\u000f\u0000\u00f2\u00f3"+
		"\u0005\u000f\u0000\u0000\u00f3\u00f4\u0003\u0018\f\u0000\u00f4\u00f5\u0006"+
		"\f\uffff\uffff\u0000\u00f5\u0102\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005"+
		"\t\u0000\u0000\u00f7\u00f8\u0005\u000e\u0000\u0000\u00f8\u00f9\u0005\u001f"+
		"\u0000\u0000\u00f9\u00fa\u0005\u000f\u0000\u0000\u00fa\u00fb\u0005\u0014"+
		"\u0000\u0000\u00fb\u0102\u0006\f\uffff\uffff\u0000\u00fc\u00fd\u0005\n"+
		"\u0000\u0000\u00fd\u00fe\u0003\u001e\u000f\u0000\u00fe\u00ff\u0005\u0014"+
		"\u0000\u0000\u00ff\u0100\u0006\f\uffff\uffff\u0000\u0100\u0102\u0001\u0000"+
		"\u0000\u0000\u0101\u00cd\u0001\u0000\u0000\u0000\u0101\u00d0\u0001\u0000"+
		"\u0000\u0000\u0101\u00d3\u0001\u0000\u0000\u0000\u0101\u00d6\u0001\u0000"+
		"\u0000\u0000\u0101\u00df\u0001\u0000\u0000\u0000\u0101\u00e6\u0001\u0000"+
		"\u0000\u0000\u0101\u00ef\u0001\u0000\u0000\u0000\u0101\u00f6\u0001\u0000"+
		"\u0000\u0000\u0101\u00fc\u0001\u0000\u0000\u0000\u0102\u0019\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0005\u0014\u0000\u0000\u0104\u010a\u0006\r\uffff"+
		"\uffff\u0000\u0105\u0106\u0003\u001e\u000f\u0000\u0106\u0107\u0005\u0014"+
		"\u0000\u0000\u0107\u0108\u0006\r\uffff\uffff\u0000\u0108\u010a\u0001\u0000"+
		"\u0000\u0000\u0109\u0103\u0001\u0000\u0000\u0000\u0109\u0105\u0001\u0000"+
		"\u0000\u0000\u010a\u001b\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u001f"+
		"\u0000\u0000\u010c\u0114\u0006\u000e\uffff\uffff\u0000\u010d\u010e\u0005"+
		"\u001f\u0000\u0000\u010e\u010f\u0005\u0012\u0000\u0000\u010f\u0110\u0003"+
		"\u001e\u000f\u0000\u0110\u0111\u0005\u0013\u0000\u0000\u0111\u0112\u0006"+
		"\u000e\uffff\uffff\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u010b"+
		"\u0001\u0000\u0000\u0000\u0113\u010d\u0001\u0000\u0000\u0000\u0114\u001d"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0003 \u0010\u0000\u0116\u0117\u0006"+
		"\u000f\uffff\uffff\u0000\u0117\u011e\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0003\u001c\u000e\u0000\u0119\u011a\u0005\u001e\u0000\u0000\u011a\u011b"+
		"\u0003 \u0010\u0000\u011b\u011c\u0006\u000f\uffff\uffff\u0000\u011c\u011e"+
		"\u0001\u0000\u0000\u0000\u011d\u0115\u0001\u0000\u0000\u0000\u011d\u0118"+
		"\u0001\u0000\u0000\u0000\u011e\u001f\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0003\"\u0011\u0000\u0120\u0121\u0006\u0010\uffff\uffff\u0000\u0121\u0128"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0003\"\u0011\u0000\u0123\u0124\u0005"+
		"\u001d\u0000\u0000\u0124\u0125\u0003\"\u0011\u0000\u0125\u0126\u0006\u0010"+
		"\uffff\uffff\u0000\u0126\u0128\u0001\u0000\u0000\u0000\u0127\u011f\u0001"+
		"\u0000\u0000\u0000\u0127\u0122\u0001\u0000\u0000\u0000\u0128!\u0001\u0000"+
		"\u0000\u0000\u0129\u012a\u0003$\u0012\u0000\u012a\u012b\u0006\u0011\uffff"+
		"\uffff\u0000\u012b\u0132\u0001\u0000\u0000\u0000\u012c\u012d\u0003$\u0012"+
		"\u0000\u012d\u012e\u0005\u001c\u0000\u0000\u012e\u012f\u0003$\u0012\u0000"+
		"\u012f\u0130\u0006\u0011\uffff\uffff\u0000\u0130\u0132\u0001\u0000\u0000"+
		"\u0000\u0131\u0129\u0001\u0000\u0000\u0000\u0131\u012c\u0001\u0000\u0000"+
		"\u0000\u0132#\u0001\u0000\u0000\u0000\u0133\u0134\u0006\u0012\uffff\uffff"+
		"\u0000\u0134\u0135\u0003&\u0013\u0000\u0135\u0136\u0006\u0012\uffff\uffff"+
		"\u0000\u0136\u013e\u0001\u0000\u0000\u0000\u0137\u0138\n\u0001\u0000\u0000"+
		"\u0138\u0139\u0005\u0016\u0000\u0000\u0139\u013a\u0003&\u0013\u0000\u013a"+
		"\u013b\u0006\u0012\uffff\uffff\u0000\u013b\u013d\u0001\u0000\u0000\u0000"+
		"\u013c\u0137\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000\u0000\u0000"+
		"\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000"+
		"\u013f%\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0006\u0013\uffff\uffff\u0000\u0142\u0143\u0003(\u0014\u0000\u0143"+
		"\u0144\u0006\u0013\uffff\uffff\u0000\u0144\u014c\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\n\u0001\u0000\u0000\u0146\u0147\u0005\u0018\u0000\u0000\u0147"+
		"\u0148\u0003(\u0014\u0000\u0148\u0149\u0006\u0013\uffff\uffff\u0000\u0149"+
		"\u014b\u0001\u0000\u0000\u0000\u014a\u0145\u0001\u0000\u0000\u0000\u014b"+
		"\u014e\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c"+
		"\u014d\u0001\u0000\u0000\u0000\u014d\'\u0001\u0000\u0000\u0000\u014e\u014c"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0005\u0016\u0000\u0000\u0150\u0151"+
		"\u0003(\u0014\u0000\u0151\u0152\u0006\u0014\uffff\uffff\u0000\u0152\u015b"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0005\u001b\u0000\u0000\u0154\u0155"+
		"\u0003(\u0014\u0000\u0155\u0156\u0006\u0014\uffff\uffff\u0000\u0156\u015b"+
		"\u0001\u0000\u0000\u0000\u0157\u0158\u0003*\u0015\u0000\u0158\u0159\u0006"+
		"\u0014\uffff\uffff\u0000\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u014f"+
		"\u0001\u0000\u0000\u0000\u015a\u0153\u0001\u0000\u0000\u0000\u015a\u0157"+
		"\u0001\u0000\u0000\u0000\u015b)\u0001\u0000\u0000\u0000\u015c\u015d\u0003"+
		"\u001c\u000e\u0000\u015d\u015e\u0006\u0015\uffff\uffff\u0000\u015e\u0171"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0005\u001f\u0000\u0000\u0160\u0161"+
		"\u0005\u000e\u0000\u0000\u0161\u0162\u0003,\u0016\u0000\u0162\u0163\u0005"+
		"\u000f\u0000\u0000\u0163\u0164\u0006\u0015\uffff\uffff\u0000\u0164\u0171"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0005\u000e\u0000\u0000\u0166\u0167"+
		"\u0003\u001e\u000f\u0000\u0167\u0168\u0005\u000f\u0000\u0000\u0168\u0169"+
		"\u0006\u0015\uffff\uffff\u0000\u0169\u0171\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\u0007\u0001\u0000\u0000\u016b\u0171\u0006\u0015\uffff\uffff\u0000"+
		"\u016c\u016d\u0003\u001c\u000e\u0000\u016d\u016e\u0007\u0002\u0000\u0000"+
		"\u016e\u016f\u0006\u0015\uffff\uffff\u0000\u016f\u0171\u0001\u0000\u0000"+
		"\u0000\u0170\u015c\u0001\u0000\u0000\u0000\u0170\u015f\u0001\u0000\u0000"+
		"\u0000\u0170\u0165\u0001\u0000\u0000\u0000\u0170\u016a\u0001\u0000\u0000"+
		"\u0000\u0170\u016c\u0001\u0000\u0000\u0000\u0171+\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0003.\u0017\u0000\u0173\u0174\u0006\u0016\uffff\uffff\u0000"+
		"\u0174\u0177\u0001\u0000\u0000\u0000\u0175\u0177\u0001\u0000\u0000\u0000"+
		"\u0176\u0172\u0001\u0000\u0000\u0000\u0176\u0175\u0001\u0000\u0000\u0000"+
		"\u0177-\u0001\u0000\u0000\u0000\u0178\u0179\u0006\u0017\uffff\uffff\u0000"+
		"\u0179\u017a\u0003 \u0010\u0000\u017a\u017b\u0006\u0017\uffff\uffff\u0000"+
		"\u017b\u0183\u0001\u0000\u0000\u0000\u017c\u017d\n\u0002\u0000\u0000\u017d"+
		"\u017e\u0005\u0015\u0000\u0000\u017e\u017f\u0003 \u0010\u0000\u017f\u0180"+
		"\u0006\u0017\uffff\uffff\u0000\u0180\u0182\u0001\u0000\u0000\u0000\u0181"+
		"\u017c\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"/\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0019=I"+
		"Zmw\u0084\u0086\u0093\u009f\u00ae\u00bb\u00bd\u00ca\u0101\u0109\u0113"+
		"\u011d\u0127\u0131\u013e\u014c\u015a\u0170\u0176\u0183";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}