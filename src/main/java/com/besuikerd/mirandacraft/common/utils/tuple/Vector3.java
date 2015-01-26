package com.besuikerd.mirandacraft.common.utils.tuple;

public class Vector3 extends Tuple3<Integer, Integer, Integer>{
	public final int x;
	public final int y;
	public final int z;
	public Vector3(Integer _1, Integer _2, Integer _3) {
		super(_1, _2, _3);
		this.x = _1;
		this.y = _2;
		this.z = _3;
	}
}
