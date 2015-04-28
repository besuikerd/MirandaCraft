package com.besuikerd.mirandacraft.common.tileentity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.screen.GuiEntityInteractor;
import com.besuikerd.mirandacraft.common.Config;
import com.besuikerd.mirandacraft.common.inventory.InventoryHelper;
import com.besuikerd.mirandacraft.common.player.EntityPlayerTile;
import com.besuikerd.mirandacraft.common.player.IHasPlayer;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterVisitor;
import com.besuikerd.mirandacraft.lib.item.ItemUtils;

public class TileEntityEntityInteractor extends TileEntityEntityScanner implements IHasPlayer, IInventory{
	private EntityPlayerTile<TileEntityEntityInteractor> player;
	
	private boolean isSneaking;
	private boolean usesLeftMouseButton;
	
	public TileEntityEntityInteractor() {
		super(TrackingPosition.FRONT, 3, Config.entityInteractorMaxRange, 3, 0);
		
		//this.player = new EntityPlayerTile<TileEntityEntityInteractor>(this);
		this.tickDelay = Config.entityInteractorTickDelay;
		
		this.isSneaking = false;
		this.usesLeftMouseButton = false;
		
		initializeFilter();
	}
	
	private void initializeFilter(){
		EntityFilterVisitor visitor = new EntityFilterVisitor();
		Set<String> blackList = new HashSet<String>();
		for(Map.Entry<String, Class<?>> entry : visitor.getTypes().entrySet()){
			if(!EntityLivingBase.class.isAssignableFrom(entry.getValue())){
				blackList.add(entry.getKey());
			}
		}
		for(String key : blackList){
			visitor.getTypes().remove(key);
		}
		
		this.filterVisitor = visitor;
		this.validitionVisitor= new EntityFilterValidator(visitor); 
	}
	
	
	private static int nameCounter = 1;
	@Override
	protected void initialize() {
		super.initialize();
		this.player = new EntityPlayerTile<TileEntityEntityInteractor>(this, String.format("[EntityInteractor #%d] ", nameCounter++));
	}
	
	@Override
	public EntityPlayer getPlayer() {
		return player;
	}
	
	@Override
	public boolean onPostScan(List<Entity> entityList) {
		//System.out.println(String.format("found %d entities", entityList.size()));
		
		
		if(!worldObj.isRemote && !entityList.isEmpty()){
			EntityLivingBase entity = (EntityLivingBase) entityList.get(worldObj.rand.nextInt(entityList.size()));
			player.inventory.currentItem = 0;
			player.inventory.setInventorySlotContents(0, inventory[0]);
			player.setSneaking(isSneaking);
			
			if(player.getCurrentEquippedItem() != null){
				player.getAttributeMap().applyAttributeModifiers(player.getCurrentEquippedItem().getAttributeModifiers());
			}
			
			if(usesLeftMouseButton){
				try{
					player.attackTargetEntityWithCurrentItem(entity);
				} catch(RuntimeException e){
					
				}
			} else{
				try{
					player.interactWith(entity);
				} catch(RuntimeException e){ //In case for some reason an item expects a EntityPlayerMP instead of EntityPlayer (Precision Shears)
					
				}
				
				/*
				if(entity instanceof EntityAnimal){
					((EntityAnimal) entity).interact(player);
				}
				
				
				if(player.getCurrentEquippedItem() != null){
					//player.getCurrentEquippedItem().getItem().itemInteractionForEntity(player.getCurrentEquippedItem(), player, entity);
					//player.getCurrentEquippedItem().useItemRightClick(worldObj, player);
				}
				*/
			}
			//System.out.println("selected: " + selected.getCommandSenderName());
		}
		return !entityList.isEmpty();
	}
	
	@Override
	public void onClick(String widgetId, MouseButton button, Object data) {
		super.onClick(widgetId, button, data);
		if(widgetId.equals(GuiEntityInteractor.ACTION_REDSTONE_STATE)){
			this.redstoneControlType = RedstoneControlType.values()[(Integer) data];
		} else if(widgetId.equals(GuiEntityInteractor.ACTION_TOGGLE_MOUSE)){
			this.usesLeftMouseButton = !this.usesLeftMouseButton;
		} else if(widgetId.equals(GuiEntityInteractor.ACTION_TOGGLE_SNEAKING)){
			this.isSneaking = !this.isSneaking;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setBoolean("isSneaking", isSneaking);
		tag.setBoolean("leftMouse", usesLeftMouseButton);
		tag.setTag("inventory", ItemUtils.toNBT(this));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.isSneaking = tag.getBoolean("isSneaking");
		this.usesLeftMouseButton = tag.getBoolean("leftMouse");
		ItemUtils.readFromNBT(this, tag.getTagList("inventory", Constants.NBT.TAG_COMPOUND));
	}
	
	public boolean isSneaking(){
		return isSneaking;
	}
	
	public boolean usesLeftMouseButton(){
		return usesLeftMouseButton;
	}
	
	private ItemStack[] inventory = new ItemStack[1];
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int n) {
		ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= n) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(n);
                if (stack.stackSize == 0) {
                        setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return inventory[i];
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {
		inventory[i] = stack;
	}

	@Override
	public String getInventoryName() {
		return "inventory." + getClass().getSimpleName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean hasFlippedPlacement() {
		return true;
	}
	
	@Override
	public void onTileEntityRemoved(Block block, int meta) {
		super.onTileEntityRemoved(block, meta);
		InventoryHelper.dropInventoryContents(worldObj, random, xCoord, yCoord, zCoord, this);
	}
}
