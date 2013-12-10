/*
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
 * Authors: Francois Deloye, Stephane Seyvoz
 * Contributors:
 */

/**
 * @file mindglue.c
 * @brief Implementation of the main routine for the CUnit test execution
 *
 * Comments
 *
 */

#include <stdio.h>

#include "CUnit/CUnit.h"

extern CU_SuiteInfo suites [];


/* Main program */
int METH(entryPoint, main)(int argc, char **argv)
{
  /* No output buffering... */
  setvbuf (stdout, NULL, _IONBF, 0);

  /* Initialize the test registry */
  if (CU_initialize_registry () != CUE_SUCCESS)
  {
    printf("\nInitialization of Test Registry failed.");
    return 1;
  }

  /* Add suites to the test registry */
  if (CU_register_suites (suites) != CUE_SUCCESS)
  {
    fprintf(stderr, "Suite registration failed - %s\n",
	    CU_get_error_msg ());
    return 1;
  }

  /* Launch tests */
  if (CALL(launchTests,testsLauncher)()!=0)
  {
	  return 1;
  }

  /* Cleanup the test registry */
  CU_cleanup_registry ();

  return 0;
}
