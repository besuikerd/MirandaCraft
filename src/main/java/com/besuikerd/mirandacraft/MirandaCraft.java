package com.besuikerd.mirandacraft;

import com.besuikerd.mirandacraft.client.gui.GuiHandler;
import com.besuikerd.mirandacraft.common.CommonProxy;
import com.besuikerd.mirandacraft.common.network.NetworkHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid=Constant.MOD_ID, name="MirandaCraft", version="0.0.00")
public class MirandaCraft {
	@Instance(value = Constant.MOD_ID)
	public static MirandaCraft instance;
	
	@SidedProxy(serverSide="com.besuikerd.mirandacraft.common.CommonProxy", clientSide="com.besuikerd.mirandacraft.client.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerTileEntities();
		proxy.registerRecipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		NetworkHandler.getInstance().init();
	}
}
