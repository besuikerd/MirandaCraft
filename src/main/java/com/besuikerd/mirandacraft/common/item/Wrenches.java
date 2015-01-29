package com.besuikerd.mirandacraft.common.item;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.besuikerd.mirandacraft.common.Config;
import com.google.common.collect.Sets;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wrenches {
	private static Set<String> wrenches;
	
	static{
		wrenches = Sets.newHashSet(Config.validWrenches);
	}
	
	public void registerWrench(Item wrench){
		registerWrench(wrench.getUnlocalizedName().substring("item.".length()));
	}
	
	public void registerWrench(String name){
		wrenches.add(name);
	}
	
	public static boolean isWrench(ItemStack item){
		if(item != null){
			System.out.println(item.getUnlocalizedName());
		}
		return item != null && wrenches.contains(item.getUnlocalizedName().substring("item.".length()));
	}
}
