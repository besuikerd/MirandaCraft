package com.besuikerd.mirandacraft.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.besuikerd.mirandacraft.common.tileentity.TileEntityShield;

public class BlockShield extends BlockBesu{

	protected BlockShield() {
		super(Material.piston);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityShield();
	}

}
