package com.besuikerd.mirandacraft.lib.classifier;

public interface ClassifierVisitor<ARG, RET>{
	RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj);
	RET visitActualRule(ClassifierVisitor<ARG, RET> visitor, ClassifierActualRule rule, ARG obj);
	RET visitAndRule(ClassifierVisitor<ARG, RET> visitor, ClassifierAndRule rule, ARG obj);
	RET visitOrRule(ClassifierVisitor<ARG, RET> visitor, ClassifierOrRule rule, ARG obj);
	RET visitArgumentDouble(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentDouble arg, ARG obj);
	RET visitArgumentInt(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentInt arg, ARG obj);
	RET visitArgumentList(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentList arg, ARG obj);
	RET visitArgumentString(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentString arg, ARG obj);
	RET visitArgumentTuple(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentTuple arg, ARG obj);
	RET visitArgumentBoolean(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentBoolean arg, ARG obj);
}