
// -----------------------------------------------------------------------------
// Implementation of the primitive Tester.
// -----------------------------------------------------------------------------

#include <CUnit/CUnit.h>

// testItf implementation
int METH(testItf, myInit)(void) {
	return 0; // Success
}

void METH(testItf, myFirstTest)(void) {
    int arg0, arg1;
	// Call the tested component through its usual interface
    // and check if the result is equal to the expected value: 0
    arg0=10;
    arg1=arg0;
    CU_ASSERT_EQUAL(0, CALL(clientItf, method)(arg0, arg1));
}

int METH(testItf, myCleanup)(void) {
	return 1; // Failure
}

// testItf2 implementation
int METH(testItf2, myInit2)(void) {
	return 0; // Success
}

void METH(testItf2, mySecondTest)(void) {
    int arg0, arg1;
	// Call the tested component through its usual interface
    // and check if the result is equal to the expected value: 0
    arg0=20;
    arg1=arg0;
    CU_ASSERT_EQUAL(0, CALL(clientItf, method)(arg0, arg1));
}

int METH(testItf2, myCleanup2)(void) {
	return 0; // Success
}
