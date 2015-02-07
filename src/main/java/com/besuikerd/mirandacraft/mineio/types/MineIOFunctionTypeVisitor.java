package com.besuikerd.mirandacraft.mineio.types;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;
import com.besuikerd.mirandacraft.mineio.namespace.Environment;
import com.besuikerd.mirandacraft.mineio.namespace.InvalidScopeException;
import com.besuikerd.mirandacraft.mineio.parser.MineIOBaseVisitor;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.FunctionBodyContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.FunctionDeclarationContext;

public class MineIOFunctionTypeVisitor extends MineIOBaseVisitor<Void>{
	private MineIOTypeVisitor typeVisitor = new MineIOTypeVisitor();
	
	protected Environment environment;
	
	public MineIOFunctionTypeVisitor(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Void visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		ctx.functionBody().accept(this);
		return null;
	}

	@Override
	public Void visitFunctionBody(FunctionBodyContext ctx) {
		List<Tuple2<Type, ParserRuleContext>> returnTypes = ctx.statement().accept(new MineIOReturnTypeVisitor());
		Type expectedReturnType = null;
		for(int i = 0 ; i < returnTypes.size() ; i++){
			Tuple2<Type, ParserRuleContext> returnType = returnTypes.get(i);
			if(expectedReturnType == null){
				expectedReturnType = returnType._1;
			} else if(!expectedReturnType.matchesType(returnType._1)){
				environment.reporter.errors.wrongReturnType(returnType._2, expectedReturnType, returnType._1);
			}
		}
		
		return super.visitFunctionBody(ctx);
	}
	
}
