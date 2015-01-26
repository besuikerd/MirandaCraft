package com.besuikerd.mirandacraft.common.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

public interface IDirectioned {
	public void setDirection(int direction);
	public int getDirection();
	public boolean usesYAxis();
	public boolean isWrenchable();
	public boolean hasFlippedPlacement();
}
