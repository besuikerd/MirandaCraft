package com.besuikerd.mirandacraft.common.inventory;

import net.minecraft.entity.player.EntityPlayer;

import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;


public class ContainerEntityCounter extends ContainerBesu<TileEntityEntityCounter>{
	public ContainerEntityCounter(TileEntityEntityCounter tile, EntityPlayer player) {
		super(tile, player);
	}
}
