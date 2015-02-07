package com.besuikerd.mirandacraft.client.gui.widget;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.IStatefulTexture;
import com.besuikerd.mirandacraft.client.gui.texture.ITexture;

public class WidgetStateButton extends WidgetButton implements IHasData<Integer>{

	protected int state;
	protected int totalStates;
	protected ITexture[] glyphs;
	
	public WidgetStateButton(String identifier, IWidgetHandler gui,
			Rectangle bounds, IStatefulTexture texture, int totalStates) {
		super(identifier, gui, bounds, texture);
		this.totalStates = totalStates;
		setDataProvider(this);
	}
	
	public WidgetStateButton(String identifier, IWidgetHandler gui,
			Rectangle bounds, IStatefulTexture texture,	ITexture... glyphs) {
		this(identifier, gui, bounds, texture, glyphs.length);
		this.glyphs = glyphs;
	}
	
	@Override
	public void draw() {
		if(glyphs != null){
			this.glyph = glyphs[state];
		}
		super.draw();
	}

	@Override
	public void onRelease(int x, int y, MouseButton button) {
		this.state = (state + 1) % totalStates;
		super.onRelease(x, y, button);
	}
	
	@Override
	public Integer getData() {
		return state;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
}
