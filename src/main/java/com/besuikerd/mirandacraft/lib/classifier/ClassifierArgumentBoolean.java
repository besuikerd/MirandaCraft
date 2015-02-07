package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentBoolean extends ClassifierArgument<Boolean>{

	public ClassifierArgumentBoolean(String name, Boolean value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentBoolean(visitor, this, obj);
	}

}
