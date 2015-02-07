package com.besuikerd.mirandacraft.mineio.namespace;

public class UnknownNameException extends NamespaceException{

	public UnknownNameException() {
		super();
	}

	public UnknownNameException(String message, Object... args) {
		super(message, args);
	}

	public UnknownNameException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownNameException(String message) {
		super(message);
	}

	public UnknownNameException(Throwable cause) {
		super(cause);
	}
	
}
