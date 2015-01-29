package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentInt;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentTuple;

public class EntityFilterRulePosition extends EntityFilterRuleTuple{

	public EntityFilterRulePosition() {
		super(ClassifierArgumentInt.class, ClassifierArgumentInt.class, ClassifierArgumentInt.class);
	}
	
	@Override
	public boolean validate(Entity entity, ClassifierArgumentTuple argument) {
		return 
			argument.getValue()[0].getValue().equals(MathHelper.floor_double(entity.posX)) &&
			argument.getValue()[1].getValue().equals(MathHelper.floor_double(entity.posY)) &&
			argument.getValue()[2].getValue().equals(MathHelper.floor_double(entity.posZ)) ;
	}
	
}
