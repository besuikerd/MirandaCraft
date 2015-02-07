package com.besuikerd.mirandacraft.lib.entity.filter;

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
import scala.collection.immutable.HashMap;

import com.besuikerd.mirandacraft.lib.classifier.AbstractClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierActualRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierAndRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierOrRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class EntityFilterVisitor extends AbstractClassifierVisitor<Entity, Boolean>{
	
	private Map<String, EntityFilterRule> filters;
	private Map<String, Class<?>> types;
	private Map<Class<?>, String> inverseTypes;
	
	private static final Map<String, EntityFilterRule> DEFAULT_FILTERS;
	private static final Map<String, Class<?>> DEFAULT_TYPES;
	
	
	static{
		DEFAULT_FILTERS = new ImmutableMap.Builder<String, EntityFilterRule>()
		.put("name", new EntityFilterRuleName())
		.put("position", new EntityFilterRulePosition())
		.put("size", new EntityFilterRuleSize())
		.put("adult", new EntityFilterRuleAdult())
		.put("health", new EntityFilterRuleHealth())
		.put("breedable", new EntityFilterRuleBreedable())
		.build();
			
		DEFAULT_TYPES = new ImmutableMap.Builder<String, Class<?>>()
		.put("e", Entity.class)
		.put("entity", Entity.class)
		.put("all", Entity.class)
		.put("any", Entity.class)
		.put("a", Entity.class)
		.put("p", EntityPlayer.class)
		.put("player", EntityPlayer.class)
		.put("l", EntityLiving.class)
		.put("living", EntityLiving.class)
		.put("projectile", IProjectile.class)
		.put("xp", EntityXPOrb.class)
		.put("hanging", EntityHanging.class)
		.put("i", EntityItem.class)
		.put("item", EntityItem.class)
		.put("throwable", EntityThrowable.class)
		
		.put("animal", EntityAnimal.class)
		.put("cow", EntityCow.class)
		.put("mooshroom", EntityMooshroom.class)
		.put("sheep", EntitySheep.class)
		.put("chicken", EntityChicken.class)
		.put("pig", EntityPig.class)
		.put("horse", EntityHorse.class)
		.put("ocelot", EntityOcelot.class)
		.put("wolf", EntityWolf.class)
		
		.put("bat", EntityBat.class)
		.put("squid", EntitySquid.class)
		
		.put("minecart", EntityMinecart.class)
		.put("boat", EntityBoat.class)
		
		.put("golem", EntityGolem.class)
		.put("villager", EntityVillager.class)
		
		.put("mob", EntityMob.class)
		.put("zombie", EntityZombie.class)
		.put("creeper", EntityCreeper.class)
		.put("skeleton", EntitySkeleton.class)
		.put("spider", EntitySpider.class)
		.put("enderman", EntityEnderman.class)
		.put("silverfish", EntitySilverfish.class)
		.put("blaze", EntityBlaze.class)
		.put("cavespider", EntityCaveSpider.class)
		.put("ghast", EntityGhast.class)
		.put("slime", EntitySlime.class)
		.put("pigman", EntityPigZombie.class)
		.put("witch", EntityWitch.class)
		.put("wither", EntityWither.class)
		.put("magmacube", EntityMagmaCube.class)
		.put("enderdragon", EntityDragon.class)
		.build();
	}
	
	
	
	public EntityFilterVisitor(Map<String, EntityFilterRule> filters, Map<String, Class<?>> types) {
		this.filters = filters;
		this.types = types;
	}
	
	public EntityFilterVisitor() {
		this(Maps.newHashMap(DEFAULT_FILTERS), Maps.newHashMap(DEFAULT_TYPES));
	}
	
	@Override
	public Boolean visit(ClassifierVisitor<Entity, Boolean> visitor, Entity obj) {
		return types.containsValue(obj.getClass());
	}
	
	@Override
	public Boolean visitActualRule(ClassifierVisitor<Entity, Boolean> visitor,
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
	public Boolean visitAndRule(ClassifierVisitor<Entity, Boolean> visitor,
			ClassifierAndRule rule, Entity obj) {
		return rule.getLhs().visit(visitor, obj) && rule.getRhs().visit(visitor, obj);
	}
	
	@Override
	public Boolean visitOrRule(ClassifierVisitor<Entity, Boolean> visitor,
			ClassifierOrRule rule, Entity obj) {
		return rule.getLhs().visit(visitor, obj) || rule.getRhs().visit(visitor, obj);
	}
}
