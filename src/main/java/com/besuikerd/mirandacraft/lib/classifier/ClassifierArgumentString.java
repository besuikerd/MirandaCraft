package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentString extends ClassifierArgument<String>{
	public ClassifierArgumentString(String name, String value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitArgumentString(visitor, this, obj);
	}
}
