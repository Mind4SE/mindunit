package org.ow2.mind.unit.annotations;

import org.ow2.mind.annotation.Annotation;
import org.ow2.mind.annotation.AnnotationElement;
import org.ow2.mind.annotation.AnnotationTarget;
import org.ow2.mind.idl.annotation.IDLAnnotationTarget;

public class Test implements Annotation {
	
	private static final long serialVersionUID = 405236988057923551L;
	
	private static final AnnotationTarget[] ANNOTATION_TARGETS = { IDLAnnotationTarget.METHOD };
	
	@AnnotationElement(hasDefaultValue=true)
	public String value = null;
	
	public AnnotationTarget[] getAnnotationTargets() {
		return ANNOTATION_TARGETS;
	}

	public boolean isInherited() {
		return true;
	}

}
