package com.besuikerd.mirandacraft.mineio.types;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;
import com.besuikerd.mirandacraft.mineio.parser.MineIOBaseVisitor;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ReturnStatementContext;

/**
 * searches for return types and concatenates them into a list
 * @author Nick
 *
 */
public class MineIOReturnTypeVisitor extends MineIOBaseVisitor<List<Tuple2<Type, ParserRuleContext>>>{
	
	private List<Tuple2<Type, ParserRuleContext>> types;
	private MineIOTypeVisitor typeVisitor;
	
	public MineIOReturnTypeVisitor() {
		types = new ArrayList<Tuple2<Type,ParserRuleContext>>();
		typeVisitor = new MineIOTypeVisitor();
	}
	
	@Override
	public List<Tuple2<Type, ParserRuleContext>> visitReturnStatement(ReturnStatementContext ctx) {
		types.add(new Tuple2<Type, ParserRuleContext>(ctx.exp().accept(typeVisitor), ctx.exp()));
		return types;
	}
	
	@Override
	protected List<Tuple2<Type, ParserRuleContext>> aggregateResult(
			List<Tuple2<Type, ParserRuleContext>> aggregate,
			List<Tuple2<Type, ParserRuleContext>> nextResult) {
		return aggregate == null ? nextResult : aggregate;
	}
}
