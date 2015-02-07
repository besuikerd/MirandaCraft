package com.besuikerd.mirandacraft.mineio.types;

public class Type implements Coercible{
	protected TypeKind kind;
	protected String value;
	
	public Type(TypeKind kind, String value) {
		this.kind = kind;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public TypeKind getKind() {
		return kind;
	}
	
	public String getDescription(){
		return kind.getReadableValue();
	}
	
	public boolean matchesType(Type other){
		return kind == other.kind || kind == TypeKind.ERROR || other.kind == TypeKind.ERROR;
	}

	@Override
	public Type coerceTo(TypeKind kind) {
		switch(kind){
		case STRING:
			return new Type(kind, value);
		default:
			return null;
		}
	}
}
