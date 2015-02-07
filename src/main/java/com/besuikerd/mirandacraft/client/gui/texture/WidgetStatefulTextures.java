package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;


public class WidgetStatefulTextures{
	private static final ResourceLocation TEX = TextureLocation.WIDGETS;
	
	public static final IStatefulTexture SCROLLER = new ConsecutiveStatefulTexture(TEX, 18, 0, 10, 15);
	public static final IStatefulTexture BUTTON = new ConsecutiveStatefulTexture(TEX, 48, 0, 12, 12);
	public static final IStatefulTexture BUTTON_SMALL = new ConsecutiveStatefulTexture(TEX, 48, 12, 12, 7);
	public static final IStatefulTexture BUTTON_ICON = new ConsecutiveStatefulTexture(TEX, 84, 0, 18, 18);
}
