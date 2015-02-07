// Generated from MineIO.g4 by ANTLR 4.5

package com.besuikerd.mirandacraft.mineio.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MineIOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MineIOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MineIOParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MineIOParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MineIOParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MineIOParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MineIOParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MineIOParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MineIOParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MineIOParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#foreachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachStatement(MineIOParser.ForeachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MineIOParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MineIOParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(MineIOParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(MineIOParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#assignmentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentType(MineIOParser.AssignmentTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIntLiteral}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIntLiteral(MineIOParser.ExpIntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpSelect}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpSelect(MineIOParser.ExpSelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpIndexed}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpIndexed(MineIOParser.ExpIndexedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpTupleLiteral}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpTupleLiteral(MineIOParser.ExpTupleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpFunctionCall}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpFunctionCall(MineIOParser.ExpFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpBooleanLiteral}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpBooleanLiteral(MineIOParser.ExpBooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpVarRef}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpVarRef(MineIOParser.ExpVarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpBinary}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpBinary(MineIOParser.ExpBinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpUnary}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpUnary(MineIOParser.ExpUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParens}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParens(MineIOParser.ExpParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpItemDescriptor}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpItemDescriptor(MineIOParser.ExpItemDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpField}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpField(MineIOParser.ExpFieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpArrayLiteral}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpArrayLiteral(MineIOParser.ExpArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpStringLiteral}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStringLiteral(MineIOParser.ExpStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpTransfer}
	 * labeled alternative in {@link MineIOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpTransfer(MineIOParser.ExpTransferContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#itemDescriptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDescriptor(MineIOParser.ItemDescriptorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#itemModName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemModName(MineIOParser.ItemModNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#itemName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemName(MineIOParser.ItemNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeItem}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeItem(MineIOParser.TypeItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeContainer}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeContainer(MineIOParser.TypeContainerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeRecipe}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRecipe(MineIOParser.TypeRecipeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(MineIOParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(MineIOParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBoolean(MineIOParser.TypeBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeArray}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArray(MineIOParser.TypeArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeTuple}
	 * labeled alternative in {@link MineIOParser#typeRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTuple(MineIOParser.TypeTupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MineIOParser#arrayRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayRef(MineIOParser.ArrayRefContext ctx);
}