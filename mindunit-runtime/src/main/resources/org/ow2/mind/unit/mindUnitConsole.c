/**
 * @file mindUnitConsole.c
 * @brief Implementation of the core execution of the CUnit tests in console execution
 *
 * Comments
 *
 */

/*
 * All rights reserved (c) 2013
 * Schneider Electric Industries SAS
 *
 * This computer program may not be used, copied, distributed, corrected,
 * modified, translated, transmitted or assigned without Schneider-electric’s
 * prior written authorization.
 */

#include "Console.h"

/* Core execution of the tests */
int METH(launchTests,testsLauncher)()
{
	/* Run tests using an appropriate interface, e.g. */
	CU_console_run_tests ();
	return 0;
}
