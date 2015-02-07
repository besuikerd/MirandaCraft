package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierArgumentDouble extends ClassifierArgumentNumber<Double>{

	public ClassifierArgumentDouble(String name, Double value, boolean equals) {
		super(name, value, equals);
	}

	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentDouble(visitor, this, obj);
	}
}
