package com.besuikerd.mirandacraft.lib.classifier;

import com.besuikerd.mirandacraft.lib.utils.IterableStringBuilder;
import com.besuikerd.mirandacraft.lib.utils.StringUtils;

import java.util.Arrays;

public class ClassifierArgumentTuple extends ClassifierArgument<ClassifierArgument[]>{

	public ClassifierArgumentTuple(String name, ClassifierArgument[] value, boolean equals) {
		super(name, value, equals);
	}
	
	@Override
	public <ARG, RET> RET visit(ClassifierVisitor<ARG, RET> visitor, ARG obj) {
		return visitor.visitArgumentTuple(visitor, this, obj);
	}
	
	@Override
	public String toString() {
		return StringUtils.toString(value, "(", ",", ")");
	}
	
	@Override
	public String getTypeDescription() {
		IterableStringBuilder<ClassifierArgument> builder = new IterableStringBuilder<ClassifierArgument>(value).left("(").right(")");
		for(ClassifierArgument cls : builder){
			builder.transform(ClassifierArgument.ARGUMENT_TYPE_NAMES.get(cls.getClass()));
		}
		return builder.toString();
	}
	
	public Integer getIntegerValue(int n){
		return ((Number) value[n].getValue()).intValue();
	}
	
	public Double getDoubleValue(int n){
		return ((Number) value[n].getValue()).doubleValue();
	}
	
	public String getStringValue(int n){
		return value[n].getValue().toString();
	}
	
	public ClassifierArgumentList getListValue(int n){
		return (ClassifierArgumentList) value[n].getValue();
	}
	
	public ClassifierArgumentTuple getTupleValue(int n){
		return (ClassifierArgumentTuple) value[n].getValue();
	}
}
