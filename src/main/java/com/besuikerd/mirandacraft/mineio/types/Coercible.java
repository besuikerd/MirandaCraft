package com.besuikerd.mirandacraft.mineio.types;

public interface Coercible {
	/**
	 * Coerces this Coercible to a Type of the given kind. If coercion fails, null is returned
	 * @param kind
	 * @return
	 */
	public Type coerceTo(TypeKind kind);
}