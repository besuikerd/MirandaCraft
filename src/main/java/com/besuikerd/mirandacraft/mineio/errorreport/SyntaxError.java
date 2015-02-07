package com.besuikerd.mirandacraft.mineio.errorreport;

public class SyntaxError extends CompilerError{

	public SyntaxError(String message, int startLine, int startColumn,
			int endLine, int endColumn) {
		super(message, startLine, startColumn, endLine, endColumn);
	}
}
