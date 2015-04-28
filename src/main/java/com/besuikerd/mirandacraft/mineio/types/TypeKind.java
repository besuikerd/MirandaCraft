package com.besuikerd.mirandacraft.mineio.types;

public enum TypeKind {
	VOID("void"),
	INT("int"),
	BOOLEAN("boolean"),
	STRING("String"),
	CONTAINER("container"),
	RECIPE("recipe"),
	ITEM("item"),
	ERROR("error"),
	ANY("any"),
	ARRAY("array"),
	TUPLE("tuple"),
	FUNCTION("function")
	
	;
	
	private String readableValue;

	private TypeKind(String readableValue) {
		this.readableValue = readableValue;
	}
	
	public String getReadableValue() {
		return readableValue;
	}
}
