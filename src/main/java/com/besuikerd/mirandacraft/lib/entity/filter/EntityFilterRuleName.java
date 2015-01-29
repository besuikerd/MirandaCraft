package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentString;

public class EntityFilterRuleName extends AbstractEntityFilterRule<ClassifierArgumentString>{

	public EntityFilterRuleName() {
		super(ClassifierArgumentString.class);
	}

	@Override
	public boolean validate(Entity entity, ClassifierArgumentString argument) {
		return entity.getCommandSenderName().matches(argument.getValue());
	}
}
