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

package org.ow2.mind.unit.model;

public class Suite {

	public String description;
	public String testInfoArrayName;
	public String initFunc;
	public String initMeth;
	public String cleanupFunc;
	public String cleanupMeth;
	public TestInfo testInfo;
	public String clientItf;
	
	public Suite(String description, String initFunc, String initMeth, String cleanupFunc, String cleanupMeth, TestInfo testInfo, String clientItf) {
		this.description = description;
		this.initFunc = initFunc;
		this.initMeth = initMeth;
		this.cleanupFunc = cleanupFunc;
		this.cleanupMeth = cleanupMeth;
		this.testInfo = testInfo;
		this.clientItf = clientItf;
	}
	
}
