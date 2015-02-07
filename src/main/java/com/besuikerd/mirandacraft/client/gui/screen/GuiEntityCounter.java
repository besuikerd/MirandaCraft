package com.besuikerd.mirandacraft.client.gui.screen;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.MathHelper;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.GuiContainerBesu;
import com.besuikerd.mirandacraft.client.gui.texture.Glyph;
import com.besuikerd.mirandacraft.client.gui.texture.TextureLocation;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.client.gui.widget.ITextUpdatedListener;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetButton;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetCheckbox;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetLabel;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetList;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetScrollbar;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetTextField;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierParser;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ParseException;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector2;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.EntityRegistry.EntityRegistration;

public class GuiEntityCounter extends GuiEntityScanner<TileEntityEntityCounter>{
	
	private WidgetLabel labelCount;
	private WidgetButton buttonIncreaseCount;
	private WidgetButton buttonDecreaseCount;
	private WidgetCheckbox checkboxIsAnalog;
	
	private ClassifierVisitor<String, Void> validator;
	private ClassifierParser classifierParser = new ClassifierParser();
	
	public static final String ACTION_COUNT_INC = "inc_count";
	public static final String ACTION_COUNT_DEC = "dec_count";
	public static final String ACTION_IS_ANALOG = "isAnalog";
	
	public static final Rectangle RECT_BUTTON_COUNT_INC = new Rectangle(157, 24, 12, 7);
	public static final Rectangle RECT_BUTTON_COUNT_DEC = new Rectangle(157, 31, 12, 7);
	public static final Rectangle RECT_CHECKBOX_IS_ANALOG = new Rectangle(79, 21, 18, 18);
	
	
	public GuiEntityCounter(Container container, TileEntityEntityCounter tile,
			EntityPlayer player) {
		super(container, tile, player);
		this.xSize = 176;
		this.ySize = 138;
		this.background = TextureLocation.GUI_ENTITY_COUNTER;
		this.title = "Entity Counter";
	}
	
	public void initWidgets(){
		super.initWidgets();
		this.buttonIncreaseCount = addWidget(new WidgetButton(ACTION_COUNT_INC, this, RECT_BUTTON_COUNT_INC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_UP));
		this.buttonDecreaseCount = addWidget(new WidgetButton(ACTION_COUNT_DEC, this, RECT_BUTTON_COUNT_DEC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_DOWN));
		this.checkboxIsAnalog = addWidget(new WidgetCheckbox(ACTION_IS_ANALOG, this, RECT_CHECKBOX_IS_ANALOG, WidgetStatefulTextures.BUTTON_ICON, Glyph.REDSTONE_TORCH_ON, Glyph.REDSTONE_DUST));
		this.labelCount = addWidget(new WidgetLabel.Left(generateId(), this, "", buttonIncreaseCount, buttonDecreaseCount));
		checkboxIsAnalog.addTooltip("Is Analog");
	}
	@Override
	public void update() {
		super.update();
		labelCount.setText("Count: " + tile.getMaxCount());
		labelCount.setTooltip("Currently: " + tile.getEntitiesCounted());
		checkboxIsAnalog.setChecked(tile.isAnalog());
		checkboxIsAnalog.setTooltip(tile.isAnalog() ? "Set to digital mode" : "Set to analog mode");
	}
	
	
	
	
}