package com.besuikerd.mirandacraft.mineio.errorreport;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.besuikerd.mirandacraft.mineio.types.Type;

public class CompilerMessageReporter {
	private List<CompilerMessage> messages;
	
	public final ErrorMessages errors;
	public final WarningMessages warnings;
	
	public CompilerMessageReporter() {
		this.messages = new ArrayList<CompilerMessage>();
		this.errors = new ErrorMessages();
		this.warnings = new WarningMessages();
	}
	
	public void visit(CompilerMessageVisitor visitor){
		for(CompilerMessage message : messages){
			message.accept(visitor);
		}
	}
	
	public void addMessage(CompilerMessage message){
		messages.add(message);
	}

	public void error(int lineStart, int columnStart, int lineEnd, int columnEnd, String message, Object... args){
		messages.add(new CompilerError(String.format(message, args), lineStart, columnStart, lineEnd, columnEnd));
	}
	
	public void error(ParserRuleContext ctx, String message, Object... args){
		error(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.stop.getLine(), ctx.stop.getCharPositionInLine(), message, args);
	}
	
	public void warning(int lineStart, int columnStart, int lineEnd, int columnEnd, String message, Object... args){
		messages.add(new CompilerWarning(String.format(message, args), lineStart, columnStart, lineEnd, columnEnd));
	}
	
	public void warning(ParserRuleContext ctx, String message, Object... args){
		warning(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.stop.getLine(), ctx.stop.getCharPositionInLine(), message, args);
	}
	
	public class ErrorMessages{
		public void invalidScopeClose(ParserRuleContext ctx){
			error(ctx, "Unable to close scope");
		}
		
		public void invalidScopeOnEnter(ParserRuleContext ctx, String name){
			error(ctx, "Could not add %s: invalid scope", name);
		}
		
		public void duplicateVariableDeclaration(ParserRuleContext ctx, String name){
			error(ctx, "\"%s\" has been declared twice", name);
		}
		
		public void wrongType(ParserRuleContext ctx, Type expected, Type actual){
			error(ctx, "Invalid type, expected type: %s, actual type: %s", expected.getDescription(), actual.getDescription());
		}
		
		public void wrongReturnType(ParserRuleContext ctx, Type expected, Type actual){
			error(ctx, "All return types should have the same type, expected type: %s, actual type: %s", expected.getDescription(), actual.getDescription());
		}
		
		public void wrongPredicateType(ParserRuleContext ctx, Type actual){
			error(ctx, "Condition type should be boolean, got: %s", actual.getDescription());
		}
		
		public void wrongIterationType(ParserRuleContext ctx, Type actual){
			error(ctx, "Cannot loop over an expression of type %s", actual.getDescription());
		}
		
		public void unreachableCode(ParserRuleContext ctx){
			error(ctx, "Unreachable code");
		}
		
		public void missingReturnStatement(ParserRuleContext ctx){
			error(ctx, "Code path does not return a value");
		}
		
		public void notAlwaysReturns(ParserRuleContext ctx){
			error(ctx, "Code path does not always return a value");
		}
	}
	
	public class WarningMessages{
		
	}
}
