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

package org.ow2.mind.unit.cli;

import java.util.Map;
import java.util.logging.Logger;

import org.objectweb.fractal.adl.util.FractalADLLogManager;
import org.ow2.mind.cli.CmdArgument;
import org.ow2.mind.cli.CmdOption;
import org.ow2.mind.cli.CommandLine;
import org.ow2.mind.cli.CommandOptionHandler;
import org.ow2.mind.cli.InvalidCommandLineException;
import org.ow2.mind.plugin.util.Assert;

public class CUnitModeOptionHandler implements CommandOptionHandler {

	/** The ID of the "cunit-mode" option. */
	public static final String CUNITMODE_ID				= "org.ow2.mind.unit.CUnitMode";
	
	public static final String CUNITMODE_CONTEXT_KEY	= "cunit-mode";

	/**
	 * Logger.
	 */
	private static Logger logger = FractalADLLogManager.getLogger("CUnitMode");
			
	/**
	 * Store the choice in the context and choose default value if necessary
	 */
	public void processCommandOption(CmdOption cmdOption, CommandLine cmdLine,
			Map<Object, Object> context) throws InvalidCommandLineException {
		
		Assert.assertEquals(cmdOption.getId(), CUNITMODE_ID);

		final CmdArgument CUnitModeOpt = Assert.assertInstanceof(cmdOption, CmdArgument.class);
		
		// Default value is automatically chosen in getValue if the user value is empty
		context.put(CUNITMODE_CONTEXT_KEY, CUnitModeOpt.getValue(cmdLine));
	}

}
