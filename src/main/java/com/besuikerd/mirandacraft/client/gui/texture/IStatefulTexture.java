package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public interface IStatefulTexture {
	public ResourceLocation getTexture();
	public Rectangle active();
	public Rectangle normal();
	public Rectangle disabled();
}
