package com.besuikerd.mirandacraft.lib.classifier;

import java.util.List;

public class ClassifierArgumentList extends ClassifierArgument<List<ClassifierArgument>>{

	public ClassifierArgumentList(String name, List<ClassifierArgument> value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitArgumentList(visitor, this, obj);
	}
}
