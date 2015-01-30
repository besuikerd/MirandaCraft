package com.besuikerd.mirandacraft.common.tileentity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

import com.besuikerd.mirandacraft.lib.utils.tuple.NBTUtils;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector3;

public abstract class TileEntityMachine extends TileEntityBesu implements IDirectioned, IDismantleable{

	protected int direction;
	
	@Override
	public void setDirection(int direction) {
		this.direction = direction;
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
	
	protected AxisAlignedBB calculateBoundingBoxInFront(double range, double height){
		double halfRange = (range - 1) / 2;
		switch(ForgeDirection.values()[getDirection()]){
		case NORTH:
			return calculateBoundingBoxAt(xCoord + .5, yCoord, zCoord - halfRange - .5, range, height);
		case EAST:
			return calculateBoundingBoxAt(xCoord + 1.5 + halfRange, yCoord, zCoord + .5, range, height);
		case SOUTH:
			return calculateBoundingBoxAt(xCoord + .5, yCoord, zCoord + 1.5 + halfRange, range, height);
		case WEST:
			return calculateBoundingBoxAt(xCoord - halfRange - .5, yCoord, zCoord + .5, range, height);
		default:
			return null;
		}
	}
	
	protected Vector3 calculateCoordinateInFront(){
		switch(ForgeDirection.values()[getDirection()]){
		case NORTH:
			return new Vector3(xCoord, yCoord, zCoord - 1);
		case EAST:
			return new Vector3(xCoord + 1, yCoord, zCoord);
		case SOUTH:
			return new Vector3(xCoord, yCoord, zCoord + 1);
		case WEST:
			return new Vector3(xCoord - 1, yCoord, zCoord);
		default:
			return null;
		}
	}
}
