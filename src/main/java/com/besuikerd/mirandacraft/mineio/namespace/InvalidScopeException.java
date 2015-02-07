package com.besuikerd.mirandacraft.mineio.namespace;

public class InvalidScopeException extends NamespaceException{

	public InvalidScopeException() {
		super();
	}
	
	public InvalidScopeException(String message, Object... args) {
		super(message, args);
	}

	public InvalidScopeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidScopeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidScopeException(String message) {
		super(message);
	}

	public InvalidScopeException(Throwable cause) {
		super(cause);
	}

}
