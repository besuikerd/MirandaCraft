package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;

import java.io.Serializable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.besuikerd.mirandacraft.client.gui.widget.IClickListener;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPressed extends PacketWidget<PacketPressed>{
	
	protected Object data;
	
	public PacketPressed() {
	}
	
	public PacketPressed(int widgetId, int x, int y, int z) {
		super(widgetId, x, y, z);
	}
	
	@Override
	public void handleServerPacket(PacketPressed message,
			MessageContext ctx, EntityPlayer player) {
		TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te != null && te instanceof IClickListener){
			((IClickListener) te).onClick(message.widgetId, message.data);
		}
	}
}
