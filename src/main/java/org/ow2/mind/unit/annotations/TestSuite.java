package org.ow2.mind.unit.annotations;

import org.ow2.mind.adl.annotation.ADLAnnotationTarget;
import org.ow2.mind.annotation.Annotation;
import org.ow2.mind.annotation.AnnotationTarget;

public class TestSuite implements Annotation {
	
	private static final long serialVersionUID = 405236988057923551L;
	
	private static final AnnotationTarget[] ANNOTATION_TARGETS = { ADLAnnotationTarget.DEFINITION };
	
	public AnnotationTarget[] getAnnotationTargets() {
		return ANNOTATION_TARGETS;
	}

	public boolean isInherited() {
		return true;
	}

}
