package com.besuikerd.mirandacraft.lib.entity.filter;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentTuple;
import com.besuikerd.mirandacraft.lib.utils.IterableStringBuilder;

public abstract class EntityFilterRuleTuple extends AbstractEntityFilterRule<ClassifierArgumentTuple>{

	private Class<? extends ClassifierArgument>[] tupleTypes;
	
	public EntityFilterRuleTuple(Class<? extends ClassifierArgument>... classes) {
		super(ClassifierArgumentTuple.class);
		this.tupleTypes = classes;
	}
	
	@Override
	public boolean isValidArgument(ClassifierArgument arg) {
		if(super.isValidArgument(arg)){
			ClassifierArgumentTuple tuple = asValidArgument(arg);
			if(tuple.getValue().length != tupleTypes.length){
				return false;
			}
			for(int i = 0 ; i < tuple.getValue().length ; i++){
				if(!tupleTypes[i].isInstance(tuple.getValue()[i])){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String getExpectedArgumentDescription() {
		IterableStringBuilder<Class<? extends ClassifierArgument>> builder = new IterableStringBuilder<Class<? extends ClassifierArgument>>(tupleTypes).left("(").right(")");
		for(Class<? extends ClassifierArgument> cls : builder){
			builder.transform(ClassifierArgument.ARGUMENT_TYPE_NAMES.get(cls));
		}
		return builder.toString();
	}
}
