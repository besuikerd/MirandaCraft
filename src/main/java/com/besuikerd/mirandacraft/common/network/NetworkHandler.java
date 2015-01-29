package com.besuikerd.mirandacraft.common.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
	public static final String CHANNEL_NAME = "mirandacraft";
	
	private static NetworkHandler instance;
	private SimpleNetworkWrapper channel = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL_NAME);
	private int id;
	
	private NetworkHandler(){}
	
	public static NetworkHandler getInstance(){
		if(instance == null){
			instance = new NetworkHandler();
		}
		return instance;
	}
	
	public void init(){
		register(PacketTileEntity.class, Side.CLIENT);
		register(PacketPressed.class, Side.SERVER);
		register(PacketPressedWithData.class,  Side.SERVER);
		register(PacketUpdateText.class, Side.SERVER);
	}
	
	private <E extends AbstractPacket<E>> void register(Class<E> cls, Side side){
		//ugly cast to circumvent type system, is still type safe though
		//
		register(cls, cls, side);
	}
	 
	
	private <REQ extends IMessage, REPLY extends IMessage> void register(Class<? extends IMessageHandler<REQ, REPLY>> handler, Class<REQ> msg, Side side){
		channel.registerMessage(handler, msg, id++, side);
	}
	
	public void sendToServer(IMessage message){
		channel.sendToServer(message);
	}
	
	public void sendToDimension(IMessage message, int dimensionId){
		channel.sendToDimension(message, dimensionId);
	}
	
	public void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point){
		channel.sendToAllAround(message, point);
	}
	
	public void sendToAll(IMessage message){
		channel.sendToAll(message);
    }

    public void sendTo(IMessage message, EntityPlayerMP player){
    	channel.sendTo(message, player);
    }
    
    public Packet getPacketFrom(IMessage message){
    	return channel.getPacketFrom(message);
    }
}
