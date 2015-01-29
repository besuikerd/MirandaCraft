package com.besuikerd.mirandacraft.lib.utils.tuple;

public class Vector4 extends Tuple4<Integer, Integer, Integer, Integer>{
	public final int x;
	public final int y;
	public final int z;
	public final int u;
	
	public Vector4(Integer _1, Integer _2, Integer _3, Integer _4) {
		super(_1, _2, _3, _4);
		this.x = _1;
		this.y = _2;
		this.z = _3;
		this.u = _4;
	}
}
