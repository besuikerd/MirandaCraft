package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public enum Glyph implements ITexture{
	PLUS(0,0,6,6),
	MINUS(6,0,6,6),
	ARROW_UP(12,0,6,3),
	ARROW_DOWN(18,0,6,3),
	CHECKED(24, 0, 8, 8),
	UNCHECKED(32, 0, 8, 8)
	;
	
	
	private Rectangle rect;
	private Glyph(int x, int y, int width, int height){
		this.rect = new Rectangle(x, y, width, height);
	}
	
	@Override
	public ResourceLocation getTexture() {
		return TextureLocation.GLYPHS;
	}

	@Override
	public Rectangle getPosition() {
		return rect;
	}
}
