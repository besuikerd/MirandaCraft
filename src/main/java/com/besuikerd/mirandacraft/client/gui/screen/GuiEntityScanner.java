package com.besuikerd.mirandacraft.client.gui.screen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.MathHelper;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.GuiContainerBesu;
import com.besuikerd.mirandacraft.client.gui.texture.Glyph;
import com.besuikerd.mirandacraft.client.gui.texture.WidgetStatefulTextures;
import com.besuikerd.mirandacraft.client.gui.widget.ITextUpdatedListener;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetButton;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetLabel;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetList;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetScrollbar;
import com.besuikerd.mirandacraft.client.gui.widget.WidgetTextField;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityScanner;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierParser;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ParseException;
import com.google.common.collect.Lists;

public abstract class GuiEntityScanner<A extends TileEntityEntityScanner> extends GuiContainerBesu<A> implements ITextUpdatedListener{
	
	protected WidgetButton buttonAdd;
	protected WidgetButton buttonRemove;
	protected WidgetTextField searchField;
	protected WidgetList list;
	protected WidgetScrollbar scrollbar;
	protected WidgetLabel labelRange;
	
	protected WidgetButton buttonRangeIncrease;
	protected WidgetButton buttonRangeDecrease;
	
	private ClassifierVisitor<Void, String> validator;
	private ClassifierParser classifierParser = new ClassifierParser();
	
	public static final String ACTION_ADD = "add";
	public static final String ACTION_REMOVE = "remove";
	public static final String ACTION_INCREASE_RANGE = "inc_range";
	public static final String ACTION_DECREASE_RANGE = "dec_range";
	
	public static final Rectangle RECT_BUTTON_ADD = new Rectangle(143, 42, 12, 12);
	public static final Rectangle RECT_BUTTON_REMOVE = new Rectangle(157, 42, 12, 12);
	
	public static final Rectangle RECT_BUTTON_RANGE_INC = new Rectangle(7,24, 12, 7);
	public static final Rectangle RECT_BUTTON_RANGE_DEC = new Rectangle(7, 31, 12, 7);
	
	public static final Rectangle RECT_SEARCH_FIELD = new Rectangle(7, 42, 134, 12);
	public static final Rectangle RECT_SCROLLBAR  = new Rectangle(157, 56, 12, 74);
	public static final Rectangle RECT_LIST = new Rectangle(7, 56, 148, 74);
	
	public GuiEntityScanner(Container container, A tile, EntityPlayer player) {
		super(container, tile, player);
		this.validator = tile.getValidationVisitor();
		this.classifierParser = new ClassifierParser();
	}
	
	public void initWidgets(){
		this.buttonAdd = addWidget(new WidgetButton(ACTION_ADD, this, RECT_BUTTON_ADD, Glyph.PLUS));
		this.buttonRemove = addWidget(new WidgetButton(ACTION_REMOVE, this, RECT_BUTTON_REMOVE, Glyph.MINUS));
		
		this.buttonRangeIncrease = addWidget(new WidgetButton(ACTION_INCREASE_RANGE, this, RECT_BUTTON_RANGE_INC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_UP));
		this.buttonRangeDecrease = addWidget(new WidgetButton(ACTION_DECREASE_RANGE, this, RECT_BUTTON_RANGE_DEC, WidgetStatefulTextures.BUTTON_SMALL, Glyph.ARROW_DOWN));
		
		this.searchField = addWidget(new WidgetTextField(generateId(), this, RECT_SEARCH_FIELD));
		
		this.list = addWidget(new WidgetList(generateId(), this, RECT_LIST));
		this.scrollbar = addWidget(new WidgetScrollbar(generateId(), this, RECT_SCROLLBAR, list));
		
		this.labelRange = addWidget(new WidgetLabel.Right(generateId(), this, "", buttonRangeIncrease, buttonRangeDecrease));
		
		
		buttonAdd.setEnabled(false);
		buttonAdd.setDataProvider(searchField);
		buttonRemove.setDataProvider(list);
	}
	
	@Override
	public void update() {
		buttonRemove.setEnabled(!tile.getRules().isEmpty() && list.getSelectedItemIndex() != -1);
		labelRange.setText("Range: " + tile.getRange());
		list.setList(Lists.newArrayList(tile.getRulesAsString()));
	}
	
	@Override
	public void onTextUpdated(String widgetId, String text) {
		if(widgetId.equals(searchField.getIdentifier())){
			try{
				ClassifierRule rule = classifierParser.parse(text);
				String error = rule.visit(validator, null);
				if(error != null){
					buttonAdd.setEnabled(false);
					setWarning(error);
				} else{
					buttonAdd.setEnabled(true);
					buttonAdd.clearToolTip();
				}
			} catch(ParseException e){
				buttonAdd.setEnabled(false);
				setWarning(e.getMessage());
			}
		}
	}
	
	protected void setWarning(String msg){
		buttonAdd.clearToolTip();
		int size = 200;
		int lines = MathHelper.ceiling_double_int(getFontRenderer().getStringWidth(msg) / (double)size);
		int charsPerLine = msg.length() / lines;
		for(int i = 0 ; i < lines ; i++){
			buttonAdd.addTooltip(msg.substring(i * charsPerLine, Math.min((i + 1) * charsPerLine, msg.length())));
		}
	}
}
