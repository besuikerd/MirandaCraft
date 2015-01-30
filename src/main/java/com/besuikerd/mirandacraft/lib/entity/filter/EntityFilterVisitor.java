package com.besuikerd.mirandacraft.lib.entity.filter;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;

import com.besuikerd.mirandacraft.lib.classifier.AbstractClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierActualRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierAndRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierOrRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;

public class EntityFilterVisitor extends AbstractClassifierVisitor<Boolean, Entity>{
	
	private Map<String, EntityFilterRule> filters;
	private Map<String, Class<?>> types;
	
	
	public static final Map<String, EntityFilterRule> DEFAULT_FILTERS;
	public static final Map<String, Class<?>> DEFAULT_TYPES;
	
	static{
		DEFAULT_FILTERS = new HashMap<String, EntityFilterRule>();
		DEFAULT_FILTERS.put("name", new EntityFilterRuleName());
		DEFAULT_FILTERS.put("position", new EntityFilterRulePosition());
		DEFAULT_FILTERS.put("size", new EntityFilterRuleSize());
		DEFAULT_FILTERS.put("adult", new EntityFilterRuleAdult());
		DEFAULT_FILTERS.put("health", new EntityFilterRuleHealth());
		DEFAULT_FILTERS.put("breedable", new EntityFilterRuleBreedable());
		
		
		DEFAULT_TYPES = new HashMap<String, Class<?>>();
		DEFAULT_TYPES.put("e", Entity.class);
		DEFAULT_TYPES.put("entity", Entity.class);
		DEFAULT_TYPES.put("all", Entity.class);
		DEFAULT_TYPES.put("any", Entity.class);
		DEFAULT_TYPES.put("a", Entity.class);
		DEFAULT_TYPES.put("p", EntityPlayer.class);
		DEFAULT_TYPES.put("player", EntityPlayer.class);
		DEFAULT_TYPES.put("l", EntityLiving.class);
		DEFAULT_TYPES.put("living", EntityLiving.class);
		DEFAULT_TYPES.put("projectile", IProjectile.class);
		DEFAULT_TYPES.put("xp", EntityXPOrb.class);
		DEFAULT_TYPES.put("hanging", EntityHanging.class);
		DEFAULT_TYPES.put("i", EntityItem.class);
		DEFAULT_TYPES.put("item", EntityItem.class);
		DEFAULT_TYPES.put("throwable", EntityThrowable.class);
		
		DEFAULT_TYPES.put("animal", EntityAnimal.class);
		DEFAULT_TYPES.put("cow", EntityCow.class);
		DEFAULT_TYPES.put("mooshroom", EntityMooshroom.class);
		DEFAULT_TYPES.put("sheep", EntitySheep.class);
		DEFAULT_TYPES.put("chicken", EntityChicken.class);
		DEFAULT_TYPES.put("pig", EntityPig.class);
		DEFAULT_TYPES.put("horse", EntityHorse.class);
		DEFAULT_TYPES.put("ocelot", EntityOcelot.class);
		DEFAULT_TYPES.put("wolf", EntityWolf.class);
		
		DEFAULT_TYPES.put("bat", EntityBat.class);
		DEFAULT_TYPES.put("squid", EntitySquid.class);
		
		DEFAULT_TYPES.put("minecart", EntityMinecart.class);
		DEFAULT_TYPES.put("boat", EntityBoat.class);
		
		DEFAULT_TYPES.put("golem", EntityGolem.class);
		DEFAULT_TYPES.put("villager", EntityVillager.class);
		
		DEFAULT_TYPES.put("mob", EntityMob.class);
		DEFAULT_TYPES.put("zombie", EntityZombie.class);
		DEFAULT_TYPES.put("creeper", EntityCreeper.class);
		DEFAULT_TYPES.put("skeleton", EntitySkeleton.class);
		DEFAULT_TYPES.put("spider", EntitySpider.class);
		DEFAULT_TYPES.put("enderman", EntityEnderman.class);
		DEFAULT_TYPES.put("silverfish", EntitySilverfish.class);
		DEFAULT_TYPES.put("blaze", EntityBlaze.class);
		DEFAULT_TYPES.put("cavespider", EntityCaveSpider.class);
		DEFAULT_TYPES.put("ghast", EntityGhast.class);
		DEFAULT_TYPES.put("slime", EntitySlime.class);
		DEFAULT_TYPES.put("pigman", EntityPigZombie.class);
		DEFAULT_TYPES.put("witch", EntityWitch.class);
		DEFAULT_TYPES.put("wither", EntityWither.class);
		DEFAULT_TYPES.put("magmacube", EntityMagmaCube.class);
		DEFAULT_TYPES.put("enderdragon", EntityDragon.class);
		
	}
	
	
	
	public EntityFilterVisitor(Map<String, EntityFilterRule> filters, Map<String, Class<?>> types) {
		this.filters = filters;
		this.types = types;
	}
	
	public EntityFilterVisitor() {
		this(DEFAULT_FILTERS, DEFAULT_TYPES);
	}
	
	@Override
	public Boolean visitActualRule(ClassifierVisitor<Boolean, Entity> visitor,
			ClassifierActualRule rule, Entity obj) {
		if(!types.containsKey(rule.getType()) || !types.get(rule.getType()).isInstance(obj)){
			return false;
		}
		
		for(Map.Entry<String, ClassifierArgument> entry : rule.getArguments().entrySet()){
			EntityFilterRule filter = filters.get(entry.getKey());
			if(filter == null || !filter.isValidArgument(entry.getValue())){
				return false;
			}
			boolean pass = filter.validate(obj, filter.asValidArgument(entry.getValue()));
			
			if(!pass && entry.getValue().isEquals() || pass && !entry.getValue().isEquals()){
				return false;
			}
		}
		return true;
	}
	
	public Map<String, EntityFilterRule> getFilters() {
		return filters;
	}
	
	public Map<String, Class<?>> getTypes() {
		return types;
	}
	
	@Override
	public Boolean visitAndRule(ClassifierVisitor<Boolean, Entity> visitor,
			ClassifierAndRule rule, Entity obj) {
		return rule.getLhs().visit(visitor, obj) && rule.getRhs().visit(visitor, obj);
	}
	
	@Override
	public Boolean visitOrRule(ClassifierVisitor<Boolean, Entity> visitor,
			ClassifierOrRule rule, Entity obj) {
		return rule.getLhs().visit(visitor, obj) || rule.getRhs().visit(visitor, obj);
	}
}
