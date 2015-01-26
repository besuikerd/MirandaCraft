package com.besuikerd.mirandacraft.client.gui.widget;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.Glyph;
import com.besuikerd.mirandacraft.client.gui.texture.ITexture;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetTextures;

public class WidgetCheckbox extends WidgetButton implements IHasData<Boolean>{

	private boolean checked;
	
	protected ITexture glyphChecked = Glyph.CHECKED;
	protected ITexture glyphUnchecked = Glyph.UNCHECKED;
	
	public WidgetCheckbox(int identifier, IWidgetHandler gui, int x, int y) {
		super(identifier, gui, new Rectangle(x,y, WidgetStatefulTextures.BUTTON.normal().getWidth(), WidgetStatefulTextures.BUTTON.normal().getHeight()), WidgetStatefulTextures.BUTTON);
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
	

	@Override
	public void onRelease(int x, int y, MouseButton button) {
		setChecked(!checked);
		super.onRelease(x, y, button);
	}
}
