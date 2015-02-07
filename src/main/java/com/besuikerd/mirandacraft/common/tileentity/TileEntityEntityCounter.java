package com.besuikerd.mirandacraft.common.tileentity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityCounter;
import com.besuikerd.mirandacraft.client.gui.widget.IClickListener;
import com.besuikerd.mirandacraft.common.Config;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierParser;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierRule;
import com.besuikerd.mirandacraft.lib.classifier.ParseException;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterVisitor;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector2D;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector3;

public class TileEntityEntityCounter extends TileEntityEntityScanner implements IRedstoneProvider{
	protected int rangeLimit;
	
	protected int count;
	protected int countLimit;
	
	protected int entitiesCounted;
	
	private boolean isAnalog;
	
	public TileEntityEntityCounter() {
		super(TrackingPosition.FRONT, 3, Config.entityCounterMaxRange, 3, 0);
		
		this.count = 1;
		this.isAnalog = false;
		
		this.tickDelay = Config.entityCounterTickDelay;
		this.countLimit = Config.entityCounterMaxCount;
	}
	
	@Override
	public boolean onPostScan(List<Entity> entities) {
		super.onPostScan(entities);
		if(entitiesCounted != entities.size()){
			this.entitiesCounted = entities.size();
			return true;
		}
		return false;
	}

	public int getRangeLimit() {
		return rangeLimit;
	}
	
	public int getMaxCount() {
		return count;
	}
	
	public boolean isAnalog() {
		return isAnalog;
	}
	
	public int getEntitiesCounted() {
		return entitiesCounted;
	}

	@Override
	public int getRedstoneStrength() {
		return isAnalog ? Math.min((int) (((double) entitiesCounted / count) * 15), 15) : entitiesCounted >= count ? 15 : 0;
	}
	
	@Override
	public boolean hasFlippedPlacement() {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("count", count);
		tag.setBoolean("isAnalog", isAnalog);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.count = tag.getInteger("count");
		this.isAnalog = tag.getBoolean("isAnalog");
	}
	
	@Override
	public void onClick(String widgetId, MouseButton button, Object data) {
		super.onClick(widgetId, button, data);
		if(widgetId.equals(GuiEntityCounter.ACTION_COUNT_INC)){
			switch(button){
			case LEFT:
				count = Math.min(count + 1, countLimit);
				break;
			case MIDDLE:
				count = Math.min(count+ 10, countLimit);
				break;
			case RIGHT:
				count = Math.min(count + 50, countLimit);
				break;
			}
		} else if(widgetId.equals(GuiEntityCounter.ACTION_COUNT_DEC)){
			switch(button){
			case LEFT:
				count = Math.max(count - 1, 1);
				break;
			case MIDDLE:
				count = Math.max(count - 10, 1);
				break;
			case RIGHT:
				count = Math.max(count - 50, 1);
			}
		} else if(widgetId.equals(GuiEntityCounter.ACTION_IS_ANALOG)){
			isAnalog = !isAnalog;
			worldObj.notifyBlockChange(xCoord, yCoord, zCoord, blockType);
		}
	}
}
