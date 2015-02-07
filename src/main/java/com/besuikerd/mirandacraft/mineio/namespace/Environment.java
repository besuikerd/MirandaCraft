package com.besuikerd.mirandacraft.mineio.namespace;

import com.besuikerd.mirandacraft.mineio.errorreport.CompilerMessageReporter;

public class Environment {
	public final NameSpace<VariableNamespaceEntry> variables;
	public final CompilerMessageReporter reporter;
	
	public Environment(NameSpace<VariableNamespaceEntry> variables, CompilerMessageReporter reporter) {
		this.variables = variables;
		this.reporter = reporter;
	}

	public Environment() {
		this(new NameSpace<VariableNamespaceEntry>("Variable"), new CompilerMessageReporter());
	}
}
