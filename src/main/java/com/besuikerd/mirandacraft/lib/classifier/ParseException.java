package com.besuikerd.mirandacraft.lib.classifier;

public class ParseException extends Exception{
	public ParseException(String message) {
		super(message);
	}
	
	public ParseException(int charNum, String format, Object... args){
		this(charNum + ":" + String.format(format, args));
	}
}