package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;

public interface EntityFilterRule<A extends ClassifierArgument> {
	public boolean isValidArgument(ClassifierArgument arg);
	public A asValidArgument(ClassifierArgument arg);
	public String getExpectedArgumentDescription();
	public boolean validate(Entity entity, A argument);
}