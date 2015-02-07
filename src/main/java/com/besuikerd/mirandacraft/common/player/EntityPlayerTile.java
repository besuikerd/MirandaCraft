package com.besuikerd.mirandacraft.common.player;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

import com.mojang.authlib.GameProfile;

public class EntityPlayerTile<A extends TileEntity> extends EntityPlayer{
	private static int counter = 0;
	
	protected A tile;
	
	public EntityPlayerTile(A tile, String name) {
		super(tile.getWorldObj(), new GameProfile(null, name));
	}

	@Override
	public void addChatMessage(IChatComponent p_145747_1_) {
		
	}

	@Override
	public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
		return false;
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return new ChunkCoordinates(tile.xCoord, tile.yCoord, tile.zCoord);
	}
	
	public void attackTargetEntityWithCurrentItem(Entity p_71059_1_)
    {
        if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent(this, p_71059_1_)))
        {
            return;
        }
        ItemStack stack = getCurrentEquippedItem();
        if (stack != null && stack.getItem().onLeftClickEntity(stack, this, p_71059_1_))
        {
            return;
        }
        if (p_71059_1_.canAttackWithItem())
        {
            if (!p_71059_1_.hitByEntity(this))
            {
                float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                int i = 0;
                float f1 = 0.0F;

                if (p_71059_1_ instanceof EntityLivingBase)
                {
                    f1 = EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)p_71059_1_);
                    i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)p_71059_1_);
                }

                if (this.isSprinting())
                {
                    ++i;
                }

                if (f > 0.0F || f1 > 0.0F)
                {
                    boolean flag = this.fallDistance > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && p_71059_1_ instanceof EntityLivingBase;

                    if (flag && f > 0.0F)
                    {
                        f *= 1.5F;
                    }

                    f += f1;
                    boolean flag1 = false;
                    int j = EnchantmentHelper.getFireAspectModifier(this);

                    if (p_71059_1_ instanceof EntityLivingBase && j > 0 && !p_71059_1_.isBurning())
                    {
                        flag1 = true;
                        p_71059_1_.setFire(1);
                    }

                    boolean flag2 = p_71059_1_.attackEntityFrom(DamageSource.causePlayerDamage(this), f);

                    if (flag2)
                    {
                        if (i > 0)
                        {
                            p_71059_1_.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                            this.motionX *= 0.6D;
                            this.motionZ *= 0.6D;
                            this.setSprinting(false);
                        }

                        if (flag)
                        {
                            this.onCriticalHit(p_71059_1_);
                        }

                        if (f1 > 0.0F)
                        {
                            this.onEnchantmentCritical(p_71059_1_);
                        }

                        if (f >= 18.0F)
                        {
                            this.triggerAchievement(AchievementList.overkill);
                        }

                        this.setLastAttacker(p_71059_1_);

                        if (p_71059_1_ instanceof EntityLivingBase)
                        {
                            EnchantmentHelper.func_151384_a((EntityLivingBase)p_71059_1_, this);
                        }

                        EnchantmentHelper.func_151385_b(this, p_71059_1_);
                        ItemStack itemstack = this.getCurrentEquippedItem();
                        Object object = p_71059_1_;

                        if (p_71059_1_ instanceof EntityDragonPart)
                        {
                            IEntityMultiPart ientitymultipart = ((EntityDragonPart)p_71059_1_).entityDragonObj;

                            if (ientitymultipart != null && ientitymultipart instanceof EntityLivingBase)
                            {
                                object = (EntityLivingBase)ientitymultipart;
                            }
                        }

                        if (itemstack != null && object instanceof EntityLivingBase)
                        {
                            itemstack.hitEntity((EntityLivingBase)object, this);

                            if (itemstack.stackSize <= 0)
                            {
                                this.destroyCurrentEquippedItem();
                            }
                        }

                        if (p_71059_1_ instanceof EntityLivingBase)
                        {
                            this.addStat(StatList.damageDealtStat, Math.round(f * 10.0F));

                            if (j > 0)
                            {
                                p_71059_1_.setFire(j * 4);
                            }
                        }

                        this.addExhaustion(0.3F);
                    }
                    else if (flag1)
                    {
                        p_71059_1_.extinguish();
                    }
                }
            }
        }
    }
}
