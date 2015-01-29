package com.besuikerd.mirandacraft.common.tileentity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

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

public class TileEntityEntityCounter extends TileEntityMachine implements IClickListener, IRedstoneProvider{
	
	private Map<String, ClassifierRule> entityRules;
	
	private ClassifierParser classifierParser  = new ClassifierParser();
	private EntityFilterVisitor entityFilterVisitor = new EntityFilterVisitor();
	private EntityFilterValidator entityFilterValidator = new EntityFilterValidator(entityFilterVisitor);
	
	private int range;
	private int maxCount;
	
	private int rangeLimit;
	private int countLimit;
	
	private int entitiesCounted;
	
	private int rangeHeight;
	private int tickDelay;
	private int currentTick = 0;
	
	private boolean isAnalog;
	
	public TileEntityEntityCounter() {
		this.entityRules = new LinkedHashMap<String,ClassifierRule>();
		this.range = 3;
		this.tickDelay = 20;
		this.rangeHeight = 3;
		this.maxCount = 1;
		this.rangeLimit = Config.entityCounterMaxRange;
		this.countLimit = Config.entityCounterMaxCount;
		this.isAnalog = false;
	}
	
	@Override
	public void updateEntity() {
		if(currentTick++ == tickDelay){
			currentTick = 0;
			int count = 0;
			AxisAlignedBB boundingBox = calculateBoundingBoxInFront(range, rangeHeight);
			
			if(boundingBox == null){
				return;
			}
			List<Entity> entities = (List<Entity>) worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);
			for(Entity entity : entities){
				boolean pass = entityRules.values().isEmpty();
				if(!pass){
					for(ClassifierRule rule : entityRules.values()){
						if(rule.visit(entityFilterVisitor, entity)){
							pass = true;
							break;
						}
					}
				}
				if(pass){
					count++;
				}
			}
			this.entitiesCounted = count;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			worldObj.notifyBlockChange(xCoord, yCoord, zCoord, getBlockType());
		}
	}
	
	
	public Map<String, ClassifierRule> getEntityRules() {
		return entityRules;
	}
	
	public void addEntityRule(String input){
		try{
			ClassifierRule rule = classifierParser.parse(input);
			if(rule.visit(entityFilterValidator, null) == null){
				entityRules.put(input, rule);
			}
		} catch(ParseException e){
		}
	}
	
	public void removeRule(int index){
		int count = 0;
		
		for(String key : entityRules.keySet()){
			if(count++ == index){
				entityRules.remove(key);
				break;
			}
			
		}
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
	
	public EntityFilterVisitor getEntityFilterVisitor() {
		return entityFilterVisitor;
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
		for(String rule : entityRules.keySet()){
			list.appendTag(new NBTTagString(rule));
		}
		tag.setTag("entityList", list);
		tag.setInteger("range", range);
		tag.setInteger("maxCount", maxCount);
		tag.setBoolean("isAnalog", isAnalog);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList list = tag.getTagList("entityList", Constants.NBT.TAG_STRING);
		this.entityRules.clear();
		for(int i = 0 ; i < list.tagCount() ; i++){
			addEntityRule(list.getStringTagAt(i));
		}
		this.range = tag.getInteger("range");
		this.maxCount = tag.getInteger("maxCount");
		this.isAnalog = tag.getBoolean("isAnalog");
	}
	
	@Override
	public void onClick(int widgetId, MouseButton button, Object data) {
		System.out.println(button);
		switch(GuiEntityCounter.Widgets.values()[widgetId]){
		case BUTTON_ADD:
			addEntityRule(data.toString());
			break;
		case BUTTON_REMOVE:
			int index = (Integer) data;
			if(index != -1){
				removeRule(index);
			}
			break;
		case BUTTON_INCREASE_RANGE:
			switch(button){
			case LEFT:
				range = Math.min(range + 2, rangeLimit);
				break;
			case MIDDLE:
				range = Math.min(range + 10, rangeLimit);
				break;
			case RIGHT:
				range = rangeLimit;
				break;
			}
			break;
		case BUTTON_DECREASE_RANGE:
			switch(button){
			case LEFT:
				range = Math.max(range - 2, 1);
				break;
			case MIDDLE:
				range = Math.max(range - 10, 1);
				break;
			case RIGHT:
				range = 1;
				break;
			}
			break;
		case BUTTON_INCREASE_COUNT:
			switch(button){
			case LEFT:
				maxCount = Math.min(maxCount + 1, countLimit);
				break;
			case MIDDLE:
				maxCount = Math.min(maxCount+ 10, countLimit);
				break;
			case RIGHT:
				maxCount = Math.min(maxCount + 50, countLimit);
				break;
			}
			break;
		case BUTTON_DECREASE_COUNT:
			switch(button){
			case LEFT:
				maxCount = Math.max(maxCount - 1, 1);
				break;
			case MIDDLE:
				maxCount = Math.max(maxCount - 10, 1);
				break;
			case RIGHT:
				maxCount = Math.max(maxCount - 50, 1);
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
