
// -----------------------------------------------------------------------------
// Implementation of the primitive Tester.
// -----------------------------------------------------------------------------

#include <CUnit/CUnit.h>
void METH(testItf, myFirstTest)(void) {
    int arg0, arg1;
	// Call the tested component through its usual interface
    // and check if the result is equal to the expected value: 0
    arg0=10;
    arg1=arg0;
    CU_ASSERT_EQUAL(0, CALL(clientItf, method)(arg0, arg1));
}
