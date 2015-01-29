package com.besuikerd.mirandacraft.common.tileentity;

import net.minecraft.util.AxisAlignedBB;

public class TileEntityShield extends TileEntityBesu{
	
	private int range;
	private int maxRange;
	
	private int tickDelay;
	private int currentTick;
	
	public TileEntityShield() {
		this.maxRange = 127;
		this.range = 63;
		this.tickDelay = 20;
	}
	
	@Override
	public void updateEntity() {
		if(currentTick++ == tickDelay){
			currentTick = 0;
			
			AxisAlignedBB box = calculateBoundingBoxCentered(range, 3, 0);
			
		}
	}
}
