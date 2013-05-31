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
	
	/**
	 * Modelization of a CU_SuiteInfo row.
	 * 
	 * @param description The user-defined @TestSuite description argument.
	 * @param initFunc The int-void relay function that will CALL our suite's clientItf.initMeth initialization method. 
	 * @param initMeth The method that will be CALL-ed in the initFunc relay function implementation.
	 * @param cleanupFunc The int-void relay function that will CALL our suite's clientItf.cleanupMeth cleanup method. 
	 * @param cleanupMeth The method that will be CALL-ed in the cleanupFunc relay function implementation.
	 * @param testInfo The TestInfo structure name that references every @Test function and its description.
	 * @param clientItf The specific client interface bound to the current target @TestSuite. 
	 */
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
