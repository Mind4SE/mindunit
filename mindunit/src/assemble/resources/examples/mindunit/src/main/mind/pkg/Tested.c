
// -----------------------------------------------------------------------------
// Implementation of the primitive Tested.
// -----------------------------------------------------------------------------

int METH(providedItf, method) (int arg0, int arg1) {
	if (CALL(requiredItf,anotherMethod)(arg0)>arg1) {
		return arg0-arg1;
	}
	else {
		return arg1-arg0;
	}
}
