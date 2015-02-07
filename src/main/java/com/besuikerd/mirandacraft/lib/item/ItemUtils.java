package com.besuikerd.mirandacraft.lib.item;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemUtils {
	public static NBTTagList toNBT(IInventory inventory){
		NBTTagList list = new NBTTagList();
		for(int i = 0 ; i < inventory.getSizeInventory() ; i++){
			ItemStack item = inventory.getStackInSlot(i);
			if(item != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("_slot", (byte)i);
				item.writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		return list;
	}
	
	public static void readFromNBT(IInventory inventory, NBTTagList list){
		for(int i = 0 ; i < list.tagCount() ; i++){
			NBTTagCompound tag = list.getCompoundTagAt(i);
			ItemStack stack = ItemStack.loadItemStackFromNBT(tag);
			inventory.setInventorySlotContents(tag.getByte("_slot"), stack);
		}
	}
}
