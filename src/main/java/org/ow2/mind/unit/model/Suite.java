package org.ow2.mind.unit.model;

public class Suite {

	public String description;
	public String testInfoArrayName;
	public String initFunc;
	public String cleanupFunc;
	public TestInfo testInfo;
	
	public Suite(String description, String initFunc, String cleanupFunc, TestInfo testInfo) {
		this.description = description;
		this.initFunc = initFunc;
		this.cleanupFunc = cleanupFunc;
		this.testInfo = testInfo;
	}
	
}
