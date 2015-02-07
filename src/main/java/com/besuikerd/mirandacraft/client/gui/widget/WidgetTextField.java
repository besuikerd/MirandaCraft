package com.besuikerd.mirandacraft.client.gui.widget;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.common.network.NetworkHandler;
import com.besuikerd.mirandacraft.common.network.PacketUpdateText;
import com.besuikerd.mirandacraft.common.tileentity.IHasTileEntity;

import cpw.mods.fml.common.network.NetworkRegistry;

public class WidgetTextField extends AbstractWidget implements IHasData<String>{

	private StringBuilder text;
	private int caret;
	
	protected int color = 0xe0e0e0;
	
	public WidgetTextField(String identifier, IWidgetHandler gui, Rectangle bounds) {
		super(identifier, gui, bounds);
		this.text = new StringBuilder();
	}
	
	@Override
	public void draw() {
		String actualText = gui.getFontRenderer().trimStringToWidth(gui.isFocused(this) ? text.substring(0, caret) + "_" + text.substring(caret) : text.toString(), width() - 4, true);
		gui.getFontRenderer().drawStringWithShadow(actualText, x() + 2, y() + 2, color);
	}
	
	public String getText() {
		return text.toString();
	}
	
	public void setText(String text) {
		this.text = new StringBuilder(text);
	}
	
	public void clearText(){
		text.setLength(0);
	}
	
	public boolean acceptsInput(char c){
		return ChatAllowedCharacters.isAllowedCharacter(c);
	}
	
	@Override
	public boolean onKeyPressed(char c, int code) {
		switch(code){
		case Keyboard.KEY_BACK:
			if(text.length() != 0){
				caret--;
				text = text.deleteCharAt(caret);
				fieldUpdated();
			}
			return true;
		case Keyboard.KEY_DELETE:
			if(text.length() > caret){
				text = text.deleteCharAt(caret);
				fieldUpdated();
			}
			return true;
		case Keyboard.KEY_HOME:
			caret = 0;
			return true;
		case Keyboard.KEY_END:
			caret = text.length();
			return true;
		case Keyboard.KEY_ESCAPE:
		case Keyboard.KEY_RETURN:
			gui.releaseFocus(this);
			return true;
		case Keyboard.KEY_RIGHT:
			if(caret < text.length()){
				caret++;
			}
			return true;
		case Keyboard.KEY_LEFT:
			if(caret > 0){
				caret--;
			}
			return true;
		default:
			if(acceptsInput(c)){
				text.insert(caret, c);
				caret++;
				fieldUpdated();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean onClick(int x, int y, MouseButton button) {
		if(bounds.contains(x, y)){
			if(!gui.isFocused(this)){
				gui.requestFocus(this);
				caret = text.length();
				return false;
			}
		} else{
			gui.releaseFocus(this);
		}
		
		switch(button){
		case MIDDLE:
		case RIGHT:
			caret = 0;
			clearText();
			fieldUpdated();
			return true;
		default:
			break;
		}
		return false;
	}
	
	private void fieldUpdated(){
		//TODO fix caret
		
		if(gui instanceof ITextUpdatedListener){
			((ITextUpdatedListener) gui).onTextUpdated(getIdentifier(), text.toString());
		}
		
		if(gui instanceof IHasTileEntity){
			TileEntity te = ((IHasTileEntity) gui).getTileEntity();
			if(te instanceof ITextUpdatedListener){
				((ITextUpdatedListener) te).onTextUpdated(getIdentifier(), text.toString());
				NetworkHandler.getInstance().sendToServer(new PacketUpdateText(text.toString(), getIdentifier(), te.xCoord, te.yCoord, te.zCoord));
			}
		}
	}

	@Override
	public String getData() {
		return text.toString();
	}
}
