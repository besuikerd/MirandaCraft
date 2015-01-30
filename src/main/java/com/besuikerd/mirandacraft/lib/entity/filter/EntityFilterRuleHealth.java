package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentNumber;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentTuple;

public class EntityFilterRuleHealth extends EntityFilterRuleTuple{
	public EntityFilterRuleHealth() {
		super(ClassifierArgumentNumber.class, ClassifierArgumentNumber.class);
	}
	
	@Override
	public boolean validate(Entity entity, ClassifierArgumentTuple argument) {
		if(entity instanceof EntityLivingBase){
			EntityLivingBase living = (EntityLivingBase) entity;
			return living.getHealth() >= argument.getDoubleValue(0) && living.getHealth() <= argument.getDoubleValue(1);
		}
		return false;
	}
}
