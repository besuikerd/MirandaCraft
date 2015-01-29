package com.besuikerd.mirandacraft.client.gui.screen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

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
import com.besuikerd.mirandacraft.lib.classifier.ParseException;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector2;
import com.google.common.collect.Lists;

public class GuiEntityCounter extends GuiContainerBesu<TileEntityEntityCounter> implements ITextUpdatedListener{

	private WidgetButton buttonAdd;
	private WidgetButton buttonRemove;
	private WidgetTextField textField;
	private WidgetList list;
	private WidgetScrollbar scrollbar;
	private WidgetLabel labelRange;
	private WidgetLabel labelCount;
	private WidgetButton buttonIncreaseRange;
	private WidgetButton buttonDecreaseRange;
	private WidgetButton buttonIncreaseCount;
	private WidgetButton buttonDecreaseCount;
	private WidgetCheckbox checkboxIsAnalog;
	
	private EntityFilterValidator validator;
	private ClassifierParser classifierParser = new ClassifierParser();
	
	public enum Widgets{
		BUTTON_ADD,
		BUTTON_REMOVE,
		BUTTON_INCREASE_RANGE,
		BUTTON_DECREASE_RANGE,
		BUTTON_INCREASE_COUNT,
		BUTTON_DECREASE_COUNT,
		CHECKBOX_IS_ANALOG,
		TEXTFIELD,
		LIST,
		SCROLLBAR,
		LABEL_RANGE,
		LABEL_COUNT
		;
	}
	
	public GuiEntityCounter(Container container, TileEntityEntityCounter tile,
			EntityPlayer player) {
		super(container, tile, player);
		this.xSize = 186;
		this.ySize = 125;
		this.validator = new EntityFilterValidator(tile.getEntityFilterVisitor());
		this.background = TextureLocation.GUI_ENTITY_COUNTER;
		this.title = "Entity Counter";
		initWidgets();
	}
	
	private void initWidgets(){
		this.buttonAdd = addWidget(new WidgetButton(Widgets.BUTTON_ADD.ordinal(), this, RECT_BUTTON_ADD, Glyph.PLUS));
		buttonAdd.setEnabled(false);
		this.buttonRemove = addWidget(new WidgetButton(Widgets.BUTTON_REMOVE.ordinal(), this, RECT_BUTTON_REMOVE, Glyph.MINUS));
		this.textField = addWidget(new WidgetTextField(Widgets.TEXTFIELD.ordinal(), this, RECT_TEXTFIELD));
		this.list = addWidget(new WidgetList(Widgets.LIST.ordinal(), this, RECT_LIST));
		this.scrollbar = addWidget(new WidgetScrollbar(Widgets.SCROLLBAR.ordinal(), this, RECT_SCROLL, list));
		
		this.buttonIncreaseRange = addWidget(new WidgetButton(Widgets.BUTTON_INCREASE_RANGE.ordinal(), this, RECT_BUTTON_RANGE_INC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_UP));
		this.buttonDecreaseRange = addWidget(new WidgetButton(Widgets.BUTTON_DECREASE_RANGE.ordinal(), this, RECT_BUTTON_RANGE_DEC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_DOWN));
		
		this.buttonIncreaseCount = addWidget(new WidgetButton(Widgets.BUTTON_INCREASE_COUNT.ordinal(), this, RECT_BUTTON_COUNT_INC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_UP));
		this.buttonDecreaseCount = addWidget(new WidgetButton(Widgets.BUTTON_DECREASE_COUNT.ordinal(), this, RECT_BUTTON_COUNT_DEC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_DOWN));
		
		this.labelRange = addWidget(new WidgetLabel.Right(Widgets.LABEL_RANGE.ordinal(), this,  "", buttonIncreaseRange, buttonDecreaseRange));
		this.labelCount = addWidget(new WidgetLabel.Left(Widgets.LABEL_COUNT.ordinal(), this, "", buttonIncreaseCount, buttonDecreaseCount));
		
		this.checkboxIsAnalog = addWidget(new WidgetCheckbox(Widgets.CHECKBOX_IS_ANALOG.ordinal(), this, POS_CHECKBOX_IS_ANALOG._1, POS_CHECKBOX_IS_ANALOG._2));
		checkboxIsAnalog.addTooltip("Is Analog");
		
		buttonAdd.setDataProvider(textField);
		buttonRemove.setDataProvider(list);
	}
	
	@Override
	public void onTextUpdated(int widgetId, String text) {
		if(widgetId == textField.getIdentifier()){
			try{
				ClassifierRule rule = classifierParser.parse(text);
				String error = rule.visit(validator, null);
				if(error != null){
					buttonAdd.setEnabled(false);
					buttonAdd.setTooltip(error);
				} else{
					buttonAdd.setEnabled(true);
					buttonAdd.clearToolTip();
				}
			} catch(ParseException e){
				buttonAdd.setEnabled(false);
				buttonAdd.setTooltip(e.getMessage());
			}
		}
	}
	
	@Override
	public void update() {
		//buttonAdd.setEnabled(!textField.getText().isEmpty() && !tile.getEntityRules().contains(textField.getText()));
		buttonRemove.setEnabled(!tile.getEntityRules().isEmpty() && list.getSelectedItemIndex() != -1);
		labelRange.setText("Range: " + tile.getRange());
		labelCount.setText("Max Count: " + tile.getMaxCount());
		checkboxIsAnalog.setChecked(tile.isAnalog());
		checkboxIsAnalog.setTooltip(tile.isAnalog() ? "Set to digital mode" : "Set to analog mode");
		list.setList(Lists.newArrayList(tile.getEntityRules().keySet()));
	}
	
	
	private static final Rectangle RECT_BUTTON_ADD = new Rectangle(155, 32, 12, 12);
	private static final Rectangle RECT_BUTTON_REMOVE = new Rectangle(169, 32, 12, 12);
	
	private static final Rectangle RECT_BUTTON_RANGE_INC = new Rectangle(4, 16, 12, 7);
	private static final Rectangle RECT_BUTTON_RANGE_DEC = new Rectangle(4, 23, 12, 7);
	
	private static final Rectangle RECT_BUTTON_COUNT_INC = new Rectangle(169, 16, 12, 7);
	private static final Rectangle RECT_BUTTON_COUNT_DEC = new Rectangle(169, 23, 12, 7);
	
	private static final Rectangle RECT_TEXTFIELD = new Rectangle(4, 32, 149, 12);
	private static final Rectangle RECT_LIST = new Rectangle(4, 46, 163, 74);
	private static final Rectangle RECT_SCROLL = new Rectangle(169, 46, 12, 74);
	
	private static final Vector2 POS_CHECKBOX_IS_ANALOG = new Vector2(169, 3);
	
}