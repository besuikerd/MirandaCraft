package com.besuikerd.mirandacraft.mineio.errorreport;

public interface CompilerMessageVisitor {
	public void visitCompilerMessage(CompilerMessage msg);
	public void visitCompilerWarning(CompilerWarning warning);
	public void visitCompilerError(CompilerError error);
}
