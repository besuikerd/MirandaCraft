package com.besuikerd.mirandacraft.client.gui.widget;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.IWidgetHandler;
import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.texture.IStatefulTexture;
import com.besuikerd.mirandacraft.client.gui.texture.ITexture;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.common.network.NetworkHandler;
import com.besuikerd.mirandacraft.common.network.PacketPressed;
import com.besuikerd.mirandacraft.common.network.PacketPressedWithData;
import com.besuikerd.mirandacraft.common.tileentity.IHasTileEntity;

public class WidgetButton extends AbstractWidget{
	
	protected boolean pressed = false;
	protected boolean enabled = true;
	
	protected IStatefulTexture texture;
	protected ITexture glyph;
	
	private IHasData<?> dataProvider;
	
	public WidgetButton(String identifier, IWidgetHandler gui, Rectangle bounds, IStatefulTexture texture, ITexture glyph) {
		super(identifier, gui, bounds);
		this.texture = texture;
		this.glyph = glyph;
	}
	
	public WidgetButton(String identifier, IWidgetHandler gui, Rectangle bounds, IStatefulTexture texture) {
		this(identifier, gui, bounds, texture, null);
	}
	
	public WidgetButton(String identifier, IWidgetHandler gui, Rectangle bounds, ITexture glyph) {
		this(identifier, gui, bounds, WidgetStatefulTextures.BUTTON, glyph);
	}
	
	public WidgetButton(String identifier, IWidgetHandler gui, Rectangle bounds) {
		this(identifier, gui, bounds, (ITexture) null);
	}
	
	

	@Override
	public void draw() {
		Rectangle bg = enabled ? pressed ? texture.active() : texture.normal() : texture.disabled();
		
		gui.getTextureManager().bindTexture(texture.getTexture());
		drawTexture(x(), y(), width(), height(), bg.getX(), bg.getY());
		
		if(glyph != null){
			gui.getTextureManager().bindTexture(glyph.getTexture());
			Rectangle pos = glyph.getPosition();
			drawTexture(x() + (width() - pos.getWidth()) / 2 , y() + (height() - pos.getHeight()) / 2, pos.getWidth(), pos.getHeight(), pos.getX(), pos.getY());
		}
	}
	
	public void enable(){
		this.enabled = true;
	}
	
	public void disable(){
		this.enabled = false;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public boolean onClick(int x, int y, MouseButton button) {
		if(enabled && gui.requestFocus(this)){
			pressed = true;
			return true;
		}
		return false;
	}
	
	public void setDataProvider(IHasData<?> dataProvier) {
		this.dataProvider = dataProvier;
	}

	@Override
	public void onRelease(int x, int y, MouseButton button) {
		if(pressed){
			pressed = false;
			gui.releaseFocus(this);
			if(gui instanceof IHasTileEntity){
				TileEntity te = ((IHasTileEntity) gui).getTileEntity();
				if(te instanceof IClickListener){
					if(dataProvider != null){
						((IClickListener) te).onClick(getIdentifier(), button, dataProvider.getData());
						NetworkHandler.getInstance().sendToServer(new PacketPressedWithData(dataProvider.getData(), button.ordinal(), getIdentifier(), te.xCoord, te.yCoord, te.zCoord));
					} else{
						((IClickListener) te).onClick(getIdentifier(), button, null);
						NetworkHandler.getInstance().sendToServer(new PacketPressed(button.ordinal(), getIdentifier(), te.xCoord, te.yCoord, te.zCoord));
					}
					
				}
			}
		}
	}
}
