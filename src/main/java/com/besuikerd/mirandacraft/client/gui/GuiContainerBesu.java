package com.besuikerd.mirandacraft.client.gui;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.besuikerd.mirandacraft.client.gui.widget.IWidget;
import com.besuikerd.mirandacraft.common.tileentity.IHasTileEntity;
import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;

public abstract class GuiContainerBesu<A extends TileEntity> extends GuiContainer implements IWidgetHandler, IHasTileEntity{
	private Map<Integer, IWidget> widgets;
	
	protected IWidget focus;
	
	protected A tile;
	protected EntityPlayer player;
	
	protected ResourceLocation background;
	
	private int offsetX;
	private int offsetY;
	
	protected String title;
	
	public GuiContainerBesu(Container container, A tile, EntityPlayer player) {
		super(container);
		this.tile = tile;
		this.player = player;
		this.widgets = new LinkedHashMap<Integer, IWidget>();
	}
	
	protected int mouseX(){
		return Mouse.getEventX() * this.width / this.mc.displayWidth;
	}
	
	protected int mouseY(){
		return this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
		update();
		
		GL11.glColor4d(1, 1, 1, 1);
		offsetX = (width - xSize) / 2;
		offsetY = (height - ySize) / 2;
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);
		
		
		GL11.glDisable(GL11.GL_LIGHTING);
		
		if(title != null){
			int width = mc.fontRenderer.getStringWidth(title);
			mc.fontRenderer.drawString(title, offsetX + (xSize - width) / 2, offsetY + 6,  0x404040);
		}
		
		mc.getTextureManager().bindTexture(background);
		for(IWidget widget : widgets.values()){
			GL11.glColor4d(1, 1, 1, 1);
			widget.draw();
		}

		for(IWidget widget : widgets.values()){
			if(!widget.getTooltip().isEmpty() && widget.getBounds().contains(x - offsetX, y - offsetY)){
				List<String> tooltips = new LinkedList<String>();
				for(Tuple2<EnumChatFormatting, String> tooltip : widget.getTooltip()){
					tooltips.add(tooltip._1 + tooltip._2);
				}
				drawHoveringText(tooltips, x, y, mc.fontRenderer);
				
			}
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
	}
	
	public void update(){
		
	}
	
	@Override
	public void handleMouseInput() {
		super.handleMouseInput();
		int x = mouseX();
		int y = mouseY();
		int scroll = Mouse.getDWheel();
		if(scroll != 0){
			for(IWidget widget : widgets.values()){
				if(widget.getBounds().contains(x - offsetX, y - offsetY)){
					widget.onScroll(x - offsetX, y - offsetY, scroll);
				}
			}
		}
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
		if(focus == null || !focus.onClick(x - offsetX, y - offsetY, MouseButton.values()[button])){
			for(IWidget widget : widgets.values()){
				if(widget.getBounds().contains(x - offsetX, y - offsetY) && widget.onClick(x - offsetX, y - offsetY, MouseButton.values()[button])){
					break;
				}
			}
		}
	}
	
	
	@Override
	protected void mouseClickMove(int x, int y, int button, long timeSinceMouseClick) {
		super.mouseClickMove(x, y, button, timeSinceMouseClick);
		if(focus != null){
			focus.onMove(x - offsetX, y - offsetY, MouseButton.values()[button]);
		}
	}
	
	@Override
	protected void mouseMovedOrUp(int x, int y,	int which) {
		super.mouseMovedOrUp(x, y, which);
		switch(which){
		case 0: //Mouse up
		case 1: //Mouse up
		case 2: 
			if(focus != null){
				focus.onRelease(x, y, MouseButton.values()[which]);
			}
			break;
		}
	}
	
	@Override
	protected void keyTyped(char c, int code) {
		if(focus == null || !focus.onKeyPressed(c, code)){
			super.keyTyped(c, code);
		}
	}
	
	@Override
	public <B extends IWidget> B addWidget(B widget) {
		if(!widgets.containsKey(widget.getIdentifier())){
			widgets.put(widget.getIdentifier(), widget);
			return widget;
		} else{
			throw new IllegalArgumentException(String.format("Duplicate widget id: %d", widget.getIdentifier()));
		}
	}
	
	public <B extends IWidget> B removeWidget(B widget) {
		if(widgets.containsKey(widget.getIdentifier())){
			widgets.remove(widget.getIdentifier());
			return widget;
		} else{
			throw new IllegalArgumentException(String.format("Widget with identifier '%s' does not exist", widget.getIdentifier()));
		}
		
	}
	
	@Override
	public boolean requestFocus(IWidget widget) {
		if(focus == null || focus.canOverruleFocus(widget)){
			this.focus = widget;
			return true;
		}
		return false;
	}



	@Override
	public void releaseFocus(IWidget widget) {
		if(focus != null && focus.equals(widget)){
			focus = null;
		}
	}
	
	@Override
	public boolean isFocused(IWidget widget) {
		return focus != null && focus.equals(widget);
	}
	
	@Override
	public int nextIdentifier() {
		return widgets.size();
	}
	
	@Override
	public int offsetX() {
		return offsetX;
	}
	
	@Override
	public int offsetY() {
		return offsetY;
	}
	
	@Override
	public FontRenderer getFontRenderer() {
		return mc.fontRenderer;
	}
	
	@Override
	public TextureManager getTextureManager() {
		return mc.getTextureManager(); 
	}
	
	@Override
	public TileEntity getTileEntity() {
		return tile;
	}
	
	
}
