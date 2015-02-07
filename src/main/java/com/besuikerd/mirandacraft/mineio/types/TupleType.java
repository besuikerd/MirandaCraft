package com.besuikerd.mirandacraft.mineio.types;

import com.besuikerd.mirandacraft.lib.utils.IterableStringBuilder;
import com.besuikerd.mirandacraft.lib.utils.StringUtils;

public class TupleType extends Type{

	protected Type[] innerTypes;
	
	public TupleType(String value, Type... innerTypes) {
		super(TypeKind.TUPLE, value);
		this.innerTypes = innerTypes;
	}
	
	@Override
	public String getDescription() {
		IterableStringBuilder<Type> builder = new IterableStringBuilder<Type>(innerTypes).left("(").right(")");
		for(Type t : builder){
			builder.transform(t.getDescription());
		}
		return builder.toString();
	}
	
	public int getArity(){
		return innerTypes.length;
	}
	
	public Type[] getInnerTypes() {
		return innerTypes;
	}
	
	@Override
	public boolean matchesType(Type other) {
		if(other.getKind() == TypeKind.TUPLE && other instanceof TupleType){
			TupleType otherTuple = (TupleType) other;
			if(getArity() != otherTuple.getArity()){
				return false;
			} else{
				for(int i = 0 ; i < innerTypes.length ; i++){
					if(!innerTypes[i].matchesType(otherTuple.innerTypes[i])){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
