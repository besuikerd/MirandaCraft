package com.besuikerd.mirandacraft.client.gui.widget;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.IStatefulTexture;
import com.besuikerd.mirandacraft.lib.utils.tuple.Tuple2;

public abstract class AbstractWidget implements IWidget{
	private int identifier;
	protected Rectangle bounds;
	protected IWidgetHandler gui;
	protected List<Tuple2<EnumChatFormatting, String>> tooltip;
	
	public AbstractWidget(int identifier, IWidgetHandler gui, int x, int y, int width, int height){
		this(identifier, gui, new Rectangle(x, y, width, height));
	}
	
	public AbstractWidget(int identifier, IWidgetHandler gui, Rectangle bounds){
		this.gui = gui;
		this.bounds = bounds;
		this.identifier = identifier;
		this.tooltip = new LinkedList<Tuple2<EnumChatFormatting,String>>();
	}
	
	@Override
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	@Override
	public List<Tuple2<EnumChatFormatting, String>> getTooltip() {
		return tooltip;
	}
	
	public void addTooltip(EnumChatFormatting format, String text){
		tooltip.add(new Tuple2<EnumChatFormatting, String>(format, text));
	}
	
	public void addTooltip(String text){
		addTooltip(EnumChatFormatting.GRAY, text);
	}
	
	public void setTooltip(String... lines){
		tooltip.clear();
		for(String line : lines){
			addTooltip(line);
		}
	}
	
	public void clearToolTip(){
		tooltip.clear();
	}
	
	@Override
	public int getIdentifier() {
		return identifier;
	}
	
	@Override
	public boolean canOverruleFocus(IWidget other) {
		return true;
	}
	
	@Override
	public boolean onClick(int x, int y, MouseButton button) {
		return false;
	}
	
	@Override
	public void onRelease(int x, int y, MouseButton button) {
	}
	
	@Override
	public void onMove(int x, int y, MouseButton button) {
	}
	
	@Override
	public boolean onKeyPressed(char c, int code) {
		return false;
	}
	
	@Override
	public void onScroll(int x, int y, int amount) {
	}
	
	
	protected int x(){return gui.offsetX() + bounds.getX();}
	protected int y(){return gui.offsetY() + bounds.getY();}
	protected int width(){return bounds.getWidth();}
	protected int height(){return bounds.getHeight();}
	
	public void drawTexture(int x, int y, int width, int height, int u, int v)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        float zLevel = 0.0f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)zLevel, (double)((float)(u + 0) * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)zLevel, (double)((float)(u + width) * f), (double)((float)(v + height) * f1));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)zLevel, (double)((float)(u + width) * f), (double)((float)(v + 0) * f1));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)zLevel, (double)((float)(u + 0) * f), (double)((float)(v + 0) * f1));
        tessellator.draw();
    }
	
	public void drawRect(int x, int y, int width, int height, int color)
    {
        float f3 = (float)(color >> 24 & 255) / 255.0F;
        float f = (float)(color >> 16 & 255) / 255.0F;
        float f1 = (float)(color >> 8 & 255) / 255.0F;
        float f2 = (float)(color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(f, f1, f2, f3);
        tessellator.startDrawingQuads();
        tessellator.addVertex(x, y + height, 0);
        tessellator.addVertex(x + width, y + height, 0);
        tessellator.addVertex(x + width, y, 0);
        tessellator.addVertex(x, y, 0);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
