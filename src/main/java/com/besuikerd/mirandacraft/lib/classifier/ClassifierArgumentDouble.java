package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentDouble extends ClassifierArgumentNumber<Double>{

	public ClassifierArgumentDouble(String name, Double value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitArgumentDouble(visitor, this, obj);
	}
}
