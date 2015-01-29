package com.besuikerd.mirandacraft.lib.classifier;

public class ClassifierAndRule extends ClassifierRule implements ClassifierVisitable{

	private ClassifierRule lhs;
	private ClassifierRule rhs;
	
	public ClassifierAndRule(ClassifierRule lhs, ClassifierRule rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public <A, B> A visit(ClassifierVisitor<A, B> visitor, B obj) {
		return visitor.visitAndRule(visitor, this, obj);
	}

	public ClassifierRule getLhs() {
		return lhs;
	}
	
	public ClassifierRule getRhs() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return lhs.toString() + " && " + rhs.toString();
	}
}
