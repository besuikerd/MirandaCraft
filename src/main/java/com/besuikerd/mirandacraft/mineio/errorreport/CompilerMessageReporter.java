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
		public void invalidScopeClose(ParserRuleContext ctx, String message){
			error(ctx, "Unable to close scope: %s", message);
		}
		
		public void wrongType(ParserRuleContext ctx, Type expected, Type actual){
			error(ctx, "Expected type: %s, actual type: %s", expected.getDescription(), actual.getDescription());
		}
		
		public void wrongReturnType(ParserRuleContext ctx, Type expected, Type actual){
			error(ctx, "All return types should have the same type, expected type: %s, actual type: %s", expected.getDescription(), actual.getDescription());
		}
	}
	
	public class WarningMessages{
		
	}
}
