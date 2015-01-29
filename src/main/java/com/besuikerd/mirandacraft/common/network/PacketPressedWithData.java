package com.besuikerd.mirandacraft.common.network;

import java.io.Serializable;

import io.netty.buffer.ByteBuf;

public class PacketPressedWithData extends PacketPressed<PacketPressedWithData>{
	public PacketPressedWithData() {
	}

	public PacketPressedWithData(Object data, int button, int widgetId,  int x, int y,
			int z) {
		super(button, widgetId, x, y, z);
		this.data = data;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.data = ByteBufUtils2.readSerializable(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		ByteBufUtils2.writeSerializable(buf, (Serializable) data);
	}
}
