package com.besuikerd.mirandacraft.lib.entity.filter;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;

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
		
		DEFAULT_TYPES = new HashMap<String, Class<?>>();
		DEFAULT_TYPES.put("e", Entity.class);
		DEFAULT_TYPES.put("entity", Entity.class);
		DEFAULT_TYPES.put("all", Entity.class);
		DEFAULT_TYPES.put("a", Entity.class);
		DEFAULT_TYPES.put("p", EntityPlayer.class);
		DEFAULT_TYPES.put("player", EntityPlayer.class);
		DEFAULT_TYPES.put("l", EntityLiving.class);
		DEFAULT_TYPES.put("projectile", IProjectile.class);
		DEFAULT_TYPES.put("xp", EntityXPOrb.class);
		DEFAULT_TYPES.put("hanging", EntityHanging.class);
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
