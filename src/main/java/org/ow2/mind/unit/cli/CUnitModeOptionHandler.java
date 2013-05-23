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
