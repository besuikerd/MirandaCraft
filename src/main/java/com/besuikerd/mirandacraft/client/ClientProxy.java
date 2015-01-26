package com.besuikerd.mirandacraft.client;

import net.minecraft.entity.player.EntityPlayer;

import com.besuikerd.mirandacraft.common.CommonProxy;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenderers() {
		
	}
	
	@Override
	public EntityPlayer getPlayer() {
		return FMLClientHandler.instance().getClient().thePlayer;
	}
}
