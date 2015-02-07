package com.besuikerd.mirandacraft.lib.classifier;

import java.util.Map;

import com.besuikerd.mirandacraft.lib.utils.IterableStringBuilder;
import com.besuikerd.mirandacraft.lib.utils.StringUtils;

public class ClassifierActualRule extends ClassifierRule{
	private String type;
	private Map<String, ClassifierArgument> arguments;
	
	public ClassifierActualRule(String type, Map<String, ClassifierArgument> arguments) {
		this.type = type;
		this.arguments = arguments;
	}
	
	public Map<String, ClassifierArgument> getArguments() {
		return arguments;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitActualRule(visitor, this, obj);
	}
	
	@Override
	public String toString() {
		IterableStringBuilder<Map.Entry<String, ClassifierArgument>> builder = new IterableStringBuilder<Map.Entry<String,ClassifierArgument>>(arguments.entrySet());
		for(Map.Entry<String, ClassifierArgument> entry : builder){
			builder.transform(entry.getKey() + (entry.getValue().isEquals() ? " = " : " != ") + entry.getValue());
		}
		return String.format("@%s%s", type, builder);
	}
}
