package com.besuikerd.mirandacraft.lib.utils.tuple;

public class VectorTest {
	public static void main(String[] args){
		new VectorTest().run();
	}
	
	public void run(){
		
		Vector2D v1 = new Vector2D(438,3899);
		Vector2D v2 = new Vector2D(748,-4831);
		
		System.out.println(v1.distance(v2));
		System.out.println(v1.normalize());
		System.out.println(v2.normalize());
		
		
		
		
		Vector2D v3 = v1.flatten(v2);
		
		System.out.println(new Vector2D(v3.x * v1.distance(v2), v3.y * v1.distance(v2)));
	}
}
