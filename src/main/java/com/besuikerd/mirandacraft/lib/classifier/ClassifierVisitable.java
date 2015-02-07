package com.besuikerd.mirandacraft.lib.classifier;

public interface ClassifierVisitable {
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG arg);
}