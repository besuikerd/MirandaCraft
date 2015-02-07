package com.besuikerd.mirandacraft.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public abstract class ContainerBesu<A extends TileEntity> extends Container{

	protected A tile;
	protected EntityPlayer player;

	private int playerInventoryStart = -1;
	
	public ContainerBesu(A tile, EntityPlayer player) {
		this.tile = tile;
		this.player = player;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	public boolean hasPlayerInventory(){
		return playerInventoryStart != -1;
	}
	
	public int getPlayerInventoryStart() {
		return playerInventoryStart;
	}
	
	public int getPlayerInventorySize(){
		return player.inventory.mainInventory.length;
	}
	
	public boolean isPlayerSlot(int id){
		return id >= playerInventoryStart && id < playerInventoryStart + getPlayerInventorySize();
	}
	
	public boolean isHotbarSlot(int id){
		return id >= playerInventoryStart && id < playerInventoryStart + 9;
	}
	
	public boolean isPlayerMainInventorySlot(int id){
		return id >= playerInventoryStart + 9 && id < playerInventoryStart + getPlayerInventorySize();
	}
	
	protected boolean mergeHotbar(ItemStack stack){
		return hasPlayerInventory() && mergeItemStack(stack, playerInventoryStart, playerInventoryStart + 9, false);
	}
	
	protected boolean mergeMainPlayerInventory(ItemStack stack){
		return hasPlayerInventory() && mergeItemStack(stack, playerInventoryStart + 9, playerInventoryStart + getPlayerInventorySize(), false);
	}
	
	protected boolean mergePlayerInventory(ItemStack stack){
		return mergeHotbar(stack) || mergeMainPlayerInventory(stack);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack stack = null;
		Slot slot = getSlot(slotNumber);
		
		if((stack = slot.getStack()) != null){
			if(isPlayerSlot(slotNumber)){
				if(playerInventoryStart > 0 && mergeItemStack(stack, 0, playerInventoryStart, false) || playerInventoryStart + getPlayerInventorySize() < inventorySlots.size() && mergeItemStack(stack, playerInventoryStart + getPlayerInventorySize(), inventorySlots.size() - 1, false)){
				
				} else if(isHotbarSlot(slotNumber)){
					stack = mergeMainPlayerInventory(stack) ? stack : null;
				} else if(isPlayerMainInventorySlot(slotNumber)){
					stack = mergeHotbar(stack) ? stack : null;
				}
			} else{
				stack = mergePlayerInventory(stack) ? stack : null;
			}
			
			if(stack != null && stack.stackSize == 0){
				slot.putStack(null);
			} else{
				slot.onSlotChanged();
			}
		}
		return stack;
	}
	
	protected void addPlayerInventory(int xOffset, int yOffset){
		playerInventoryStart = inventorySlots.size();
		xOffset += 1;
		yOffset += 1;
		
		int hotBarOffset = 58;
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, xOffset + i * 18, yOffset + hotBarOffset));
        }
		
		for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, xOffset + j * 18, yOffset + i * 18));
            }
        }

		
	}
}