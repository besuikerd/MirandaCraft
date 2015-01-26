package com.besuikerd.mirandacraft.common.item;

import java.util.HashSet;
import java.util.Set;

import scala.actors.threadpool.Arrays;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wrenches {
	private static Set<String> wrenches;
	
	static{
		wrenches = new HashSet<String>(Arrays.asList(new String[]{
			"ToolCertusQuartzWrench",
			"wrenchItem",
			"wrench",
			"pneumaticWrench",
			"itemToolWrench",
			"itemToolWrenchElectric"
		}));
	}
	
	public void registerWrench(Item wrench){
		registerWrench(wrench.getUnlocalizedName().substring("item.".length()));
	}
	
	public void registerWrench(String name){
		wrenches.add(name);
	}
	
	public static boolean isWrench(ItemStack item){
		return item != null && wrenches.contains(item.getUnlocalizedName().substring("item.".length()));
	}
}
