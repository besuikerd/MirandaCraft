package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentBoolean;

public class EntityFilterRuleBreedable extends EntityFilterRuleBoolean{
	@Override
	public boolean validate(Entity entity, ClassifierArgumentBoolean argument) {
		if(entity instanceof EntityAnimal){
			EntityAnimal animal = (EntityAnimal) entity;
			return !animal.isChild() && animal.getGrowingAge() == 0;
		}
		return false;
	}
}
