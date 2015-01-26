package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public interface ITexture {
	public ResourceLocation getTexture();
	public Rectangle getPosition();
}