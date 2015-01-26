package com.besuikerd.mirandacraft.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketTileEntity extends PacketPosition<PacketTileEntity>{
	
	private TileEntity tile;
	private NBTTagCompound nbt;
	
	public PacketTileEntity(TileEntity tile) {
		super(tile.xCoord, tile.yCoord, tile.zCoord);
		this.tile = tile;
	}
	
	public PacketTileEntity() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		nbt = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		nbt = new NBTTagCompound();
		tile.writeToNBT(nbt);
		ByteBufUtils.writeTag(buf, nbt);
	}
	
	@Override
	public void handleClientPacket(PacketTileEntity message,
			MessageContext ctx, EntityPlayer player) {
		TileEntity tile = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(tile != null){
			tile.readFromNBT(message.nbt);
		}
	}
}
