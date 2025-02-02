/**
 * 
 */
package com.LAMBDATEST_Playground.Listeners;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LAMBDATEST_Playground.Exceptions.BrowserNotFoundException;
import com.LAMBDATEST_Playground.Exceptions.EnvironmentTypeNotMatchException;
import com.LAMBDATEST_Playground.Utils.Driver;

import com.LAMBDATEST_Playground.Utils.PropertiesFile;
import com.LAMBDATEST_Playground.Utils.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

/**
 * @author NILAVA PAL
 */
public class Listener implements ITestListener {

	private WebDriver driver;
	Driver ldriver;
	PropertiesFile prop;
	ExtentReports extentReports;
	ExtentTest extentTest;
	Reports report;

	@Override
	public void onStart(ITestContext context) {
		try {
			extentReports = Reports.generateExtentReport();
		} catch (EnvironmentTypeNotMatchException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestStart(ITestResult result) {

		try {
			prop = new PropertiesFile();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		ldriver = new Driver();
		try {
			driver = ldriver.launchTheApplication(prop.getPropertiesValue("Browser"), prop.getPropertiesValue("URL"));
		} catch (FileNotFoundException | BrowserNotFoundException | EnvironmentTypeNotMatchException e) {

			e.printStackTrace();
		}

		extentTest = extentReports.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// extentTest = extentReports.createTest(result.getName());
		report = new Reports();
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "PASS");
			extentTest = ExtentCucumberAdapter.getCurrentStep();
			System.out.println("Current Step name is:: " + extentTest.toString());

			extentTest.pass(result.getName(),
					MediaEntityBuilder.createScreenCaptureFromPath(report.captureScreenshot(result.getName())).build());

		}

	

	}

	@Override
	public void onTestFailure(ITestResult result) {

		report = new Reports();
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "FAIL  " + result.getThrowable());

			extentTest.fail(result.getName(),
					MediaEntityBuilder.createScreenCaptureFromPath(report.captureScreenshot(result.getName())).build());

		}

		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// extentTest = extentReports.createTest(result.getName());
		if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "SKIP");

			extentTest.skip(result.getName(),
					MediaEntityBuilder.createScreenCaptureFromPath(report.captureScreenshot(result.getName())).build());

		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Pass/FAIL-- Percentage Result");

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReports.flush();

		driver.quit();

	}

}
