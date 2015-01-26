package com.besuikerd.mirandacraft.client.gui;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityCounter;
import com.besuikerd.mirandacraft.common.inventory.ContainerEntityCounter;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;
import com.besuikerd.mirandacraft.common.utils.tuple.Tuple2;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static enum GuiIdentifier {
		ENTITY_COUNTER

		;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID < GuiIdentifier.values().length) {
			switch (GuiIdentifier.values()[ID]) {
			case ENTITY_COUNTER:
				return new ContainerEntityCounter((TileEntityEntityCounter) world.getTileEntity(x, y, z), player);
				
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID < GuiIdentifier.values().length) {
			switch (GuiIdentifier.values()[ID]) {
			case ENTITY_COUNTER:
				TileEntity tile = world.getTileEntity(x, y, z);
				return new GuiEntityCounter(new ContainerEntityCounter((TileEntityEntityCounter) tile, player), (TileEntityEntityCounter)tile, player);
				
			}
		}
		return null;
	}

}
