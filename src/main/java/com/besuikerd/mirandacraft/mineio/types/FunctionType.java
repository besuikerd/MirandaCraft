package com.besuikerd.mirandacraft.mineio.types;

public class FunctionType extends Type{

	private TupleType parameterType;
	private Type returnType;
	
	public FunctionType(String value, TupleType parameterType, Type returnType) {
		super(TypeKind.FUNCTION, value);
		this.parameterType = parameterType;
		this.returnType = returnType;
	}
}
