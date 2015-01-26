package com.besuikerd.mirandacraft.common.tileentity;

import sun.rmi.runtime.NewThreadAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.besuikerd.mirandacraft.common.block.BlockBesu;
import com.besuikerd.mirandacraft.common.utils.tuple.NBTUtils;

public abstract class TileEntityMachine extends TileEntityBesu implements IDirectioned, IDismantleable{

	protected int direction;
	
	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		System.out.println("direction set: " + direction);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public int getDirection() {
		return this.direction;
	}

	@Override
	public boolean usesYAxis() {
		return false;
	}

	@Override
	public boolean isWrenchable() {
		return true;
	}
	
	@Override
	public boolean hasFlippedPlacement() {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("direction", direction);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.direction = tag.getInteger("direction");
	}
	
	@Override
	public void onTileEntityPlacedBy(EntityLivingBase entity, ItemStack stack) {
		super.onTileEntityPlacedBy(entity, stack);
//		NBTTagCompound tag = new NBTTagCompound();
//		writeToNBT(tag);
		if(stack.getTagCompound() != null){
			NBTTagCompound tag = new NBTTagCompound();
			writeToNBT(tag);
			NBTTagCompound nbtItem = stack.getTagCompound();
			for(String key : NBTUtils.keyset(nbtItem)){
				tag.setTag(key, nbtItem.getTag(key));
			}
			
			readFromNBT(tag);
			
			System.out.println(tag);
		}
	}

	@Override
	public NBTTagCompound getDismantledNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		tag.removeTag("direction");
		tag.removeTag("x");
		tag.removeTag("y");
		tag.removeTag("z");
		tag.removeTag("id");
		return tag;
	}
}
