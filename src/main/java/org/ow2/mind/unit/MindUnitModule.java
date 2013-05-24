package org.ow2.mind.unit;
import org.ow2.mind.inject.AbstractMindModule;
import org.ow2.mind.unit.st.BasicSuiteSourceGenerator;
import org.ow2.mind.unit.st.SuiteSourceGenerator;

import com.google.inject.name.Names;

public class MindUnitModule extends AbstractMindModule {

	protected void configureSuiteSourceGenerator() {
		bind(SuiteSourceGenerator.class).to(BasicSuiteSourceGenerator.class);
	}

	protected void configureDefinitionIncSourceGenerator() {
	    bind(String.class).annotatedWith(
	        Names.named(BasicSuiteSourceGenerator.TEMPLATE_NAME)).toInstance(
	        		BasicSuiteSourceGenerator.DEFAULT_TEMPLATE);
	  }

}
