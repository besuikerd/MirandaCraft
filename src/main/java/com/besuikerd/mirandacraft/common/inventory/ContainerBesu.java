package com.besuikerd.mirandacraft.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public abstract class ContainerBesu<A extends TileEntity> extends Container{

	protected A tile;
	protected EntityPlayer player;
	
	public ContainerBesu(A tile, EntityPlayer player) {
		this.tile = tile;
		this.player = player;
	}



	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}