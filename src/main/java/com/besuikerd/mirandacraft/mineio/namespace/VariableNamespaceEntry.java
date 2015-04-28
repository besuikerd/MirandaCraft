package com.besuikerd.mirandacraft.mineio.namespace;

import com.besuikerd.mirandacraft.mineio.parser.MineIOParser.VariableContext;
import com.besuikerd.mirandacraft.mineio.types.Type;

public class VariableNamespaceEntry extends NamespaceEntry{
	protected VariableContext declarationContext;
	protected Type type;
	
	public VariableNamespaceEntry(VariableContext declarationContext, Type type) {
		this.declarationContext = declarationContext;
		declarationContext.namespaceEntry = this;
		this.type = type;
	}
	
	public VariableContext getDeclarationContext() {
		return declarationContext;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
}
