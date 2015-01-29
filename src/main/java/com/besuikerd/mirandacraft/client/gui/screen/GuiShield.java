package com.besuikerd.mirandacraft.client.gui.screen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.besuikerd.mirandacraft.client.gui.GuiContainerBesu;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityShield;

public class GuiShield extends GuiContainerBesu<TileEntityShield>{

	public GuiShield(Container container, TileEntityShield tile, EntityPlayer player) {
		super(container, tile, player);
	}

}
