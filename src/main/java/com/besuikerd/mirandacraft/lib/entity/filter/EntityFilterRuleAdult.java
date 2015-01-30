package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentBoolean;

public class EntityFilterRuleAdult extends EntityFilterRuleBoolean{
	@Override
	public boolean validate(Entity entity, ClassifierArgumentBoolean argument) {
		
		System.out.println(entity instanceof EntityAgeable && !((EntityAgeable) entity).isChild());
		
		return entity instanceof EntityAgeable && !((EntityAgeable) entity).isChild() == argument.getValue();
	}
}