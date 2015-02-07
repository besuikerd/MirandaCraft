package com.besuikerd.mirandacraft.mineio.types;

import org.antlr.v4.runtime.ParserRuleContext;

public class TypeException extends RuntimeException {
	protected ParserRuleContext context;

	public TypeException(ParserRuleContext context, String message, Object... args) {
		super(String.format("[%s:%s] %s", context.start.getLine(), context.start.getCharPositionInLine(), String.format(message, args)));
		this.context = context;
	}
	
	public ParserRuleContext getContext() {
		return context;
	}
}
