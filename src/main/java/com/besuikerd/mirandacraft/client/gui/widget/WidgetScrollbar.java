package com.besuikerd.mirandacraft.client.gui.widget;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.IStatefulTexture;
import com.besuikerd.mirandacraft.client.gui.texture.TextureLocation;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;

public class WidgetScrollbar extends AbstractWidget{
	private ScrollbarCompanion companion;
	private int clickHeight = -1;
	
	private boolean pressed;
	private boolean enabled;
	
	private IStatefulTexture texture;
	
	protected int sliderHeight;

	public WidgetScrollbar(String identifier, IWidgetHandler gui, Rectangle bounds, ScrollbarCompanion companion, IStatefulTexture texture) {
		super(identifier, gui, bounds);
		this.companion = companion;
		this.texture = texture;
		this.enabled = true;
		this.sliderHeight = texture.normal().getHeight();
	}
	
	public WidgetScrollbar(String identifier, IWidgetHandler gui, Rectangle bounds, ScrollbarCompanion companion) {
		this(identifier, gui, bounds, companion, WidgetStatefulTextures.SCROLLER);
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public void draw() {
		Rectangle scroller = enabled ? pressed ? texture.active() : texture.normal() : texture.disabled();
		gui.getTextureManager().bindTexture(texture.getTexture());
		drawTexture(x() + 1, y() + 1 + sliderYOffset(), scroller.getWidth(), sliderHeight, scroller.getX(), scroller.getY());
	}
	
	@Override
	public void onScroll(int x, int y, int amount) {
		int progress = companion.getProgress();
		if(amount < 0 && progress < companion.getSize()){
			companion.setProgress(progress + 1);
		} else if(amount > 0 && progress > 0){
			companion.setProgress(progress - 1);
		}
	}
	
	@Override
	public boolean onClick(int x, int y, MouseButton button) {
		if(button == MouseButton.LEFT){
			int clickHeight = y - bounds.getY() - sliderYOffset() - 1;
			if(clickHeight <= sliderHeight && !gui.isFocused(this)){
				gui.requestFocus(this);
				this.pressed = true;
				this.clickHeight = clickHeight;
			}
		}
		return false;
	}
	
	protected int sliderYOffset(){
		return (int) (((double)companion.getProgress() / companion.getSize()) * slideAreaHeight());
	}
	
	protected int slideAreaHeight(){
		return height() - 2 - sliderHeight;
	}
	
	@Override
	public void onRelease(int x, int y, MouseButton button) {
		if(gui.isFocused(this)){
			gui.releaseFocus(this);
			this.pressed = false;
			this.clickHeight = -1;
		}
	}
	
	@Override
	public void onMove(int x, int y, MouseButton button) {
		int actualHeight = y - clickHeight;
		int progress = Math.max(0, Math.min(companion.getSize(), (int) (((double) (actualHeight - bounds.getY() - 1) / slideAreaHeight()) * companion.getSize())));
		companion.setProgress(progress);
		
		
	}
}