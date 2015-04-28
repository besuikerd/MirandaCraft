package com.besuikerd.mirandacraft.mineio.types;

public class FunctionType extends Type{

	private Type[] parameterTypes;
	private Type returnType;
	
	public FunctionType(Type[] parameterTypes, Type returnType) {
		super(TypeKind.FUNCTION);
		this.parameterTypes = parameterTypes;
		this.returnType = returnType;
	}
	
	public FunctionType(Type singleParameterType, Type returnType) {
		this(new Type[]{singleParameterType}, returnType);
	}
	
	public FunctionType(Type returnType) {
		this(new Type[0], returnType);
	}
	
	public FunctionType() {
		this(Type.VOID);
	}
	
	public Type[] getParameterTypes() {
		return parameterTypes;
	}
	
	public Type getReturnType() {
		return returnType;
	}
}
