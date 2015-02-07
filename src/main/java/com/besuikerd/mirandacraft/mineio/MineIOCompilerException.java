package com.besuikerd.mirandacraft.mineio;

public class MineIOCompilerException extends Exception{

	public MineIOCompilerException(){
		
	}
	
	public MineIOCompilerException(String message, Object... args) {
		this(String.format(message, args));
	}

	public MineIOCompilerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MineIOCompilerException(String message, Throwable cause) {
		super(message, cause);
	}

	public MineIOCompilerException(String message) {
		super(message);
	}

	public MineIOCompilerException(Throwable cause) {
		super(cause);
	}
}
