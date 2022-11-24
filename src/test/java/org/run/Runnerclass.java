package org.run;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.stepdefnition.ReportsJvm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",glue="org.stepdefnition",monochrome=true,dryRun=false,strict=true,tags= "@white",plugin= {"pretty",
		"html:C:\\Users\\Lenovo\\eclipse-workspace\\Maven12\\Allreports\\htmlReport","junit:C:\\Users\\Lenovo\\eclipse-workspace\\Maven12\\Allreports\\junitReport\\fb.xml",
		"json:C:\\Users\\Lenovo\\eclipse-workspace\\Maven12\\Allreports\\jsonReport\\fbk.json","rerun:C:\\\\Users\\\\Lenovo\\\\eclipse-workspace\\\\Maven12\\\\RerunFailed\\\\failed.txt"})


public class Runnerclass extends ReportsJvm {
	
	
	@AfterClass
	public static void methodA() {
		
		jvReport("C:\\Users\\Lenovo\\eclipse-workspace\\Maven12\\Allreports\\jsonReport\\fbk.json");

	}


	
	
}



