package com.besuikerd.mirandacraft;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import com.besuikerd.mirandacraft.client.gui.GuiHandler;
import com.besuikerd.mirandacraft.common.CommonProxy;
import com.besuikerd.mirandacraft.common.Config;
import com.besuikerd.mirandacraft.common.network.NetworkHandler;
import com.besuikerd.mirandacraft.mineio.parser.MineIOLexer;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser;
import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.ProgramContext;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid=Constant.MOD_ID, name="MirandaCraft", version="0.0.00")
public class MirandaCraft {
	@Instance(value = Constant.MOD_ID)
	public static MirandaCraft instance;
	
	@SidedProxy(serverSide="com.besuikerd.mirandacraft.common.CommonProxy", clientSide="com.besuikerd.mirandacraft.client.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		Config.init(e.getSuggestedConfigurationFile());
		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerTileEntities();
		proxy.registerRecipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		NetworkHandler.getInstance().init();
		
		
		try{
			MineIOLexer lexer = new MineIOLexer(new ANTLRInputStream("int x = 5"));
			MineIOParser parser = new MineIOParser(new CommonTokenStream(lexer));
			ProgramContext program = parser.program();
		} catch(RecognitionException ex){
			ex.printStackTrace();
		}
	}
}
