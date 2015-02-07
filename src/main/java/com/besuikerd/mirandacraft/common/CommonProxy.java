package com.besuikerd.mirandacraft.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.besuikerd.mirandacraft.common.block.MirandaBlocks;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityInteractor;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityShield;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerBlocks(){
		register(MirandaBlocks.entityCounter);
		register(MirandaBlocks.entityInteracter);
	}
	
	public void registerItems(){
		
	}
	
	public void registerTileEntities(){
		register(TileEntityEntityCounter.class);
		register(TileEntityEntityInteractor.class);
		//register(TileEntityShield.class);
	}
	
	public void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(MirandaBlocks.entityCounter), new Object[]{"geg", "rvr", "gdg", 'g', new ItemStack(Items.gold_ingot), 'e', new ItemStack(Items.ender_eye), 'r', new ItemStack(Blocks.redstone_block), 'v', new ItemStack(Blocks.emerald_block), 'd', new ItemStack(Items.diamond)});
	}
	
	public void registerRenderers(){
		
	}
	
	private void register(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	private void register(Class<? extends TileEntity> tile){
		GameRegistry.registerTileEntity(tile, tile.getSimpleName());
	}
	
	public EntityPlayer getPlayer(){
		throw new UnsupportedOperationException("Cannot get player object from the server side");
	}
}
