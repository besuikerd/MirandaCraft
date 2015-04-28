package com.besuikerd.mirandacraft.mineio.types;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;
import com.besuikerd.mirandacraft.mineio.namespace.DuplicateNameException;
import com.besuikerd.mirandacraft.mineio.namespace.Environment;
import com.besuikerd.mirandacraft.mineio.namespace.InvalidScopeException;
import com.besuikerd.mirandacraft.mineio.namespace.UnknownNameException;
import com.besuikerd.mirandacraft.mineio.namespace.VariableNamespaceEntry;
import com.besuikerd.mirandacraft.mineio.parser.MineIOBaseVisitor;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.FormalParameterContext;
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

public class MineIOTypeChecker extends MineIOBaseVisitor<Void>{
	private Environment environment;
	private MineIOTypeVisitor typeVisitor;
	
	
	public MineIOTypeChecker(Environment environment) {
		this.environment = environment;
		this.typeVisitor = new MineIOTypeVisitor();
	}
	
	@Override
	public Void visitProgram(ProgramContext ctx) {
		environment.variables.openScope();
		for(StatementSemicolonContext statementSemicolonContext : ctx.statementSemicolon()){
			statementSemicolonContext.accept(this);
		}
		try {
			environment.variables.closeScope();
		} catch (InvalidScopeException e) {
			environment.reporter.errors.invalidScopeClose(ctx);
		}
		return null;
	}
	
	@Override
	public Void visitStatementDeclaration(StatementDeclarationContext ctx) {
		Type expectedType = ctx.typeRef().accept(typeVisitor);
		if(ctx.exp() != null){
			Type actualType = ctx.exp().accept(typeVisitor);
			if(!expectedType.matchesType(actualType)){
				environment.reporter.errors.wrongType(ctx.exp(), expectedType, actualType);
			}
		}
		try {
			environment.variables.enter(ctx.variable().getText(), new VariableNamespaceEntry(ctx.variable(), expectedType));
		} catch (InvalidScopeException e) {
			environment.reporter.errors.invalidScopeOnEnter(ctx, ctx.variable().getText());
		} catch (DuplicateNameException e) {
			environment.reporter.errors.duplicateVariableDeclaration(ctx, ctx.variable().getText());
		}
		return null;
	}
	
	@Override
	public Void visitStatementAssignment(StatementAssignmentContext ctx) {
		try{
			environment.variables.retrieve(ctx.variable().getText());
		} catch(UnknownNameException e){
			Type expressionType = ctx.exp().accept(typeVisitor);
			try {
				environment.variables.enter(ctx.variable().getText(), new VariableNamespaceEntry(ctx.variable(), expressionType));
			} catch (InvalidScopeException e1) {
				environment.reporter.errors.invalidScopeOnEnter(ctx, ctx.variable().getText());
			} catch (DuplicateNameException e1) {
				//should not occur
				environment.reporter.errors.duplicateVariableDeclaration(ctx, ctx.variable().getText());
			}
		}
		return null;
	}
	
	@Override
	public Void visitStatementBlock(StatementBlockContext ctx) {
		for(StatementSemicolonContext c : ctx.statementSemicolon()){
			c.accept(this);
		}
		return null;
	}
	
	@Override
	public Void visitStatementCondition(StatementConditionContext ctx) {
		Type predicateType = ctx.exp().accept(typeVisitor);
		if(!predicateType.equals(Type.BOOLEAN)){
			environment.reporter.errors.wrongPredicateType(ctx.exp(), predicateType);
		}
		for(StatementContext statementContext : ctx.statement()){
			statementContext.accept(this);
		}
		return null;
	}
	
	@Override
	public Void visitStatementWhile(StatementWhileContext ctx) {
		Type predicateType = ctx.exp().accept(typeVisitor);
		if(!predicateType.equals(Type.BOOLEAN)){
			environment.reporter.errors.wrongPredicateType(ctx.exp(), predicateType);
		}
		ctx.statement().accept(this);
		return null;
	}
	
	@Override
	public Void visitStatementExpression(StatementExpressionContext ctx) {
		ctx.exp().accept(this);
		return null;
	}
	
	@Override
	public Void visitStatementForeach(StatementForeachContext ctx) {
		Type iterationType = ctx.exp().accept(typeVisitor);
		if(!(iterationType instanceof ArrayType) || iterationType.getKind() != TypeKind.ARRAY){
			environment.reporter.errors.wrongIterationType(ctx, iterationType);
		} else{
			ArrayType arrayType = (ArrayType) iterationType;
			environment.variables.openScope();
			try {
				environment.variables.enter(ctx.variable().getText(), new VariableNamespaceEntry(ctx.variable(), arrayType.innerType));
				ctx.statement().accept(this);
			} catch (InvalidScopeException e) {
				environment.reporter.errors.invalidScopeOnEnter(ctx.variable(), ctx.variable().getText());
			} catch (DuplicateNameException e) {
				environment.reporter.errors.duplicateVariableDeclaration(ctx.variable(), ctx.variable().getText());
			} finally{
				try {
					environment.variables.closeScope();
				} catch (InvalidScopeException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Override
	public Void visitStatementFunctionDeclaration(StatementFunctionDeclarationContext ctx) {
		Type definedReturnType = ctx.typeRef() != null ? ctx.typeRef().accept(typeVisitor) : null;
		Type returnType = new MineIOReturnTypeVisitor(environment, definedReturnType).visit(ctx.functionBody().statement());
		System.out.println(returnType);
		
		
		Type[] formalParameterTypes = new Type[ctx.formalParameter().size()];
		for(int i = 0 ; i < formalParameterTypes.length ; i++){
			formalParameterTypes[i] = ctx.formalParameter(i).accept(typeVisitor);
		}
		try {
			if(returnType == null){
				returnType = Type.VOID;
			}
			environment.variables.enter(ctx.variable().getText(), new VariableNamespaceEntry(ctx.variable(), new FunctionType(formalParameterTypes, returnType)));
		} catch (InvalidScopeException e) {
			environment.reporter.errors.invalidScopeOnEnter(ctx.variable(), ctx.variable().getText());
		} catch (DuplicateNameException e) {
			environment.reporter.errors.duplicateVariableDeclaration(ctx.variable(), ctx.variable().getText());
		}
		
		environment.variables.openScope();
		for(FormalParameterContext formalParameterContext : ctx.formalParameter()){
			try {
				environment.variables.forceEnter(formalParameterContext.variable().getText(), new VariableNamespaceEntry(formalParameterContext.variable(), formalParameterContext.typeRef().accept(typeVisitor)));
			} catch (InvalidScopeException e) {
				environment.reporter.errors.invalidScopeOnEnter(ctx.variable(), ctx.variable().getText());
			}
		}
		
		try {
			environment.variables.closeScope();
		} catch (InvalidScopeException e) {
			environment.reporter.errors.invalidScopeClose(ctx);
		}
		
		ctx.functionBody().statement().accept(this);
		
		return null;
	}
	
	@Override
	public Void visitStatementReturn(StatementReturnContext ctx) {
		ctx.exp().accept(this);
		return null;
	}
	
	@Override
	public Void visitStatementSemicolon(StatementSemicolonContext ctx) {
		ctx.statement().accept(this);
		return null;
	}
}
