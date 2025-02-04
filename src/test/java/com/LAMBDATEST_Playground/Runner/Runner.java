/**
 * 
 */
package com.LAMBDATEST_Playground.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * 
 */




@CucumberOptions(tags = "@runThis", 
features ="resourcesLibs/features",
glue = {"com.LAMBDATEST_Playground.stepDefinations"}, 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true, dryRun = false, publish = true)


public class Runner extends AbstractTestNGCucumberTests {
	

	
}
