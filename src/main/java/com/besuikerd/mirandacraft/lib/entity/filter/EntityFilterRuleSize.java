package com.besuikerd.mirandacraft.lib.entity.filter;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgument;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentNumber;
import com.besuikerd.mirandacraft.lib.classifier.ClassifierArgumentTuple;
import com.besuikerd.mirandacraft.lib.utils.tuple.Vector3D;

public class EntityFilterRuleSize extends EntityFilterRuleTuple{

	public EntityFilterRuleSize() {
		super(ClassifierArgumentNumber.class, ClassifierArgumentNumber.class, ClassifierArgumentNumber.class, ClassifierArgumentNumber.class, ClassifierArgumentNumber.class, ClassifierArgumentNumber.class);
	}
	
	@Override
	public boolean validate(Entity entity, ClassifierArgumentTuple argument) {
		AxisAlignedBB box = entity.boundingBox;
		
		Vector3D size = new Vector3D(box.maxX - box.minX, box.maxY - box.minY, box.maxZ - box.minZ);
		return 
			box == null ||
			size.x >= argument.getDoubleValue(0) &&
			size.x <= argument.getDoubleValue(3) &&
			size.y >= argument.getDoubleValue(1) &&
			size.y <= argument.getDoubleValue(4) &&
			size.z >= argument.getDoubleValue(2) &&
			size.z <= argument.getDoubleValue(5)
			;
	}

}
