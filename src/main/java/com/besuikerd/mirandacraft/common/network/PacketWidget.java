package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class PacketWidget<REQ extends IMessage> extends PacketPosition<REQ>{
	protected String widgetId;
	
	public PacketWidget() {
	}

	public PacketWidget(int x, int y, int z) {
		super(x, y, z);
	}

	public PacketWidget(String widgetId, int x, int y, int z) {
		super(x, y, z);
		this.widgetId = widgetId;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		ByteBufUtils.writeUTF8String(buf, widgetId);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.widgetId = ByteBufUtils.readUTF8String(buf);
	}
}
