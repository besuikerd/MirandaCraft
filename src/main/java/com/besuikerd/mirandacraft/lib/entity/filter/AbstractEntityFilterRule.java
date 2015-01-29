package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;

public abstract class AbstractEntityFilterRule<A extends ClassifierArgument> implements EntityFilterRule<A>{

	private Class<A> cls;
	
	public AbstractEntityFilterRule(Class<A> cls) {
		this.cls = cls;
	}

	@Override
	public boolean isValidArgument(ClassifierArgument arg) {
		return cls.isInstance(arg);
	}
	
	@Override
	public A asValidArgument(ClassifierArgument arg) {
		return cls.cast(arg);
	}
	
	@Override
	public String getExpectedArgumentDescription() {
		return ClassifierArgument.ARGUMENT_TYPE_NAMES.get(cls);
	}
}
