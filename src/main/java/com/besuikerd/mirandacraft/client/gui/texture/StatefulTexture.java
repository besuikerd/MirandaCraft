package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public class StatefulTexture implements IStatefulTexture{

	private ResourceLocation texture;
	private Rectangle active;
	private Rectangle normal;
	private Rectangle disabled;
	
	public StatefulTexture(ResourceLocation texture, Rectangle active, Rectangle normal,
			Rectangle disabled) {
		this.texture = texture;
		this.active = active;
		this.normal = normal;
		this.disabled = disabled;
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

	@Override
	public ResourceLocation getTexture() {
		return texture;
	}
}
