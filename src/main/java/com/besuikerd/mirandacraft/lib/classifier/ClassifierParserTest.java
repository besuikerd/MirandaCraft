package com.besuikerd.mirandacraft.lib.classifier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityCow;

import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterValidator;
import com.besuikerd.mirandacraft.lib.entity.filter.EntityFilterVisitor;

public class ClassifierParserTest {
	
	public static void main(String[] args){
		new ClassifierParserTest().run();
	}
	
	private ClassifierParser parser = new ClassifierParser();
	
	public void run(){
		Entity xp = new EntityXPOrb(null);
		Entity cow = new EntityCow(null);
		validateEntity("@xp[position=(1,2,3), size=(0,0,0, 2, 2.1, 3.1)]&&@p", cow);
		
		System.out.println(parseSafe("@e[name=\"Bier\", int=293, tuple=(1,2,[])]"));
	}
	
	private ClassifierRule parseSafe(String input){
		try{
			return parser.parse(input);
		} catch(ParseException e){
			fail("parsing %s failed: %s", input, e.getMessage());
			return null;
		}
	}
	
	private void validateEntity(String input, Entity entity){
		EntityFilterVisitor visitor = new EntityFilterVisitor();
		EntityFilterValidator validator = new EntityFilterValidator(visitor);
		ClassifierRule rule = parseSafe(input);
		if(rule != null){
			String error = rule.visit(validator, null);
			if(error != null){
				System.out.println("validation failed: " + error);
			} else{
				System.out.println(String.format("validated[%b]: %s", rule.visit(visitor, entity), entity));
			}
			
			
		}
	}
	
	private void assertEquals(Object a, Object b){
		if(!a.equals(b)){
			fail("%s == %s", a, b);
		}
	}
	
	private void fail(String msg, Object... args){
		System.out.println(String.format(msg, args));
	}
}
