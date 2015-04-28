package com.besuikerd.mirandacraft.mineio.types;

import com.besuikerd.mirandacraft.mineio.parser.MineIOBaseVisitor;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeBecomesAddContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeBecomesContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeBecomesDivContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeBecomesMulContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeBecomesSubContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.AssignmentTypeContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpArrayLiteralContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpBooleanLiteralContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpIntLiteralContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpParensContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpStringLiteralContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ExpTupleLiteralContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.FormalParameterContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeArrayContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeBooleanContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeContainerContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeIntContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeItemContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeRecipeContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeStringContext;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.TypeTupleContext;

public class MineIOTypeVisitor extends MineIOBaseVisitor<Type>{

	@Override
	public Type visitExpIntLiteral(ExpIntLiteralContext ctx) {
		return Type.INT;
	}
	
	@Override
	public Type visitExpBooleanLiteral(ExpBooleanLiteralContext ctx) {
		return Type.BOOLEAN;
	}
	
	@Override
	public Type visitExpStringLiteral(ExpStringLiteralContext ctx) {
		return Type.STRING;
	}
	
	@Override
	public Type visitExpArrayLiteral(ExpArrayLiteralContext ctx) {
		Type innerType = null;
		for(int i = 0 ; i < ctx.exp().size() ; i++){
			ExpContext exp = ctx.exp(i);
			Type expType = exp.accept(this);
			if(innerType == null){
				innerType = expType;
			} else if(!innerType.matchesType(exp.accept(this))){
				throw new TypeException(exp, "Expected element type: %s, got: %s", innerType.getDescription(), expType.getDescription());
			}
		}
		return innerType;
	}
	
	@Override
	public Type visitExpTupleLiteral(ExpTupleLiteralContext ctx) {
		Type[] innerTypes = new Type[ctx.exp().size()];
		for(int i = 0 ; i < innerTypes.length ; i++){
			innerTypes[i] = ctx.exp(i).accept(this);
		}
		return new TupleType(innerTypes);
	}
	
	@Override
	public Type visitExpParens(ExpParensContext ctx) {
		return ctx.exp().accept(this);
	}
	
	@Override
	public Type visitFormalParameter(FormalParameterContext ctx) {
		return ctx.typeRef().accept(this);
	}
	
	@Override
	public Type visitTypeInt(TypeIntContext ctx) {
		return new Type(TypeKind.INT);
	}
	
	@Override
	public Type visitTypeString(TypeStringContext ctx) {
		return new Type(TypeKind.STRING);
	}
	
	@Override
	public Type visitTypeBoolean(TypeBooleanContext ctx) {
		return new Type(TypeKind.BOOLEAN);
	}
	
	@Override
	public Type visitTypeContainer(TypeContainerContext ctx) {
		return new Type(TypeKind.CONTAINER);
	}
	
	@Override
	public Type visitTypeItem(TypeItemContext ctx) {
		return new Type(TypeKind.ITEM);
	}
	
	@Override
	public Type visitTypeRecipe(TypeRecipeContext ctx) {
		return new Type(TypeKind.RECIPE);
	}
	
	@Override
	public Type visitTypeTuple(TypeTupleContext ctx) {
		Type[] innerTypes = new Type[ctx.typeRef().size()];
		for(int i = 0 ; i < innerTypes.length ; i++){
			innerTypes[i] = ctx.typeRef(i).accept(this);
		}
		return new TupleType(innerTypes);
	}
	
	@Override
	public Type visitTypeArray(TypeArrayContext ctx) {
		return new ArrayType(ctx.typeRef().accept(this));
	}
	
	@Override
	public Type visitAssignmentTypeBecomes(AssignmentTypeBecomesContext ctx) {
		return new FunctionType(new AnyType(), new AnyType());
	}
	
	@Override
	public Type visitAssignmentTypeBecomesAdd(
			AssignmentTypeBecomesAddContext ctx) {
		return new FunctionType(new TupleType(Type.INT), Type.INT);
	}
	
	@Override
	public Type visitAssignmentTypeBecomesDiv(
			AssignmentTypeBecomesDivContext ctx) {
		return new FunctionType(new TupleType(Type.INT), Type.INT);
	}
	
	@Override
	public Type visitAssignmentTypeBecomesMul(
			AssignmentTypeBecomesMulContext ctx) {
		return new FunctionType(new TupleType(Type.INT), Type.INT);
	}
	
	@Override
	public Type visitAssignmentTypeBecomesSub(
			AssignmentTypeBecomesSubContext ctx) {
		return new FunctionType(new TupleType(Type.INT), Type.INT);
	}
}
