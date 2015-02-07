package com.besuikerd.mirandacraft.client.gui.widget;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.Glyph;
import com.besuikerd.mirandacraft.client.gui.texture.IStatefulTexture;
import com.besuikerd.mirandacraft.client.gui.texture.ITexture;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetTextures;

public class WidgetCheckbox extends WidgetButton implements IHasData<Boolean>{

	private boolean checked;
	
	protected ITexture glyphChecked;
	protected ITexture glyphUnchecked;
	
	public WidgetCheckbox(String identifier, IWidgetHandler gui, Rectangle bounds, IStatefulTexture texture, ITexture glyphUnchecked, ITexture glyphChecked) {
		super(identifier, gui, bounds, WidgetStatefulTextures.BUTTON);
		this.glyphChecked = glyphChecked;
		this.glyphUnchecked = glyphUnchecked;
		this.texture = texture;
		setChecked(false);
		setDataProvider(this);
	}
	
	@Override
	public void draw() {
		super.draw();
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.glyph = checked ? glyphChecked : glyphUnchecked;
		this.checked = checked;
	}
	
	@Override
	public Boolean getData() {
		return checked;
	}
	
	public WidgetCheckbox checkedGlyph(ITexture glyphChecked){
		this.glyphChecked = glyphChecked;
		return this;
	}
	
	public WidgetCheckbox uncheckedGlyph(ITexture glyphUnchecked){
		this.glyphUnchecked = glyphUnchecked;
		return this;
	}

	@Override
	public void onRelease(int x, int y, MouseButton button) {
		setChecked(!checked);
		super.onRelease(x, y, button);
	}
}
