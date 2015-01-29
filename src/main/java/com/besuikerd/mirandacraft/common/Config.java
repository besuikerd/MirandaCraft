package com.besuikerd.mirandacraft.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static String[] validWrenches;
	
	public static int entityCounterMaxRange;
	public static int entityCounterMaxCount;
	
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
		
		config.save();
	}
}
