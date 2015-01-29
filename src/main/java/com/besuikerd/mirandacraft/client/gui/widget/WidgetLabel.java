package com.besuikerd.mirandacraft.client.gui.widget;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector2;

public class WidgetLabel extends AbstractWidget implements IHasData<String>{

	protected String text;
	protected int color;
	
	public WidgetLabel(int identifier, IWidgetHandler gui, Rectangle bounds, String text) {
		super(identifier, gui, bounds);
		this.text = text;
		this.color = 0x404040;
	}
	
	public WidgetLabel(int identifier, IWidgetHandler gui, Rectangle bounds) {
		this(identifier, gui, bounds, "");
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}

	@Override
	public void draw() {
		gui.getFontRenderer().drawString(text, x(), y(), color);
	}

	@Override
	public String getData() {
		return text;
	}
	
	public static abstract class WidgetLabelPositioned extends WidgetLabel{
		protected IWidget[] others;
		protected int offset;
		
		public WidgetLabelPositioned(int identifier, IWidgetHandler gui, String text, IWidget... others) {
			super(identifier, gui, new Rectangle(0,0,0,0), text);
			this.others = others;
			this.offset = 3;
		}
		
		@Override
		public void draw() {
			Rectangle otherBounds = calculateOthersBounds();
			//System.out.println(this.getClass().getSimpleName() + ":calculated rect: " + otherBounds);
			setBounds(new Rectangle(
				getPositionX(otherBounds),
				getPositionY(otherBounds),
				gui.getFontRenderer().getStringWidth(text),
				gui.getFontRenderer().FONT_HEIGHT
			));
			super.draw();
		}
		
		protected Rectangle calculateOthersBounds(){
			if(others.length == 1){
				return others[0].getBounds();
			}
			
			int minX = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;
			
			
			for(IWidget widget : others){
				Rectangle bounds = widget.getBounds();
				if(bounds.getX() < minX){
					minX = bounds.getX();
				}
				if(bounds.getX() + bounds.getWidth() > maxX){
					maxX = bounds.getX() + bounds.getWidth();
				}
				if(bounds.getY() < minY){
					minY = bounds.getY();
				}
				if(bounds.getY() + bounds.getHeight() > maxY){
					maxY = bounds.getY() + bounds.getHeight();
				}
			}
			return new Rectangle(minX, minY, maxX - minX, maxY - minY);
		}
		
		public WidgetLabelPositioned withOffset(int offset){
			this.offset = offset;
			return this;
		}
		
		protected abstract int getPositionX(Rectangle otherBounds);
		protected abstract int getPositionY(Rectangle otherBounds);
	}
	
	public static class Left extends WidgetLabelPositioned{
		public Left(int identifier, IWidgetHandler gui, String text, IWidget... others) {
			super(identifier, gui, text, others);
		}
		
		@Override
		protected int getPositionX(Rectangle otherBounds) {
			return otherBounds.getX() - gui.getFontRenderer().getStringWidth(text) - offset;
		}
		
		@Override
		protected int getPositionY(Rectangle otherBounds) {
			return otherBounds.getY() + (otherBounds.getHeight() - gui.getFontRenderer().FONT_HEIGHT) / 2;
		}
		
	}
	
	public static class Right extends WidgetLabelPositioned{
		public Right(int identifier, IWidgetHandler gui, String text, IWidget... others) {
			super(identifier, gui, text, others);
		}
		
		@Override
		protected int getPositionX(Rectangle otherBounds) {
			return otherBounds.getX() + otherBounds.getWidth() + offset;
		}
		
		@Override
		protected int getPositionY(Rectangle otherBounds) {
			return otherBounds.getY() + (otherBounds.getHeight() - gui.getFontRenderer().FONT_HEIGHT) / 2;
		}
	}
}
