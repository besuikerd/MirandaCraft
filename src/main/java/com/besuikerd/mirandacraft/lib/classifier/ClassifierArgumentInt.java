package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentInt extends ClassifierArgumentNumber<Integer>{

	public ClassifierArgumentInt(String name, Integer value, boolean equals) {
		super(name, value, equals);
	}
	
	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitArgumentInt(visitor, this, obj);
	}
}