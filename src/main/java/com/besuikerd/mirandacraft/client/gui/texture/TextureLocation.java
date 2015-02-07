package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

public class TextureLocation {
	public static final String ROOT = "mirandacraft:";
	public static final String TEXTURES = ROOT + "textures/";
	
	public static final String GUI = TEXTURES + "gui/";
	public static final String BLOCK = TEXTURES + "blocks/";
	
	public static final ResourceLocation GLYPHS = new ResourceLocation(GUI + "glyphs.png");
	public static final ResourceLocation WIDGETS = new ResourceLocation(GUI + "widgets.png");
	
	public static final ResourceLocation GUI_ENTITY_COUNTER = new ResourceLocation(GUI + "entity_counter.png");
	public static final ResourceLocation GUI_ENTITY_INTERACTOR = new ResourceLocation(GUI + "entity_interactor.png");
	
	
	
	public static String block(String name){
		return ROOT + name;
	}
}
