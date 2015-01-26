package com.besuikerd.mirandacraft.common.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityCounter;
import com.besuikerd.mirandacraft.client.gui.widget.IClickListener;
import com.besuikerd.mirandacraft.common.utils.tuple.Vector2;
import com.besuikerd.mirandacraft.common.utils.tuple.Vector3;

public class TileEntityEntityCounter extends TileEntityMachine implements IClickListener, IRedstoneProvider{
	private List<String> entityNames;
	private int range;
	private int maxCount;
	
	private int rangeLimit;
	private int countLimit;
	
	private int entitiesCounted;
	
	private int rangeHeight = 3;
	private int tickDelay = 20;
	private int currentTick = 0;
	
	private boolean isAnalog;
	
	public TileEntityEntityCounter() {
		this.entityNames = new ArrayList<String>();
		this.range = 3;
		this.maxCount = 10;
		this.rangeLimit = 5;
		this.countLimit = 100;
		this.isAnalog = true;
	}
	
	@Override
	public void updateEntity() {
		if(currentTick++ == tickDelay){
			currentTick = 0;
			int count = 0;
			System.out.println("world: " + worldObj);
			AxisAlignedBB boundingBox = calculateBoundingBox();
			if(boundingBox == null){
				return;
			}
			List<Entity> entities = (List<Entity>) worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);
			for(Entity entity : entities){
				if(entity instanceof EntityLiving){
					EntityLiving entityLiving = (EntityLiving) entity;
					if(entityLiving.hasCustomNameTag() && validEntityName(entityLiving.getCustomNameTag())){
						count++;
					} else {
						String name = EntityList.getEntityString(entityLiving);
						if(validEntityName(name)){
							count++;
						}
					}
				} else if(entity instanceof EntityItem){
					EntityItem entityItem = (EntityItem) entity;
					ItemStack i = entityItem.getEntityItem();
				} else if(entity instanceof EntityXPOrb && validEntityName("xp")){
					count++;
				}
				
			}
			//System.out.println(String.format("Entity count: (%d/%d)", count ,entities.size()));
			this.entitiesCounted = count;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			worldObj.notifyBlockChange(xCoord, yCoord, zCoord, getBlockType());
		}
	}
	
	private boolean validEntityName(String entityName){
		for(String name : entityNames){
			if(entityName.toLowerCase().equals(name.toLowerCase()) || entityName.toLowerCase().matches(name)){
				return true;
			}
		}
		return false;
	}
	
	private AxisAlignedBB calculateBoundingBox(){
		Vector2 startingPoint = null;
		int halfRange = (range - 1) / 2;
		switch(ForgeDirection.values()[getDirection()]){
		case NORTH:
			startingPoint = new Vector2(xCoord - halfRange, zCoord - range);
			break;
		case EAST:
			startingPoint = new Vector2(xCoord + 1, zCoord - halfRange);
			break;
		case SOUTH:
			startingPoint = new Vector2(xCoord - halfRange, zCoord + 1);
			break;
		case WEST:
			startingPoint = new Vector2(xCoord - range, zCoord - halfRange);
			break;
		default:
			return null;
		}
		return AxisAlignedBB.getBoundingBox(startingPoint._1, yCoord - rangeHeight, startingPoint._2, startingPoint._1 + range, yCoord + rangeHeight, startingPoint._2 + range);
	}
	

	public List<String> getEntityNames() {
		return entityNames;
	}
	
	public void addEntityName(String name){
		entityNames.add(name);
	}
	
	public void removeName(int index){
		entityNames.remove(index);
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getRange() {
		return range;
	}
	
	public int getRangeLimit() {
		return rangeLimit;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public boolean isAnalog() {
		return isAnalog;
	}

	@Override
	public int getRedstoneStrength() {
		return isAnalog ? Math.min((int) (((double) entitiesCounted / maxCount) * 15), 15) : entitiesCounted >= maxCount ? 15 : 0;
	}
	
	@Override
	public boolean hasFlippedPlacement() {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList list = new NBTTagList();
		for(int i = 0 ; i < entityNames.size() ; i++){
			list.appendTag(new NBTTagString(entityNames.get(i)));
		}
		tag.setTag("entityList", list);
		tag.setInteger("range", range);
		tag.setInteger("maxCount", maxCount);
		tag.setBoolean("isAnalog", isAnalog);
		//System.out.println("wrote: " + tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.entityNames = new ArrayList<String>();
		NBTTagList list = tag.getTagList("entityList", Constants.NBT.TAG_STRING);
		for(int i = 0 ; i < list.tagCount() ; i++){
			entityNames.add(list.getStringTagAt(i));
		}
		this.range = tag.getInteger("range");
		this.maxCount = tag.getInteger("maxCount");
		this.isAnalog = tag.getBoolean("isAnalog");
	}
	
	@Override
	public void onClick(int widgetId, Object data) {
		System.out.println(String.format("onClick[id=%d, data=%s]", widgetId, data));
		switch(GuiEntityCounter.Widgets.values()[widgetId]){
		case BUTTON_ADD:
			entityNames.add(data.toString());
			break;
		case BUTTON_REMOVE:
			int index = (Integer) data;
			if(index != -1){
				entityNames.remove(index);
			}
			break;
		case BUTTON_INCREASE_RANGE:
			if(range + 2 <= rangeLimit){
				range += 2;
			}
			break;
		case BUTTON_DECREASE_RANGE:
			if(range >= 3){
				range -= 2;
			}
			break;
		case BUTTON_INCREASE_COUNT:
			if(maxCount < countLimit){
				maxCount++;
			}
			break;
		case BUTTON_DECREASE_COUNT:
			if(maxCount > 1){
				maxCount--;
			}
			break;
		case CHECKBOX_IS_ANALOG:
			isAnalog = !isAnalog;
			worldObj.notifyBlockChange(xCoord, yCoord, zCoord, blockType);
			break;
		default:
			break;
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
}
