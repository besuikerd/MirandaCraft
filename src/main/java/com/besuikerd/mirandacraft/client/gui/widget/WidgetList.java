package com.besuikerd.mirandacraft.client.gui.widget;

import java.util.List;

import net.minecraft.client.gui.Gui;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;

public class WidgetList extends AbstractWidget implements ScrollbarCompanion, IHasData<Integer>{

	private List<?> items;
	private int itemOffset;
	
	protected int color = 0xe0e0e0;
	protected int itemSize = 8;
	protected int itemSpace = 2;
	
	protected int selectedItem = -1;
	
	public WidgetList(int identifier, IWidgetHandler gui, Rectangle bounds, List<?> items) {
		super(identifier, gui, bounds);
		this.items = items;
	}
	
	public void setItemOffset(int offset){
		this.itemOffset = offset;
	}
	
	public Object getSelectedItem(){
		return selectedItem == -1 ? null : items.get(selectedItem);
	}
	
	public int getSelectedItemIndex(){
		return selectedItem;
	}

	@Override
	public void draw() {
		int totalSize = 0;
		if(selectedItem != -1 && selectedItem - itemOffset >= 0 && selectedItem - itemOffset < visibleItems()){
			int yOffset = (selectedItem - itemOffset) * (itemSize + itemSpace);
			//drawRect(x() + 2, y() + yOffset, width() - 4, itemSize + itemSpace, 0xdddddd);
			Gui.drawRect(x() + 1, y() + yOffset + 1, x() + 4 + width() - 4, y() + yOffset + itemSize + itemSpace, 0xbbbbbbff);
		}
		
		for(int i = itemOffset ; i < items.size() && i < itemOffset + visibleItems() ; i++){
			String item = items.get(i).toString();
			String actualtext = gui.getFontRenderer().trimStringToWidth(item, width() - 4);
			gui.getFontRenderer().drawStringWithShadow(actualtext, x() + 2, y() + 2 + totalSize, color);
			totalSize += itemSize + itemSpace;
		}
	}
	
	public void setList(List<?> list){
		if(selectedItem > list.size() - 1){
			selectedItem = list.size() - 1;
		}
		if(itemOffset > list.size() - visibleItems()){
			itemOffset = Math.max(0, list.size() - visibleItems());
		}
		this.items = list;
	}
	
	public int visibleItems(){
		return  height() / (itemSize + itemSpace);
	}
	
	@Override
	public boolean onClick(int x, int y, MouseButton button) {
		switch(button){
		case LEFT:
			int clickedItem = itemOffset + (y - bounds.getY()) / (itemSize + itemSpace); 
			if(clickedItem < items.size()){
				selectedItem = clickedItem;
				System.out.println("selected: " + getSelectedItem());
				return true;
			}
		case RIGHT:
		case MIDDLE:
			selectedItem = -1;
			return true;
		}
		return false;
	}
	
	@Override
	public void onScroll(int x, int y, int amount) {
		if(amount < 0 && itemOffset < items.size() - visibleItems()){
			itemOffset++;
		} else if(amount > 0 && itemOffset > 0){
			itemOffset--;
		}
	}
	
	@Override
	public int getSize() {
		return Math.max(0, items.size() - visibleItems());
	}
	
	@Override
	public void setProgress(int i) {
		itemOffset = i;
	}
	
	@Override
	public int getProgress() {
		return itemOffset;
	}
	
	@Override
	public Integer getData() {
		return selectedItem;
	}
}