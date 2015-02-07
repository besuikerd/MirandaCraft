package com.besuikerd.mirandacraft.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static String[] validWrenches;
	
	public static int entityCounterMaxRange;
	public static int entityCounterMaxCount;
	public static int entityCounterTickDelay;
	
	public static int entityInteractorTickDelay;
	public static int entityInteractorMaxRange;
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		config.load();
		
		validWrenches = config.get("machine", "Wrench names", new String[]{
				"appliedenergistics2.ToolCertusQuartzWrench",
				"wrenchItem",
				"wrench",
				"pneumaticWrench",
				"itemToolWrench",
				"itemToolWrenchElectric",
				"thermalexpansion.tool.wrench",
				"for.wrench"
		}, "Valid wrench items").getStringList();
		
		
		
		entityCounterMaxRange = config.getInt("Maximum Range", "machine.EntityCounter", 63, 0, Integer.MAX_VALUE, "");
		entityCounterMaxCount = config.getInt("Maximum Count", "machine.EntityCounter", 500, 0, Integer.MAX_VALUE, "");
		entityCounterTickDelay = config.getInt("Tick Delay", "machine.EntityCounter", 10, 1, Integer.MAX_VALUE, "");
		
		entityInteractorMaxRange = config.getInt("Maximum Range", "machine.EntityInteractor", 9, 1, Integer.MAX_VALUE, "");
		entityInteractorTickDelay = config.getInt("Tick Delay", "machine.EntityInteractor", 20, 1, Integer.MAX_VALUE, "");
		
		
		config.save();
	}
}
