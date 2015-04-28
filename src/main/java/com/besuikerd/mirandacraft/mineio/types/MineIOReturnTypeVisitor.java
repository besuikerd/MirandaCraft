package com.besuikerd.mirandacraft.mineio.types;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;
import com.besuikerd.mirandacraft.mineio.namespace.Environment;
import com.besuikerd.mirandacraft.mineio.parser.MineIOBaseVisitor;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ProgramContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementAssignmentContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementBlockContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementConditionContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementDeclarationContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementExpressionContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementForeachContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementFunctionDeclarationContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementReturnContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementSemicolonContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.StatementWhileContext;

/**
 * searches for return types and concatenates them into a list
 * @author Nick
 *
 */
public class MineIOReturnTypeVisitor extends MineIOBaseVisitor<Type>{
	private Environment environment;
	
	private Type forcedReturnType;
	private Type returnType;
	private MineIOTypeVisitor typeVisitor;
	private boolean shouldReturn;
	
	public MineIOReturnTypeVisitor(Environment environment, Type returnType){
		this(environment, returnType, true);
	}
	
	private MineIOReturnTypeVisitor(Environment environment, Type returnType, boolean shouldReturn) {
		this.environment = environment;
		this.forcedReturnType = returnType;
		this.shouldReturn = shouldReturn;
		typeVisitor = new MineIOTypeVisitor();
	}
	
	@Override
	public Type visitStatementSemicolon(StatementSemicolonContext ctx) {
		return ctx.statement().accept(this);
	}
	
	@Override
	public Type visitStatementAssignment(
			StatementAssignmentContext ctx) {
		return returnType;
	}
	
	@Override
	public Type visitStatementDeclaration(
			StatementDeclarationContext ctx) {
		return returnType;
	}
	
	@Override
	public Type visitStatementExpression(
			StatementExpressionContext ctx) {
		return returnType;
	}
	
	@Override
	public Type visitStatementBlock(StatementBlockContext ctx) {
		MineIOReturnTypeVisitor blockVisitor = new MineIOReturnTypeVisitor(environment, null, false);
		for(int i = 0 ; i < ctx.statementSemicolon().size() ; i++){
			if(i == ctx.statementSemicolon().size() - 1){
				blockVisitor.shouldReturn = true;
			}
			
			StatementSemicolonContext statementContext = ctx.statementSemicolon(i);
			Type statementReturnType = statementContext.accept(blockVisitor);
			
			if(blockVisitor.forcedReturnType != null){
				forcedReturnType = blockVisitor.forcedReturnType;
			}
			
			if(statementReturnType != null){
				if(i < ctx.statementSemicolon().size() - 1){
					environment.reporter.errors.unreachableCode(ctx.statementSemicolon(i + 1));
					break;
				} else{
					returnType = statementReturnType;
				}
				
				
				
				if(forcedReturnType != null && !forcedReturnType.matchesType(statementReturnType)){
					environment.reporter.errors.wrongReturnType(statementContext, returnType, statementReturnType);
				}
			}
			System.out.println("forced return type: " + forcedReturnType);
		}
		if(shouldReturn && forcedReturnType != null && blockVisitor.returnType == null){
			environment.reporter.errors.missingReturnStatement(ctx);
		}
		
		return returnType;
	}
	
	@Override
	public Type visitStatementCondition(StatementConditionContext ctx) {
		Type conditionReturnType = returnType;
		if(ctx.statement().size() == 1){ //only an if block
			if(shouldReturn){
				environment.reporter.errors.notAlwaysReturns(ctx.statement(0));
			}
		}
		for(StatementContext statementContext : ctx.statement()){
			/*
			Type type = new MineIOReturnTypeVisitor(environment, null, shouldReturn).visit(statementContext);
			if(returnType != null && type == null){
				environment.reporter.errors.missingReturnStatement(statementContext);
			}
			*/
			Type type = statementContext.accept(this);
			System.out.println(type);
			if(shouldReturn && type == null){
				environment.reporter.errors.missingReturnStatement(statementContext);
			}
			
			if(type != null){
				forcedReturnType = type;
			}
			conditionReturnType = type;
		}
		this.returnType = conditionReturnType;
		return returnType;
	}
	
	@Override
	public Type visitStatementForeach(StatementForeachContext ctx) {
		new MineIOReturnTypeVisitor(environment, returnType, false).visit(ctx.statement());
		return returnType;
	}
	
	@Override
	public Type visitStatementFunctionDeclaration(
			StatementFunctionDeclarationContext ctx) {
		return returnType;
	}
	
	@Override
	public Type visitStatementWhile(StatementWhileContext ctx) {
		System.out.println(shouldReturn);
		
		
		//new MineIOReturnTypeVisitor(environment, returnType, false).visit(ctx.statement());
		return ctx.statement().accept(this);
	}
	
	@Override
	public Type visitStatementReturn(StatementReturnContext ctx) {
		Type expReturnType = ctx.exp().accept(typeVisitor);
		if(forcedReturnType != null && !forcedReturnType.matchesType(expReturnType)){
			environment.reporter.errors.wrongReturnType(ctx, returnType, expReturnType);
		}
		forcedReturnType = expReturnType;
		return expReturnType;
	}
}
