package com.besuikerd.mirandacraft.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityInteractor;

public class ContainerEntityInteractor extends ContainerBesu<TileEntityEntityInteractor>{

	public ContainerEntityInteractor(TileEntityEntityInteractor tile,
			EntityPlayer player) {
		super(tile, player);
		addSlotToContainer(new Slot(tile, 0, 80, 23));
		addPlayerInventory(7, 139);
	}
}
