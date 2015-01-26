package com.besuikerd.mirandacraft.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;

import com.besuikerd.mirandacraft.client.gui.widget.IWidget;

public interface IWidgetHandler {
	public boolean requestFocus(IWidget widget);
	public void releaseFocus(IWidget widget);
	public boolean isFocused(IWidget widget);
	
	public <A extends IWidget> A addWidget(A widget);
	public <A extends IWidget> A removeWidget(A widget);
	
	public int nextIdentifier();
	
	public int offsetX();
	public int offsetY();
	
	public FontRenderer getFontRenderer();
	public TextureManager getTextureManager();
}
