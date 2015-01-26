package com.besuikerd.mirandacraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.besuikerd.mirandacraft.common.item.Wrenches;
import com.besuikerd.mirandacraft.common.tileentity.IDirectioned;
import com.besuikerd.mirandacraft.common.tileentity.IRedstoneProvider;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityBesu;

public abstract class BlockBesu extends Block implements ITileEntityProvider {

	protected BlockBesu(Material material) {
		super(material);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		super.onBlockPlacedBy(world, x, y, z, entity, stack);
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null){
			if(tile instanceof IDirectioned){
				IDirectioned dir = (IDirectioned) tile;
				int quadrant = ((int) Math.floor(entity.rotationYaw * 4.0F / 360.0F + 0.5D)) & 3;
				
				if(dir.usesYAxis()){
					quadrant = entity.rotationPitch > 60 ? 4 : entity.rotationPitch < -60 ? 5 : quadrant;
				}
				int direction = 0;
				switch(quadrant){
				case 0:
					direction = 2;
					break;
				case 1:
					direction = 5;
					break;
				case 2:
					direction = 3;
					break;
				case 3:
					direction = 4;
					break;
				case 4:
					direction = 1;
					break;
				case 5:
					direction = 0;
					break;
				}
				dir.setDirection(dir.hasFlippedPlacement() ? ForgeDirection.OPPOSITES[direction] : ForgeDirection.values()[direction].ordinal());
			}
			
			if(tile instanceof TileEntityBesu) {
				((TileEntityBesu) tile).onTileEntityPlacedBy(entity, stack);
			}
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null && tile instanceof TileEntityBesu) {
			TileEntityBesu tileBesu = (TileEntityBesu) tile;
			tileBesu.onRemoveTileEntity(block, meta);
			world.removeTileEntity(x, y, z);
			tileBesu.onTileEntityRemoved(block, meta);
		} else {
			super.breakBlock(world, x, y, z, block, meta);
		}
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	//method overrides to prettify names
	@Override
	public void registerBlockIcons(IIconRegister register) {
		super.registerBlockIcons(register);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return super.getIcon(side, meta);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float posX, float posY, float posZ) {
		return super.onBlockActivated(world, x, y, z, player, meta, posX, posY, posZ);
	}
	
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x,int y, int z, int side) {
		return super.getIcon(world, x, y, z, side);
	}
	
	@Override
	public boolean isNormalCube() {
		return false;
	}
	
	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		if(canProvidePower()){
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile != null && tile instanceof IRedstoneProvider){
				return ((IRedstoneProvider) tile).getRedstoneStrength();
			}
		}
		return 0;
	}
}
