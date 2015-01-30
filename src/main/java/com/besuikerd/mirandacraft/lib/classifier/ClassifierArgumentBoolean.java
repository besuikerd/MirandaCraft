package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentBoolean extends ClassifierArgument<Boolean>{

	public ClassifierArgumentBoolean(String name, Boolean value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitArgumentBoolean(visitor, this, obj);
	}

}
