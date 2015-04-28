package com.besuikerd.mirandacraft.common.tileentity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityCounter;
import com.besuikerd.mirandacraft.client.gui.widget.IClickListener;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierParser;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ParseException;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterVisitor;

public abstract class TileEntityEntityScanner extends TileEntityMachine implements IClickListener{
	private ClassifierParser classifierParser;
	protected ClassifierVisitor<Entity, Boolean> filterVisitor;
	protected ClassifierVisitor<Void, String> validitionVisitor;
	
	private EntityFilterVisitor entityFilterVisitor;
	
	private Map<String, ClassifierRule> entityRules;
	
	protected int tickDelay;
	private int currentTick;
	
	protected int range;
	protected int rangeLimit;
	protected int rangeHeightOffset;
	protected int rangeHeight;
	
	private List<Entity> entityList;
	
	
	protected TrackingPosition trackingPosition;
	
	public TileEntityEntityScanner(TrackingPosition trackingPosition, int range, int rangeLimit, int rangeHeight, int rangeHeightOffset) {
		this.trackingPosition = trackingPosition;
		this.range = range;
		this.rangeLimit = rangeLimit;
		this.rangeHeight = rangeHeight;
		this.rangeHeightOffset = rangeHeightOffset;
		
		this.tickDelay = 10;
		this.currentTick = 0;
		
		this.classifierParser = new ClassifierParser();
		this.entityFilterVisitor = new EntityFilterVisitor();
		this.filterVisitor = entityFilterVisitor;
		this.validitionVisitor = new EntityFilterValidator(entityFilterVisitor);
		this.entityRules = new LinkedHashMap<String, ClassifierRule>();
		this.entityList = new ArrayList<Entity>();
	}
	
	public boolean onEntityFound(Entity entity){return false;};
	public boolean onPreScan(List<Entity> oldList){return false;};
	public boolean onPostScan(List<Entity> entityList){return false;};
	
	@Override
	public void onTick() {
		super.onTick();
		boolean changed = false;
		if(currentTick++ == tickDelay){
			changed = onPreScan(entityList) || changed;
			entityList.clear();
			currentTick = 0;
			int count = 0;
			AxisAlignedBB boundingBox;
			switch(trackingPosition){
			case FRONT:
				boundingBox = calculateBoundingBoxInFront(range, rangeHeight, rangeHeightOffset);
				break;
			case CENTERED:
				boundingBox = calculateBoundingBoxCentered(range, rangeHeight, rangeHeightOffset);
				break;
			default:
				boundingBox = null;
				break;
			}
			
			if(boundingBox == null){
				return;
			}
			
			List<Entity> entities = (List<Entity>) worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);
			for(Entity entity : entities){
				
				if(filterVisitor.visit(filterVisitor, entity)){
					boolean pass = entityRules.isEmpty();
					for(ClassifierRule rule : entityRules.values()){
						if(rule.visit(filterVisitor, entity)){
							pass = true;
							break;
						}
					}
					/*
					toying around with entity attractor
					
					Vector3 v1 = calculateCoordinateInFront();
					Vector2D front = new Vector2D(v1.x + .5, v1.z + .5);
					
					double speed = 0.05;
					
					Vector2D flattened = front.flatten(new Vector2D(entity.posX, entity.posZ));
					if(front.distance(new Vector2D(entity.posX, entity.posZ)) > 3){
						entity.setVelocity(flattened.x * speed, 0, flattened.y * speed);
					}
					*/
					if(pass){
						entityList.add(entity);
						changed = onEntityFound(entity) || changed;
					}
					
				}
			}
			changed = onPostScan(entityList) || changed;
			if(changed){
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				worldObj.notifyBlockChange(xCoord, yCoord, zCoord, getBlockType());
			}
			
		}
	}
	
	public boolean addEntityRule(String input){
		try{
			ClassifierRule rule = classifierParser.parse(input);
			if(rule.visit(validitionVisitor, null) == null){
				entityRules.put(input, rule);
			}
			return true;
		} catch(ParseException e){
			return false;
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
	
	@Override
	public void onClick(String widgetId, MouseButton button, Object data) {
		if(widgetId.equals(GuiEntityCounter.ACTION_ADD)){
			addEntityRule(data.toString());
		} else if(widgetId.equals(GuiEntityCounter.ACTION_REMOVE)){
			int index = (Integer) data;
			
			if(index >= 0 && index < entityRules.size()){
				removeRule(index);
			}			
		} else if(widgetId.equals(GuiEntityCounter.ACTION_INCREASE_RANGE)){
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
		} else if(widgetId.equals(GuiEntityCounter.ACTION_DECREASE_RANGE)){
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
		}
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
	}
	
	public Set<String> getRulesAsString(){
		return entityRules.keySet();
	}
	
	public Map<String, ClassifierRule> getRules(){
		return entityRules;
	}
	
	public int getRange() {
		return range;
	}
	
	public int getRangeHeight() {
		return rangeHeight;
	}
	
	public int getRangeHeightOffset() {
		return rangeHeightOffset;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public void setRangeHeight(int rangeHeight) {
		this.rangeHeight = rangeHeight;
	}
	
	public void setRangeHeightOffset(int rangeHeightOffset) {
		this.rangeHeightOffset = rangeHeightOffset;
	}
	
	public ClassifierVisitor<Void, String> getValidationVisitor() {
		return validitionVisitor;
	}
	
	public enum TrackingPosition{
		FRONT, CENTERED;
	}
}
