package com.besuikerd.mirandacraft.lib.utils;

public class Profiler {
	private long startTime;
	
	public Profiler start(){
		this.startTime = getTime();
		return this;
	}
	
	public long getTimePassed(){
		return getTime() - startTime;
	}
	
	private long getTime(){
		return System.nanoTime();
	}
	
	@Override
	public String toString() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		return stack.length > 6 ? String.format("Total time: %dns, Caller: %s", getTimePassed(), stack[5]) : String.format("Total time: %d", getTime());
	}
}
