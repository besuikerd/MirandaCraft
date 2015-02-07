package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentInt extends ClassifierArgumentNumber<Integer>{

	public ClassifierArgumentInt(String name, Integer value, boolean equals) {
		super(name, value, equals);
	}
	
	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentInt(visitor, this, obj);
	}
}