package com.besuikerd.mirandacraft.mineio.errorreport;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import com.besuikerd.mirandacraft.mineio.namespace.Environment;

public class CompilerMessageReporterSyntaxErrorListener extends BaseErrorListener{
	private CompilerMessageReporter reporter;
	
	public CompilerMessageReporterSyntaxErrorListener(CompilerMessageReporter reporter) {
		this.reporter = reporter;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		reporter.addMessage(new SyntaxError(String.format("Syntax error: %s", msg), line, charPositionInLine, line, charPositionInLine));
	}
}
