package com.besuikerd.mirandacraft.mineio.namespace;

public class NamespaceEntry {
	protected int scopelevel;
	protected boolean isUsed;
	protected String name;
	
	public int getScopeLevel(){
		return scopelevel;
	}
	
	public boolean isUsed(){
		return isUsed;
	}
	
	public String getName() {
		return name;
	}
}
