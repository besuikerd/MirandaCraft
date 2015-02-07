package com.besuikerd.mirandacraft.mineio.errorreport;

public class CompilerMessage {
	protected String message;
	protected int startLine;
	protected int startColumn;
	protected int endLine;
	protected int endColumn;
	public CompilerMessage(String message, int startLine, int startColumn,
			int endLine, int endColumn) {
		this.message = message;
		this.startLine = startLine;
		this.startColumn = startColumn;
		this.endLine = endLine;
		this.endColumn = endColumn;
	}

	public void accept(CompilerMessageVisitor visitor){
		visitor.visitCompilerMessage(this);
	}
	
	@Override
	public String toString() {
		return String.format("[%d:%d - %d:%d] %s", startLine, startColumn, endLine, endColumn, message);
	}
}
