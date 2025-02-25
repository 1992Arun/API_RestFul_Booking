package org.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utility.UtilityClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="org.step", dryRun=false, tags = {"@E2E"}, plugin= {"json:src\\test\\resources\\Reports\\JsonReport.json",
		                                                                                                      "rerun:src\\test\\resources\\Reports\\Rerun\\failed.txt"})
public class TestRunner {

	@AfterClass
	public static void JVMReport() {
		
		UtilityClass.getJVMReport("src\\test\\resources\\Reports\\JsonReport.json");
	}
	
}
