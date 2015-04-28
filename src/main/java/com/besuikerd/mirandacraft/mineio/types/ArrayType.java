package com.besuikerd.mirandacraft.mineio.types;

public class ArrayType extends Type {
	protected Type innerType;
	
	public ArrayType(Type innerType) {
		super(TypeKind.ARRAY);
		this.innerType = innerType;
	}
	
	public Type getInnerType(){
		return innerType;
	}
	
	@Override
	public String getDescription() {
		return String.format("[%s]", innerType);
	}
	
	@Override
	public boolean matchesType(Type other) {
		return other.kind == TypeKind.ARRAY && other instanceof ArrayType && innerType.matchesType(((ArrayType) other).innerType);
	}
}
