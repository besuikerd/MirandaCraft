package com.besuikerd.mirandacraft.mineio.errorreport;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class OutputStreamCompilerMessageVisitor extends CompilerMessageBaseVisitor{
	private PrintStream stream;
	
	public OutputStreamCompilerMessageVisitor(OutputStream output){
		this.stream = new PrintStream(output);
	}
	
	@Override
	public void visitCompilerError(CompilerError error) {
		stream.println("Error" + error.toString());
	}
	
	@Override
	public void visitCompilerWarning(CompilerWarning warning) {
		stream.println("Warning" + warning.toString());
	}
}
