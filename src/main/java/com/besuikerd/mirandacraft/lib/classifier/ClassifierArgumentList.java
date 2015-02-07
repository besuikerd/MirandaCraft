package com.besuikerd.mirandacraft.lib.classifier;

import java.util.List;

public class ClassifierArgumentList extends ClassifierArgument<List<ClassifierArgument>>{

	public ClassifierArgumentList(String name, List<ClassifierArgument> value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentList(visitor, this, obj);
	}
}
