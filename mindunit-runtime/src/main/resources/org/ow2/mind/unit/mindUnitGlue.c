/*
 * Schneider Electric Industries SAS: Tango NP Project
 */

/**
 * @file mindglue.c
 * @brief Implementation of the main routine for the CUnit test execution
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

#include <stdio.h>

#include "CUnit.h"

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
