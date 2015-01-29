package com.besuikerd.mirandacraft.lib.utils;

import java.util.Iterator;

public class ArrayIterable<A> implements Iterable<A>{
	private A[] array;
	
	public ArrayIterable(A[] array) {
		this.array = array;
	}

	public java.util.Iterator<A> iterator() {
		return new ArrayIterator();
	};
	
	private class ArrayIterator implements Iterator<A>{
		private int index;
		
		@Override
		public boolean hasNext() {
			return index < array.length;
		}
		
		@Override
		public A next() {
			return array[index++];
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
