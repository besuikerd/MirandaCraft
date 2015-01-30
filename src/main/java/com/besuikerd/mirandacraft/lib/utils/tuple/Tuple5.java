package com.besuikerd.mirandacraft.lib.utils.tuple;

public class Tuple5<A, B, C, D, E> {
	public final A _1;
	public final B _2;
	public final C _3;
	public final D _4;
	public final E _5;
	
	public Tuple5(A _1, B _2, C _3, D _4, E _5) {
		this._1 = _1;
		this._2 = _2;
		this._3 = _3;
		this._4 = _4;
		this._5 = _5;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Tuple5){
			Tuple5 tuple = (Tuple5) obj;
			return tuple._1.equals(_1) && tuple._2.equals(_2) && tuple._3.equals(_3) && tuple._4.equals(_4) && tuple._5.equals(_5);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s, %s, %s, %s)", _1, _2, _3, _4, _5);
	}
}
