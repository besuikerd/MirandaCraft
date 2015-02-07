package com.besuikerd.mirandacraft.mineio.namespace;

import com.besuikerd.mirandacraft.mineio.MineIOCompilerException;

public class NamespaceException extends MineIOCompilerException{

	public NamespaceException() {
		super();
	}
	
		public NamespaceException(String message, Object... args) {
		super(message, args);
	}

	public NamespaceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NamespaceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NamespaceException(String message) {
		super(message);
	}

	public NamespaceException(Throwable cause) {
		super(cause);
	}

}
