package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;

import com.besuikerd.mirandacraft.client.gui.widget.ITextUpdatedListener;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdateText extends PacketWidget<PacketUpdateText>{
	protected String text;
	
	public PacketUpdateText() {
	}

	public PacketUpdateText(String text, int widgetId, int x, int y, int z) {
		super(widgetId, x, y, z);
		this.text = text;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		ByteBufUtils.writeUTF8String(buf, text);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.text = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void handleServerPacket(PacketUpdateText message,
			MessageContext ctx, EntityPlayer player) {
		TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te instanceof ITextUpdatedListener){
			((ITextUpdatedListener) te).onTextUpdated(message.widgetId, message.text);
		}
	}
}
