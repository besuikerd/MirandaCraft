package com.besuikerd.mirandacraft.lib.entity.filter;

import java.util.Map;

import com.besuikerd.mirandacraft.lib.classifier.AbstractClassifierVisitor;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierActualRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierAndRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierOrRule;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierVisitor;

public class EntityFilterValidator extends AbstractClassifierVisitor<Void, String>{
	private EntityFilterVisitor filterVisitor;

	public EntityFilterValidator(EntityFilterVisitor filterVisitor) {
		this.filterVisitor = filterVisitor;
	}
	
	@Override
	public String visitAndRule(ClassifierVisitor<Void, String> visitor, ClassifierAndRule rule, Void obj) {
		String lhs = rule.getLhs().visit(visitor, obj);
		if(lhs == null){
			return rule.getRhs().visit(visitor, obj);
		}
		return lhs;
	}
	
	@Override
	public String visitOrRule(ClassifierVisitor<Void, String> visitor, ClassifierOrRule rule, Void obj) {
		String lhs = rule.getLhs().visit(visitor, obj);
		if(lhs == null){
			return rule.getRhs().visit(visitor, obj);
		}
		return lhs;
	}
	
	@Override
	public String visitActualRule(ClassifierVisitor<Void, String> visitor, ClassifierActualRule rule, Void obj) {
		if(!filterVisitor.getTypes().containsKey(rule.getType())) {
			return String.format("[@%s]: Unknown entity type", rule.getType());
		}
		for(Map.Entry<String, ClassifierArgument> entry : rule.getArguments().entrySet()){
			if(!filterVisitor.getFilters().containsKey(entry.getKey())){
				return String.format("[%s]: Unknown argument", entry.getKey());
			} else{
				EntityFilterRule filter = filterVisitor.getFilters().get(entry.getKey());
				
				if(!filter.isValidArgument(entry.getValue())){
					return String.format("[%s]: Invalid type, expected: <%s>, got: <%s>", entry.getKey(), filter.getExpectedArgumentDescription(), entry.getValue().getTypeDescription());
				}
			}
			
		}
		return null;
	}
}
