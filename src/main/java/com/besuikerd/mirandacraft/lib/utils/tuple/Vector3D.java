package com.besuikerd.mirandacraft.lib.utils.tuple;

public class Vector3D extends Tuple3<Double, Double, Double>{
	public final double x;
	public final double y;
	public final double z;
	
	public Vector3D(Double _1, Double _2, Double _3) {
		super(_1, _2, _3);
		this.x = _1;
		this.y = _2;
		this.z = _3;
	}
}
