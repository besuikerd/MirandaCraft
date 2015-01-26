package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public class ConsecutiveStatefulTexture implements IStatefulTexture{

	private ResourceLocation texture;
	
	private Rectangle normal;
	private Rectangle active;
	private Rectangle disabled;
	
	public ConsecutiveStatefulTexture(ResourceLocation texture, int x, int y, int width, int height) {
		this.texture = texture;
		this.normal = new Rectangle(x, y, width, height);
		this.active = new Rectangle(x + width, y, width, height);
		this.disabled = new Rectangle(x + width * 2, y, width, height);
	}

	@Override
	public ResourceLocation getTexture() {
		return texture;
	}

	@Override
	public Rectangle active() {
		return active;
	}

	@Override
	public Rectangle normal() {
		return normal;
	}

	@Override
	public Rectangle disabled() {
		return disabled;
	}

}
