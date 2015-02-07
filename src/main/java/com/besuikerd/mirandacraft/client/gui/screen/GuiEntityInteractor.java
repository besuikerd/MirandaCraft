package com.besuikerd.mirandacraft.client.gui.screen;

import org.lwjgl.util.Rectangle;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.besuikerd.mirandacraft.client.gui.GuiContainerBesu;
import com.besuikerd.mirandacraft.client.gui.texture.Glyph;
import com.besuikerd.mirandacraft.client.gui.texture.TextureLocation;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetCheckbox;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetStateButton;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityInteractor;

public class GuiEntityInteractor extends GuiEntityScanner<TileEntityEntityInteractor>{

	
	protected WidgetStateButton stateButtonRedstone;
	protected WidgetCheckbox checkboxMouse;
	protected WidgetCheckbox checkboxIsSneaking;
	
	public static final String ACTION_REDSTONE_STATE = "redstoneState";
	public static final String ACTION_TOGGLE_MOUSE = "mouse";
	public static final String ACTION_TOGGLE_SNEAKING = "sneaking";
	
	public static final Rectangle RECT_BUTTON_REDSTONE = new Rectangle(151, 22, 18, 18);
	public static final Rectangle RECT_BUTTON_MOUSE = new Rectangle(131, 22, 18, 18);
	public static final Rectangle RECT_BUTTON_SNEAKING = new Rectangle(111, 22, 18, 18);
	
	public GuiEntityInteractor(Container container,
			TileEntityEntityInteractor tile, EntityPlayer player) {
		super(container, tile, player);
		xSize = 176;
		ySize = 222;
		background = TextureLocation.GUI_ENTITY_INTERACTOR;
	}
	
	@Override
	public void initWidgets() {
		super.initWidgets();
		this.stateButtonRedstone = addWidget(new WidgetStateButton(ACTION_REDSTONE_STATE, this, RECT_BUTTON_REDSTONE, WidgetStatefulTextures.BUTTON_ICON, Glyph.GUNPOWDER, Glyph.REDSTONE_TORCH_OFF, Glyph.REDSTONE_TORCH_ON));
		this.checkboxMouse = addWidget(new WidgetCheckbox(ACTION_TOGGLE_MOUSE, this, RECT_BUTTON_MOUSE, WidgetStatefulTextures.BUTTON_ICON, Glyph.MOUSE_LEFT, Glyph.MOUSE_RIGHT));
		this.checkboxIsSneaking = addWidget(new WidgetCheckbox(ACTION_TOGGLE_SNEAKING, this, RECT_BUTTON_SNEAKING, WidgetStatefulTextures.BUTTON_ICON, Glyph.SNEAK, Glyph.NOT_SNEAK));
	}
	
	@Override
	public void update() {
		super.update();

		stateButtonRedstone.setState(tile.getRedstoneControlType().ordinal());
		checkboxMouse.setChecked(!tile.usesLeftMouseButton());
		checkboxIsSneaking.setChecked(tile.isSneaking());
		
		checkboxMouse.setTooltip((tile.usesLeftMouseButton() ? "Left" : "Right")+ " Click");
		checkboxIsSneaking.setTooltip(tile.isSneaking() ? "Not Sneaking" : "Sneaking");
		
		
		switch(tile.getRedstoneControlType()){
		case IGNORE_REDSTONE:
			stateButtonRedstone.setTooltip("Ignore redstone");
			break;
		case HIGH_SIGNAL:
			stateButtonRedstone.setTooltip("Requires High signal");
			break;
		case LOW_SIGNAL:
			stateButtonRedstone.setTooltip("Requires Low signal");
			break;
		}
	}
}
