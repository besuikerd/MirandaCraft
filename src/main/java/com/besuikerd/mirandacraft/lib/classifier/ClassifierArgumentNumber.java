package com.besuikerd.mirandacraft.lib.classifier;

public abstract class ClassifierArgumentNumber<A extends Number> extends ClassifierArgument<A>{
	public ClassifierArgumentNumber(String name, A value, boolean equals) {
		super(name, value, equals);
	}
}
