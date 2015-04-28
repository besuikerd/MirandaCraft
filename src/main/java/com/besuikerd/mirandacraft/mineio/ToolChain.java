package com.besuikerd.mirandacraft.mineio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;

import com.besuikerd.mirandacraft.mineio.errorreport.CompilerMessageReporterSyntaxErrorListener;
import com.besuikerd.mirandacraft.mineio.namespace.Environment;
import com.besuikerd.mirandacraft.mineio.parser.MineIOLexer;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ProgramContext;
import com.besuikerd.mirandacraft.mineio.types.MineIOTypeChecker;

public class ToolChain {
	public ProgramContext parse(Environment environment, String input) throws RecognitionException{
		return parse(environment, toStream(input));
	}
	
	public ProgramContext parse(Environment environment, File input) throws RecognitionException, IOException{
		return parse(environment, toStream(input));
	}
	
	public ProgramContext parse(Environment environment, InputStream input) throws RecognitionException, IOException{
		return parse(environment, new ANTLRInputStream(input));
	}
	
	private ProgramContext parse(Environment environment, ANTLRInputStream input) throws RecognitionException{
		return parser(environment, input).program();
	}
	
	public MineIOParser parser(Environment environment, String input){
		return parser(environment, toStream(input));
	}
	
	public MineIOParser parser(Environment environment, File input) throws IOException{
		return parser(environment, toStream(input));
	}
	
	private ANTLRInputStream toStream(String s){
		return new ANTLRInputStream(s);
	}
	
	private ANTLRInputStream toStream(File f) throws IOException{
		return new ANTLRFileStream(f.getAbsolutePath());
	}
	
	public MineIOParser parser(Environment environment, ANTLRInputStream input){
		MineIOParser parser = new MineIOParser(lexer(environment, input));
		parser.removeErrorListeners();
		parser.addErrorListener(new CompilerMessageReporterSyntaxErrorListener(environment.reporter));
		return parser;
	}
	
	public TokenStream lexer(Environment environment, ANTLRInputStream input){
		MineIOLexer lexer = new MineIOLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(new CompilerMessageReporterSyntaxErrorListener(environment.reporter));
		return new CommonTokenStream(lexer);
	}
	
	public ToolChain typeCheck(Environment environment, ProgramContext ctx){
		ctx.accept(new MineIOTypeChecker(environment));
		return this;
	}
}
