package com.besuikerd.mirandacraft.lib.utils;

import java.util.Iterator;

public class IterableStringBuilder<A> implements Iterable<A>{

	private IterableStringBuilder<A> instance;
	private Iterable<A> iterable;
	private String seperator;
	private String transform;
	private String left;
	private String right;
	private A value;
	private int index;
	private StringBuilder builder = new StringBuilder();
	
	public IterableStringBuilder(Iterable<A> iterable, String left, String sep, String right) {
		this.iterable = iterable;
		instance = this;
		this.left = left;
		this.seperator = sep;
		this.right = right;
		index = -1;
	}
	
	public IterableStringBuilder(Iterable<A> iterable) {
		this(iterable, "[", ", ", "]");
	}
	
	public IterableStringBuilder(A[] array) {
		this(new ArrayIterable<A>(array));
	}
	
	@Override
	public Iterator<A> iterator() {
		this.value = null;
		return new StringBuilderIterator();
	}
	
	public IterableStringBuilder<A> transform(String value){
		this.transform = value;
		return this;
	}
	
	public IterableStringBuilder<A> left(String left){
		this.left = left;
		return this;
	}
	
	public IterableStringBuilder<A> seperator(String seperator){
		this.seperator = seperator;
		return this;
	}
	
	public IterableStringBuilder<A> right(String right){
		this.right = right;
		return this;
	}
	
	public int getIndex() {
		return index;
	}
	
	public A getValue() {
		return value;
	}
	
	public void clear(){
		builder.setLength(0);
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
	
	
	private class StringBuilderIterator implements Iterator<A>{

		private Iterator<A> iterator = iterable.iterator();
		private boolean first;
		private boolean lastAppended;
		
		public StringBuilderIterator() {
			builder.append(left);
			first = true;
			lastAppended = false;
		}
		
		@Override
		public boolean hasNext() {
			
			boolean hasNext = iterator.hasNext(); 
			if(!hasNext){
				if(!lastAppended && value != null){
					builder.append((first ? "" : seperator) + (transform != null ? transform : value.toString()));
				}
				builder.append(right);
			}
			return hasNext;
		}

		@Override
		public A next() {
			index++;
			if(first){
				if(value != null){
					first = false;
					builder.append(transform == null ? getValue().toString() : transform);
				}
			} else{
				builder.append(seperator + (transform == null ? getValue().toString() : transform));
			}
			value = iterator.next();
			return value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
