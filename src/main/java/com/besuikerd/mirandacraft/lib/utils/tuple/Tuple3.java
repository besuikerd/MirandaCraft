package com.besuikerd.mirandacraft.lib.utils.tuple;
public class Tuple3<A, B, C> {
	public final A _1;
	public final B _2;
	public final C _3;
	
	public Tuple3(A _1, B _2, C _3) {
		this._1 = _1;
		this._2 = _2;
		this._3 = _3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Tuple3){
			Tuple3 tuple = (Tuple3) obj;
			return tuple._1.equals(_1) && tuple._2.equals(_2) && tuple._3.equals(_3);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s, %s)", _1, _2, _3);
	}
}
