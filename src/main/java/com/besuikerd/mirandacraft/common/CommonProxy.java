package com.besuikerd.mirandacraft.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.besuikerd.mirandacraft.common.block.Blocks;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerBlocks(){
		register(Blocks.entityCounter);
	}
	
	public void registerItems(){
		
	}
	
	public void registerTileEntities(){
		register(TileEntityEntityCounter.class);
	}
	
	public void registerRecipes(){
		
	}
	
	public void registerRenderers(){
		
	}
	
	private void register(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	private void register(Class<? extends TileEntity> tile){
		System.out.println("registered: " + tile.getSimpleName());
		GameRegistry.registerTileEntity(tile, tile.getSimpleName());
	}
	
	public EntityPlayer getPlayer(){
		throw new UnsupportedOperationException("Cannot get player object from the server side");
	}
}
