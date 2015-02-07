package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentString extends ClassifierArgument<String>{
	public ClassifierArgumentString(String name, String value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentString(visitor, this, obj);
	}
}
