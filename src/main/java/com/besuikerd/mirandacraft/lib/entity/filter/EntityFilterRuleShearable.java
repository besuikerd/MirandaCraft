package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IShearable;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentBoolean;

public class EntityFilterRuleShearable extends EntityFilterRuleBoolean{

	private boolean inverted;
	
	public EntityFilterRuleShearable(boolean inverted) {
		this.inverted = inverted;
	}
	
	public EntityFilterRuleShearable() {
		this(false);
	}

	@Override
	public boolean validate(Entity entity, ClassifierArgumentBoolean argument) {
		return entity instanceof IShearable && ((IShearable) entity).isShearable(new ItemStack(Items.shears), entity.worldObj, entity.chunkCoordX, entity.chunkCoordY, entity.chunkCoordZ) ? inverted != argument.getValue() : inverted == argument.getValue();
	}
	
}
