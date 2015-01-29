package com.besuikerd.mirandacraft.lib.utils;

import java.util.Iterator;
import java.util.Map;

public class StringUtils {
	public static String toString(Map<?, ?> map){
		if(map.isEmpty()){
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		boolean first = true;
		for(Map.Entry<?, ?> entry : map.entrySet()){
			if(first){
				builder.append(entry.getKey() + "=" + entry.getValue());
				first = false;
			} else{
				builder.append(", " + entry.getKey() + "=" + entry.getValue());
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
	public static String toString(Iterable<?> iterable){
		return toString(iterable, "[", ",", "]");
	}
	
	public static String toString(Iterable<?> iterable, String left, String right){
		return toString(iterable, left, ",", right);
	}
	
	public static String toString(Iterable<?> iterable, String left, String sep, String right){
		Iterator<?> iterator = iterable.iterator();
		StringBuilder result = new StringBuilder(left);
		boolean first = true;
		while(iterator.hasNext()){
			if(first){
				first = false;
				result.append(iterator.next());
			} else{
				result.append(sep + iterator.next());
			}
		}
		result.append(right);
		return result.toString();
	}
	
	public static <E> String toString(E[] array){
		return toString(array, "[", ",", "]");
	}
	
	public static <E> String toString(E[] array, String left, String right){
		return toString(array, left, ",", right);
	}
	
	public static <E> String toString(E[] array, String left, String sep, String right){
		StringBuilder result = new StringBuilder(left);
		boolean first = true;
		for(E e : array){
			if(first){
				first = false;
				result.append(e);
			} else{
				result.append(sep + e);
			}
		}
		result.append(right);
		return result.toString();
	}
	
}
