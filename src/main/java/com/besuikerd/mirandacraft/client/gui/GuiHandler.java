package com.besuikerd.mirandacraft.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityCounter;
import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityInteractor;
import com.besuikerd.mirandacraft.common.inventory.ContainerEntityCounter;
import com.besuikerd.mirandacraft.common.inventory.ContainerEntityInteractor;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityInteractor;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static enum GuiIdentifier {
		ENTITY_COUNTER,
		ENTITY_INTERACTOR,

		;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID < GuiIdentifier.values().length) {
			switch (GuiIdentifier.values()[ID]) {
			case ENTITY_COUNTER:
				return new ContainerEntityCounter((TileEntityEntityCounter) world.getTileEntity(x, y, z), player);
			case ENTITY_INTERACTOR:
				return new ContainerEntityInteractor((TileEntityEntityInteractor) world.getTileEntity(x, y, z), player); 
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID < GuiIdentifier.values().length) {
			TileEntity tile = world.getTileEntity(x, y, z);
			switch (GuiIdentifier.values()[ID]) {
			case ENTITY_COUNTER:
				return new GuiEntityCounter(new ContainerEntityCounter((TileEntityEntityCounter) tile, player), (TileEntityEntityCounter)tile, player);
			case ENTITY_INTERACTOR:
				return new GuiEntityInteractor(new ContainerEntityInteractor((TileEntityEntityInteractor) tile, player), (TileEntityEntityInteractor) tile, player);
			}
		}
		return null;
	}

}
