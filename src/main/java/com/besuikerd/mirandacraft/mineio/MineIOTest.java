package com.besuikerd.mirandacraft.mineio;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.RecognitionException;

import com.besuikerd.mirandacraft.mineio.errorreport.OutputStreamCompilerMessageVisitor;
import com.besuikerd.mirandacraft.mineio.namespace.Environment;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ProgramContext;

public class MineIOTest {
	public static void main(String[] args) throws RecognitionException, IOException{
		new MineIOTest().run();
	}
	
	public void run() throws RecognitionException, IOException{
		ToolChain tool = new ToolChain();
		Environment environment = new Environment();
		
		safeTypeCheck(tool, environment, safeParse(tool, environment, new File("test/function.mio")));
		
		System.out.println("Error report:");
		environment.reporter.visit(new OutputStreamCompilerMessageVisitor(System.out));
		System.out.println("-------------");
		
	}
	
	private ProgramContext safeParse(ToolChain tool, Environment environment, String s){
		return safeParse(tool.parser(environment, s));
	}
	
	private ProgramContext safeParse(ToolChain tool, Environment environment, File f) throws IOException{
		return safeParse(tool.parser(environment, f));
	}
	
	private ProgramContext safeParse(MineIOParser parser){
		try{
			return parser.program();
		} catch(RecognitionException e){
			return null;
		}
	}
	
	private void safeTypeCheck(ToolChain tool, Environment environment, ProgramContext ctx){
		if(ctx != null){
			tool.typeCheck(environment, ctx);
		}
	}
}
