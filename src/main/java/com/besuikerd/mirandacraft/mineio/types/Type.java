package com.besuikerd.mirandacraft.mineio.types;

public class Type implements Coercible{
	protected TypeKind kind;
	
	public static final Type INT = new Type(TypeKind.INT);
	public static final Type BOOLEAN = new Type(TypeKind.BOOLEAN);
	public static final Type STRING = new Type(TypeKind.STRING);
	public static final Type ERROR = new Type(TypeKind.ERROR);
	public static final Type VOID = new Type(TypeKind.VOID);
	public static final Type ITEM = new Type(TypeKind.ITEM);
	public static final Type RECIPE = new Type(TypeKind.RECIPE);
	public static final Type CONTAINER = new Type(TypeKind.CONTAINER);
	
	
	public Type(TypeKind kind) {
		this.kind = kind;
	}	
	
	public TypeKind getKind() {
		return kind;
	}
	
	public String getDescription(){
		return kind.getReadableValue();
	}
	
	public boolean matchesType(Type other){
		return kind == other.kind || other instanceof AnyType;
	}

	@Override
	public Type coerceTo(TypeKind kind) {
		switch(kind){
		case STRING:
			return new Type(kind);
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		return getDescription();
	}
}
