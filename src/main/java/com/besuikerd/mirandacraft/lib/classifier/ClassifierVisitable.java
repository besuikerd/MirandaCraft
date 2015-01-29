package com.besuikerd.mirandacraft.lib.classifier;

public interface ClassifierVisitable {
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj);
}