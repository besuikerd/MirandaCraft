package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierOrRule extends ClassifierRule implements ClassifierVisitable{

	private ClassifierRule lhs;
	private ClassifierRule rhs;
	
	public ClassifierOrRule(ClassifierRule lhs, ClassifierRule rhs) {
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitOrRule(visitor, this, obj);
	}
	
	public ClassifierRule getLhs() {
		return lhs;
	}
	
	public ClassifierRule getRhs() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return lhs.toString() + " || " + rhs.toString();
	}
}
