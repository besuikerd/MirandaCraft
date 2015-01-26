package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public enum WidgetTextures implements ITexture{
	INVENTORY_SLOT(0, 0, 18, 18)
	;
	
	private Rectangle rect;
	private WidgetTextures(int x, int y, int width, int height) {
		this.rect = new Rectangle(x, y, width, height);
	}

	@Override
	public ResourceLocation getTexture() {
		return TextureLocation.WIDGETS;
	}

	@Override
	public Rectangle getPosition() {
		return rect;
	}
	
}
