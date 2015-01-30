package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentBoolean;

public class EntityFilterLove extends EntityFilterRuleBoolean{
	@Override
	public boolean validate(Entity entity, ClassifierArgumentBoolean argument) {
		return entity instanceof EntityAnimal && ((EntityAnimal) entity).isInLove() == argument.getValue();
	}
}
