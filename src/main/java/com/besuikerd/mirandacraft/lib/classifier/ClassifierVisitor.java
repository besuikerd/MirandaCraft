package com.besuikerd.mirandacraft.lib.classifier;

public interface ClassifierVisitor<A, B> {
	A visitActualRule(ClassifierVisitor<A, B> visitor, ClassifierActualRule rule, B obj);
	A visitAndRule(ClassifierVisitor<A,B> visitor, ClassifierAndRule rule, B obj);
	A visitOrRule(ClassifierVisitor<A,B> visitor, ClassifierOrRule rule, B obj);
	A visitArgumentDouble(ClassifierVisitor<A, B> visitor, ClassifierArgumentDouble arg, B obj);
	A visitArgumentInt(ClassifierVisitor<A, B> visitor, ClassifierArgumentInt arg, B obj);
	A visitArgumentList(ClassifierVisitor<A, B> visitor, ClassifierArgumentList arg, B obj);
	A visitArgumentString(ClassifierVisitor<A, B> visitor, ClassifierArgumentString arg, B obj);
	A visitArgumentTuple(ClassifierVisitor<A, B> visitor, ClassifierArgumentTuple arg, B obj);
	A visitArgumentBoolean(ClassifierVisitor<A, B> visitor, ClassifierArgumentBoolean arg, B obj);
	// A visit(ClassifierVisitor<A, B> visitor, , B obj);
}
