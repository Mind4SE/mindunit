MindUnit
========

A Unit Test framework for Mind components.

Contact
=======

mind@ow2.org & stephaneseyvoz@gmail.com

User info
=========

Installation requires:
- CUnit, installed in your environment (http://cunit.sourceforge.net/)
  - Windows users, see: http://stackoverflow.com/questions/12514408/building-cunit-on-windows
  - Linux users can use their package manager as usual or build the library as well

MindUnit is a plugin of the Mindc compiler and uses the same flags. However, the build target is a source path folder (or a list of source path folders) containing the tests to be ran.

In order to create test, simply create composite ADL components in the target folder (qualified names and subfolders are searched as usual), and use the @TestSuite annotation on their definitions.

Those composite components should usually contain as sub-components:
- the Tested business component from your library ;
- a Tester component going with your test composite, providing interfaces which test methods to be ran have to be annoted with @Test ;
- Mock components or data providing components.

For example:

1. MyTestSuite.adl:
```
@TestSuite("Suite friendly description")
composite MyTestSuite {
	contains Tester as myTesterComp ;
	contains Tested as myTestedComp ;
	contains Mock as mockComp ;
	
	// ...bindings between the components...
}
```

2. Tester.adl:
```
primitive Tester {
	provides TestInterface as testItf;
	source tester.c;	
}
```

3. TestInterface.itf:
```
interface TestInterface {
	@Test("User-friendly test-description")
	void myFirstTest(void);
}
```

4. tester.c:
```C++
#include "CUnit/CUnit.h"

void METH(testItf, myFirstTest)(void) {
	...
	// Call the tested component through its usual interface
	// and check if the result is equal to the expected value: 0
	CU_ASSERT_EQUAL(0, CALL(clientItf, method)(arg0, arg1));
	...
}
```

Notes:
- @Test methods return type MUST be "void" and argument MUST be "void" ;
- @Init and @Cleanup can be used in test interfaces as well and MUST return an "int" type and use "void" as an argument ;
- Those constraints come from CUnit
- The test interfaces are mapped to CUnit suites
- In the tester.c file you must #include "CUnit/CUnit.h" and use the CUnit assertions for your tests ;

To build the test application, simply run the "mindunit" tool with the usual mindc compiler flags and the folder as target.
@TestSuite-annotated composites will be automatically added to a test container inside a predefined application to be compiled.

You can choose to compile the application using either CUnit's automated, console, or gcov mode using the "--cunit-mode=" flag and setting the value as needed. The according component will be added in the automatically constructed application.

The mindunit plugin also automatically adds a CUnit library initialization component, so you don't need to care about that.

Finally, the complete CUnit test suites are generated in a source file according to the @Test annotations you used in your @TestSuites, so you never need to write it, anytime. The mindUnitSuite.c generated file can be found in the mindunit compilation output folder, in the "unit-gen" subfolder. 

The compilation result component is prefixed with your cunit-mode choice as a prefix (automated is default) and suffixed by "_mindUnitOuput" (+.exe for Windows users).

Run the executable in order to generate the XML test results.

Copy the standard CUnit XSL files (usually in /usr/local/share/CUnit) next to your XML output, and open the XML files with your internet browser: you can visualize your test results.
Test results can be imported in Jenkins, using the right CUnit XML to JUnit XML XSL transformation, allowing for reports and statistics.

Developer info
==============
  
In order to build MindUnit (users should skip this part):  
Since MindUnit is a plugin of the Mindc compiler, its build is based on Maven as well.
Use "mvn install" as usual, and then merge the result folders (bin, lib, runtime) with the standard compiler.
Folders description:
- bin: launch scripts
- lib: jars containing the plugin code
- runtime: a few internal components used to customize/construct the final test application

