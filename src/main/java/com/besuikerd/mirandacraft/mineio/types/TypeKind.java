package com.besuikerd.mirandacraft.mineio.types;

public enum TypeKind {
	VOID("void"),
	INT("int"),
	BOOLEAN("boolean"),
	STRING("String"),
	CONTAINER("container"),
	RECIPE("recipe"),
	ITEM("item"),
	ARRAY("array"),
	TUPLE("tuple"),
	FUNCTION("function"),
	ERROR("error")
	;
	
	private String readableValue;

	private TypeKind(String readableValue) {
		this.readableValue = readableValue;
	}
	
	public String getReadableValue() {
		return readableValue;
	}
}
