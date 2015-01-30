package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentString;

public class EntityFilterRuleName extends AbstractEntityFilterRule<ClassifierArgumentString>{

	public EntityFilterRuleName() {
		super(ClassifierArgumentString.class);
	}

	@Override
	public boolean validate(Entity entity, ClassifierArgumentString argument) {
		if(entity instanceof EntityItem){
			return match(((EntityItem) entity).getEntityItem().getDisplayName(), argument.getValue());
		}
		
		return match(entity.getCommandSenderName(), argument.getValue());
	}
	
	private boolean match(String name, String match){
		System.out.println(name);
		
		return name.matches(match) || name.toLowerCase().equals(match.toLowerCase());
	}
}
