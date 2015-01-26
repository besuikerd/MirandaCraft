package com.besuikerd.mirandacraft.common.network;

import com.besuikerd.mirandacraft.MirandaCraft;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

public abstract class AbstractPacket<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, IMessage>{
	@Override
	public IMessage onMessage(REQ message, MessageContext ctx) {
		switch(ctx.side){
		case CLIENT:
			handleClientPacket(message, ctx, MirandaCraft.instance.proxy.getPlayer());
			break;
		case SERVER:
			handleServerPacket(message, ctx, ctx.getServerHandler().playerEntity);
			break;
		}
		return null;
	}
	
	public void handleClientPacket(REQ message, MessageContext ctx, EntityPlayer player){
		
	}
	
	public void handleServerPacket(REQ message, MessageContext ctx, EntityPlayer player){
		
	}
}
