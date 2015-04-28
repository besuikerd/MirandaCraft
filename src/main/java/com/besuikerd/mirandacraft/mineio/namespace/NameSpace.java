package com.besuikerd.mirandacraft.mineio.namespace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class NameSpace<A extends NamespaceEntry> {
	
	private String name;
	private Map<String, Stack<A>> entries;
	private Stack<Set<String>> scopedEntries;
	private int currentLevel;
	
	public NameSpace(String name) {
		this.name = name;
		this.entries = new HashMap<String, Stack<A>>();
		this.scopedEntries = new Stack<Set<String>>();
		this.currentLevel = -1;
	}
	
	public void openScope(){
		currentLevel++;
		scopedEntries.push(new HashSet<String>());
	}
	
	public Set<A> closeScope() throws InvalidScopeException{
		if(currentLevel < 0){
			throw new InvalidScopeException("no more scopes to close");
		}
		
		currentLevel--; 
		Set<A> removed = new HashSet<A>();
		for(String toRemove: scopedEntries.pop()){
			Stack<A> stack = entries.get(toRemove);
			removed.add(stack.pop());
			if(stack.isEmpty()){
				entries.remove(toRemove);
			}
		}
		return removed;
	}
	
	private void enter(String name, A entry, boolean force) throws InvalidScopeException, DuplicateNameException{
		if(currentLevel < 0){
			throw new InvalidScopeException("no open scope to enter name %s in", name);
		}
		Stack<A> stack = entries.get(name);
		if(stack == null){
			stack = new Stack<A>();
			entries.put(name, stack);
		} else if (!force && stack.peek().scopelevel == currentLevel){
			throw new DuplicateNameException(name);
		}
		scopedEntries.peek().add(name);
		entry.scopelevel = currentLevel;
		entry.name = name;
		stack.push(entry);
	}
	
	public void enter(String name, A entry) throws InvalidScopeException, DuplicateNameException{
		enter(name, entry, false);
	}
	
	public void forceEnter(String name, A entry) throws InvalidScopeException{
		try{
			enter(name, entry, true);
		} catch(DuplicateNameException e){
			//should not occur
		}
	}
	
	public A retrieve(String name) throws UnknownNameException{
		Stack<A> stack = entries.get(name);
		if(stack == null){
			throw new UnknownNameException(name);
		}
		A entry = stack.peek();
		if(!entry.isUsed){
			entry.isUsed = true;
		}
		return entry;
	}
	
	public String getName() {
		return name;
	}
}
