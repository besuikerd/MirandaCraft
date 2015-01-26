package com.besuikerd.mirandacraft.client.gui.texture;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.util.Rectangle;

public class StatefulTextureBuilder {
	private ResourceLocation texture;
	private Rectangle active;
	private Rectangle normal;
	private Rectangle disabled;
	
	public StatefulTextureBuilder(ResourceLocation texture) {
		this.texture = texture;
	}

	public IStatefulTexture build(){
		return new StatefulTexture(texture, active, normal, disabled);
	}
	
	public StatefulTextureBuilder active(int x, int y, int width, int height){
		this.active = new Rectangle(x, y, width, height);
		return this;
	}
	
	public StatefulTextureBuilder normal(int x, int y, int width, int height){
		this.normal = new Rectangle(x, y, width, height);
		return this;
	}
	
	public StatefulTextureBuilder disabled(int x, int y, int width, int height){
		this.disabled = new Rectangle(x, y, width, height);
		return this;
	}
}
