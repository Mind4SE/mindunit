/*
 * Schneider Electric Industries SAS: Tango NP Project
 */

/**
 * @file mindUnitAutomated.c
 * @brief Implementation of the core execution of the CUnit tests in automated execution
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

#include "Automated.h"

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
