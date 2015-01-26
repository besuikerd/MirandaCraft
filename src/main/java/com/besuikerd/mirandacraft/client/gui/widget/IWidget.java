package com.besuikerd.mirandacraft.client.gui.widget;

import java.util.List;

import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.util.Rectangle;

import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.common.utils.tuple.Tuple2;

public interface IWidget {
	public int getIdentifier();
	public Rectangle getBounds();
	public void draw();
	public List<Tuple2<EnumChatFormatting, String>> getTooltip();
	public boolean canOverruleFocus(IWidget other);
	
	public boolean onClick(int x, int y, MouseButton button);
	public void onRelease(int x, int y, MouseButton button);
	public void onMove(int x, int y, MouseButton button);
	public boolean onKeyPressed(char c, int code);
	public void onScroll(int x, int y, int amount);
}