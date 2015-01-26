package com.besuikerd.mirandacraft.common.block;

import com.besuikerd.mirandacraft.MirandaCraft;
import com.besuikerd.mirandacraft.client.gui.GuiHandler;
import com.besuikerd.mirandacraft.client.gui.texture.TextureLocation;
import com.besuikerd.mirandacraft.common.tileentity.IDirectioned;
import com.besuikerd.mirandacraft.common.tileentity.TileEntityEntityCounter;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockEntityCounter extends BlockMachine{

	private IIcon iconFront;
	private IIcon iconBack;
	private IIcon iconSide;
	private IIcon iconTopBottom;
	
	public BlockEntityCounter() {
		super(Material.grass);
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityEntityCounter();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int meta, float posX, float posY, float posZ) {
		
		if(!super.onBlockActivated(world, x, y, z, player, meta, posX, posY, posZ) && !player.isSneaking()){
			player.openGui(MirandaCraft.instance, GuiHandler.GuiIdentifier.ENTITY_COUNTER.ordinal(), world, x, y, z);
			return true;
		}
		return false;		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		this.iconFront = register.registerIcon(TextureLocation.block("entity_counter_front"));
		this.iconBack = register.registerIcon(TextureLocation.block("entity_counter_back"));
		this.iconTopBottom = register.registerIcon(TextureLocation.block("entity_counter_top_bottom"));
		this.iconSide = register.registerIcon(TextureLocation.block("entity_counter_side"));
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null && tile instanceof IDirectioned){
			IDirectioned dir = (IDirectioned) tile;
			return dir.getDirection() == side ? iconFront : dir.getDirection() == ForgeDirection.OPPOSITES[side] ? iconBack : side == ForgeDirection.DOWN.ordinal() || side == ForgeDirection.UP.ordinal() ? iconTopBottom : iconSide;
		}
		return super.getIcon(world, x, y, z, side);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		int dir = 3;
		return dir == side ? iconFront : dir == ForgeDirection.OPPOSITES[side] ? iconBack : side == ForgeDirection.DOWN.ordinal() || side == ForgeDirection.UP.ordinal() ? iconTopBottom : iconSide;
	}
	
	@Override
	public boolean canProvidePower() {
		return true;
	}
}
