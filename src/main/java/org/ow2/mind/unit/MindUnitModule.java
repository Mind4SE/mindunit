/**
 * Copyright (C) 2013 Schneider-Electric
 *
 * This file is part of "Mind Compiler" is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact: mind@ow2.org
 *
 * Authors: Stephane Seyvoz
 * Contributors: 
 */

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
