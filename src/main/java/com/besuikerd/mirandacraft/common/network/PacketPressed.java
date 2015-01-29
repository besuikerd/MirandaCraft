package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;

import java.io.Serializable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import com.besuikerd.mirandacraft.client.gui.MouseButton;
import com.besuikerd.mirandacraft.client.gui.widget.IClickListener;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPressed<E extends PacketPressed> extends PacketWidget<E>{
	
	protected Object data;
	protected int button;
	
	public PacketPressed() {
	}
	
	public PacketPressed(int button, int widgetId, int x, int y, int z) {
		super(widgetId, x, y, z);
		this.button = button;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		buf.writeInt(button);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.button = buf.readInt();
	}
	
	@Override
	public void handleServerPacket(PacketPressed message,
			MessageContext ctx, EntityPlayer player) {
		TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te != null && te instanceof IClickListener){
			((IClickListener) te).onClick(message.widgetId, MouseButton.values()[message.button], message.data);
		}
	}
}
