package com.besuikerd.mirandacraft.lib.classifier;

public abstract class AbstractClassifierVisitor<ARG, RET> implements ClassifierVisitor<ARG, RET>{
	
	@Override
	public RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return null;
	}
	
	@Override
	public RET visitAndRule(ClassifierVisitor<ARG, RET> visitor, ClassifierAndRule rule, ARG obj) {
		rule.getLhs().visit(visitor, obj);
		rule.getRhs().visit(visitor, obj);
		return null;
	}
	
	@Override
	public RET visitOrRule(ClassifierVisitor<ARG, RET> visitor, ClassifierOrRule rule, ARG obj) {
		rule.getLhs().visit(visitor, obj);
		rule.getRhs().visit(visitor, obj);
		return null;
	}

	@Override
	public RET visitActualRule(ClassifierVisitor<ARG, RET> visitor, ClassifierActualRule rule, ARG obj) {
		for(ClassifierArgument<?> arg : rule.getArguments().values()){
			arg.visit(visitor, obj);
		}
		return null;
	}
	
	@Override
	public RET visitArgumentDouble(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentDouble arg, ARG obj) {
		return null;
	}

	@Override
	public RET visitArgumentInt(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentInt arg, ARG obj) {
		return null;
	}

	@Override
	public RET visitArgumentList(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentList arg, ARG obj) {
		return null;
	}

	@Override
	public RET visitArgumentString(ClassifierVisitor<ARG, RET> visitor,	ClassifierArgumentString arg, ARG obj) {
		return null;
	}

	@Override
	public RET visitArgumentTuple(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentTuple arg, ARG obj) {
		return null;
	}

	@Override
	public RET visitArgumentBoolean(ClassifierVisitor<ARG, RET> visitor, ClassifierArgumentBoolean arg, ARG obj) {
		return null;
	}
}
