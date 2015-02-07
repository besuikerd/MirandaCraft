package com.besuikerd.mirandacraft.mineio.namespace;

public class DuplicateNameException extends NamespaceException{

	public DuplicateNameException() {
		super();
	}

	public DuplicateNameException(String message, Object... args) {
		super(message, args);
	}

	public DuplicateNameException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateNameException(String message) {
		super(message);
	}

	public DuplicateNameException(Throwable cause) {
		super(cause);
	}

}
