package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;

import com.besuikerd.mirandacraft.common.utils.tuple.Vector3;

import cpw.mods.fml.common.network.simpleimpl.IMessage;

public abstract class PacketPosition<REQ extends IMessage> extends AbstractPacket<REQ>{
	protected int x;
	protected int y;
	protected int z;
	
	public PacketPosition(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public PacketPosition() {
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}
}
