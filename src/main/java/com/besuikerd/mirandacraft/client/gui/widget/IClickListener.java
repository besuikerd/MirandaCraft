package com.besuikerd.mirandacraft.client.gui.widget;

import com.besuikerd.mirandacraft.client.gui.MouseButton;

import net.minecraft.nbt.NBTTagCompound;

public interface IClickListener {
	public void onClick(String widgetId, MouseButton button, Object data);
}