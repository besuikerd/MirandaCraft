package com.besuikerd.mirandacraft.lib.classifier;

import java.util.HashMap;
import java.util.Map;

public abstract class ClassifierArgument<A> implements ClassifierVisitable{
	
	protected String name;
	protected boolean equals;
	protected A value;
	
	public static final Map<Class<? extends ClassifierArgument>, String> ARGUMENT_TYPE_NAMES;
	static{
		ARGUMENT_TYPE_NAMES = new HashMap<Class<? extends ClassifierArgument>, String>();
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentDouble.class, "Number");
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentNumber.class, "Number");
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentInt.class, "Integer");
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentList.class, "List");
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentString.class, "String");
		ARGUMENT_TYPE_NAMES.put(ClassifierArgumentTuple.class, "Tuple");
	}
	
	public ClassifierArgument(String name, A value, boolean equals) {
		this.name = name;
		this.value = value;
		this.equals = equals;
	}
	
	public String getName() {
		return name;
	}
	
	public A getValue(){
		return value;
	}
	
	public boolean isEquals(){
		return equals;
	}
	
	public String getTypeDescription(){
		return ARGUMENT_TYPE_NAMES.get(getClass());
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
