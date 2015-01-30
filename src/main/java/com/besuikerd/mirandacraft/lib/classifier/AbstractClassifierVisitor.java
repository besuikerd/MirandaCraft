package com.besuikerd.mirandacraft.lib.classifier;

public abstract class AbstractClassifierVisitor<A, B> implements ClassifierVisitor<A, B>{
	
	@Override
	public A visitAndRule(ClassifierVisitor<A, B> visitor,
			ClassifierAndRule rule, B obj) {
		rule.getLhs().visit(visitor, obj);
		rule.getRhs().visit(visitor, obj);
		return null;
	}
	
	@Override
	public A visitOrRule(ClassifierVisitor<A, B> visitor,
			ClassifierOrRule rule, B obj) {
		rule.getLhs().visit(visitor, obj);
		rule.getRhs().visit(visitor, obj);
		return null;
	}

	@Override
	public A visitActualRule(ClassifierVisitor<A, B> visitor, ClassifierActualRule rule,
			B obj) {
		for(ClassifierArgument<?> arg : rule.getArguments().values()){
			arg.visit(visitor, obj);
		}
		return null;
	}
	
	@Override
	public A visitArgumentDouble(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentDouble arg, B obj) {
		return null;
	}

	@Override
	public A visitArgumentInt(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentInt arg, B obj) {
		return null;
	}

	@Override
	public A visitArgumentList(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentList arg, B obj) {
		return null;
	}

	@Override
	public A visitArgumentString(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentString arg, B obj) {
		return null;
	}

	@Override
	public A visitArgumentTuple(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentTuple arg, B obj) {
		return null;
	}

	@Override
	public A visitArgumentBoolean(ClassifierVisitor<A, B> visitor,
			ClassifierArgumentBoolean arg, B obj) {
		return null;
	}
}
