package org.ow2.mind.unit.model;

import java.util.List;

public class TestInfo {

	public String structName;
	public List<TestCase> testCases;
	
	public TestInfo(String structName, List<TestCase> testCases) {
		this.structName = structName;
		this.testCases = testCases;
	}
	
}
