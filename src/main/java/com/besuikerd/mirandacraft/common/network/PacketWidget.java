package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class PacketWidget<REQ extends IMessage> extends PacketPosition<REQ>{
	protected int widgetId;
	
	public PacketWidget() {
	}

	public PacketWidget(int x, int y, int z) {
		super(x, y, z);
	}

	public PacketWidget(int widgetId, int x, int y, int z) {
		super(x, y, z);
		this.widgetId = widgetId;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		buf.writeInt(widgetId);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.widgetId = buf.readInt();
	}
}
