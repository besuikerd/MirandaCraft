package com.besuikerd.mirandacraft.common.tileentity;

public interface IRedstoneControlled {
	public enum RedstoneControlType{
		IGNORE_REDSTONE,
		LOW_SIGNAL,
		HIGH_SIGNAL
		;
	}
	
	public RedstoneControlType getRedstoneControlType();
	public boolean allowedToRun();
	public int getReceivedRedstoneStrength();
}
