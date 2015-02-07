package com.besuikerd.mirandacraft.common.inventory;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class InventoryHelper {
	public static void dropInventoryContents(World world, Random random, int x, int y, int z, IInventory inventory){
         for (int i = 0; i < inventory.getSizeInventory(); ++i)
         {
             ItemStack itemstack = inventory.getStackInSlot(i);

             if (itemstack != null)
             {
                 float f = random.nextFloat() * 0.8F + 0.1F;
                 float f1 = random.nextFloat() * 0.8F + 0.1F;
                 float f2 = random.nextFloat() * 0.8F + 0.1F;

                 while (itemstack.stackSize > 0)
                 {
                     int j1 = random.nextInt(21) + 10;

                     if (j1 > itemstack.stackSize)
                     {
                         j1 = itemstack.stackSize;
                     }

                     itemstack.stackSize -= j1;
                     EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                     if (itemstack.hasTagCompound())
                     {
                         entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                     }

                     float f3 = 0.05F;
                     entityitem.motionX = (double)((float)random.nextGaussian() * f3);
                     entityitem.motionY = (double)((float)random.nextGaussian() * f3 + 0.2F);
                     entityitem.motionZ = (double)((float)random.nextGaussian() * f3);
                     world.spawnEntityInWorld(entityitem);
                 }
             }
         }
	}
}
