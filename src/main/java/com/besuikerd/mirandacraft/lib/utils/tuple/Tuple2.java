package com.besuikerd.mirandacraft.lib.utils.tuple;

public class Tuple2<A,B> {
	public final A _1;
	public final B _2;
	
	public Tuple2(A _1, B _2) {
		this._1 = _1;
		this._2 = _2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Tuple2){
			Tuple2 tuple = (Tuple2) obj;
			return tuple._1.equals(_1) && tuple._2.equals(_2);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s)", _1, _2);
	}
}
