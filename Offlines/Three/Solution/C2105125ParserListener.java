// Generated from C2105125Parser.g4 by ANTLR 4.13.2

    import java.io.BufferedWriter;
    import java.io.IOException;
    import org.antlr.v4.runtime.Token;
    import java.util.LinkedList;
    import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C2105125Parser}.
 */
public interface C2105125ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(C2105125Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(C2105125Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(C2105125Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(C2105125Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(C2105125Parser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(C2105125Parser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declaration(C2105125Parser.Func_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#func_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declaration(C2105125Parser.Func_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#func_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunc_definition(C2105125Parser.Func_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#func_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunc_definition(C2105125Parser.Func_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(C2105125Parser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(C2105125Parser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(C2105125Parser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(C2105125Parser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(C2105125Parser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(C2105125Parser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#declaration_list_err}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list_err(C2105125Parser.Declaration_list_errContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#declaration_list_err}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list_err(C2105125Parser.Declaration_list_errContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(C2105125Parser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(C2105125Parser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list(C2105125Parser.Declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list(C2105125Parser.Declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(C2105125Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(C2105125Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C2105125Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C2105125Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(C2105125Parser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(C2105125Parser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(C2105125Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(C2105125Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C2105125Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C2105125Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogic_expression(C2105125Parser.Logic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#logic_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogic_expression(C2105125Parser.Logic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRel_expression(C2105125Parser.Rel_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRel_expression(C2105125Parser.Rel_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(C2105125Parser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(C2105125Parser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(C2105125Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(C2105125Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(C2105125Parser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(C2105125Parser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(C2105125Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(C2105125Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#argument_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_list(C2105125Parser.Argument_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#argument_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_list(C2105125Parser.Argument_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C2105125Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(C2105125Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C2105125Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(C2105125Parser.ArgumentsContext ctx);
}