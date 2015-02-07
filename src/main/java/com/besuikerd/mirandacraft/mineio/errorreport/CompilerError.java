package com.besuikerd.mirandacraft.mineio.errorreport;

public class CompilerError extends CompilerMessage{
	public CompilerError(String message, int startLine, int startColumn,
			int endLine, int endColumn) {
		super(message, startLine, startColumn, endLine, endColumn);
	}

	@Override
	public void accept(CompilerMessageVisitor visitor) {
		visitor.visitCompilerError(this);
	}
}