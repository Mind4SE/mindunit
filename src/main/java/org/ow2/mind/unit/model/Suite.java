package org.ow2.mind.unit.model;

public class Suite {

	public String description;
	public String testInfoArrayName;
	public String initFunc;
	public String initMeth;
	public String cleanupFunc;
	public String cleanupMeth;
	public TestInfo testInfo;
	public String clientItf;
	
	public Suite(String description, String initFunc, String initMeth, String cleanupFunc, String cleanupMeth, TestInfo testInfo, String clientItf) {
		this.description = description;
		this.initFunc = initFunc;
		this.initMeth = initMeth;
		this.cleanupFunc = cleanupFunc;
		this.cleanupMeth = cleanupMeth;
		this.testInfo = testInfo;
		this.clientItf = clientItf;
	}
	
}
