package com.besuikerd.mirandacraft.mineio.types;

public class AnyType extends Type{

	public AnyType() {
		this(TypeKind.ANY);
	}
	
	protected AnyType(TypeKind kind){
		super(kind);
	}

	@Override
	public boolean matchesType(Type other) {
		return true;
	}
}
