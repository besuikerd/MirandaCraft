package com.besuikerd.mirandacraft.common.block;

import com.besuikerd.mirandacraft.common.item.Wrenches;
import com.besuikerd.mirandacraft.common.tileentity.IDirectioned;
import com.besuikerd.mirandacraft.common.tileentity.IDismantleable;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class BlockMachine extends BlockBesu{

	protected BlockMachine(Material material) {
		super(material);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int meta, float posX, float posY, float posZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(Wrenches.isWrench(player.getCurrentEquippedItem())){
			if(!player.isSneaking() && tile instanceof IDirectioned){
				IDirectioned dir = (IDirectioned) tile;
				if(dir.isWrenchable()){
					switch(ForgeDirection.values()[dir.getDirection()]){
					case UP:
						dir.setDirection(ForgeDirection.DOWN.ordinal());
						break;
					case DOWN: 
						dir.setDirection(ForgeDirection.NORTH.ordinal());
						break;
					case NORTH: 
						dir.setDirection(ForgeDirection.EAST.ordinal());
						break;
					case EAST:
						dir.setDirection(ForgeDirection.SOUTH.ordinal());
						break;
					case SOUTH:
						dir.setDirection(ForgeDirection.WEST.ordinal());
						break;
					case WEST:
						dir.setDirection((dir.usesYAxis() ? ForgeDirection.UP : ForgeDirection.NORTH).ordinal());
						break;
					default:
						break;
					}
					return true;
				}
			} else if(player.isSneaking() && tile instanceof IDismantleable && !world.isRemote){
				IDismantleable dismantleable = (IDismantleable) tile;
				System.out.println("dismantling");
				world.setBlock(x, y, z, Blocks.air);
				world.notifyBlockChange(x, y, z, Blocks.air);
				ItemStack stack = new ItemStack(this);
				stack.setTagCompound(dismantleable.getDismantledNBT());
				world.spawnEntityInWorld(new EntityItem(world, x, y, z, stack));
				return true;
			}
		}
		return super.onBlockActivated(world, x, y, z, player, meta, posX, posY, posZ);
	}
	
}
