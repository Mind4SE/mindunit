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
 * @file mindUnitAutomated.c
 * @brief Implementation of the core execution of the CUnit tests in automated execution
 *
 * Comments
 *
 */

#include "CUnit/Automated.h"

/* Core execution of the tests */
int METH(launchTests,testsLauncher)()
{
  /* Set file for output */
  CU_set_output_filename ("Automated");

  /* Put test list in output file */
  if (CU_list_tests_to_file () != CUE_SUCCESS)
  {
    fprintf(stderr, "Test listing failed - %s\n",
	    CU_get_error_msg ());
    return 1;
  }

  /* Run tests using an appropriate interface, e.g. */
  CU_automated_run_tests ();
  return 0;
}
