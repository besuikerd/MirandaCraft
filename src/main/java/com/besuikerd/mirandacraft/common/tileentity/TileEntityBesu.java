package com.besuikerd.mirandacraft.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import com.besuikerd.mirandacraft.common.network.NetworkHandler;
import com.besuikerd.mirandacraft.common.network.PacketTileEntity;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector3;

public abstract class TileEntityBesu extends TileEntity{
	public void onTileEntityPlacedBy(EntityLivingBase entity, ItemStack stack){}
	public void onRemoveTileEntity(Block block, int meta){}
	public void onTileEntityRemoved(Block block, int meta){}
	
	@Override
	public Packet getDescriptionPacket() {
		return NetworkHandler.getInstance().getPacketFrom(new PacketTileEntity(this));
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		readFromNBT(pkt.func_148857_g());
	}
	
	protected AxisAlignedBB calculateBoundingBoxAt(double x, double y, double z, double rangeHorizontal, double rangeVertical){
		double halfRangeHorizontal = rangeHorizontal / 2;
		double halfRangeVertical = rangeVertical / 2;
		return AxisAlignedBB.getBoundingBox(x - halfRangeHorizontal, y - rangeVertical, z - halfRangeHorizontal, x + halfRangeHorizontal, y + rangeVertical, z + halfRangeHorizontal);
	}
	
	protected AxisAlignedBB calculateBoundingBoxAt(double x, double y, double z, double range){
		return calculateBoundingBoxAt(x, y, z, range, range);
	}
	
	protected AxisAlignedBB calculateBoundingBoxCentered(double rangeHorizontal, double rangeVertical, double yOffset){
		return calculateBoundingBoxAt(xCoord + .5, yCoord + yOffset / 2, zCoord + .5, rangeHorizontal, rangeVertical);
	}
}