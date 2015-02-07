package com.besuikerd.mirandacraft.mineio.errorreport;

public abstract class CompilerMessageBaseVisitor implements CompilerMessageVisitor{
	@Override
	public void visitCompilerMessage(CompilerMessage msg) {
	}
	
	@Override
	public void visitCompilerError(CompilerError error) {
	}
	
	public void visitCompilerWarning(CompilerWarning warning) {
		
	};
}
