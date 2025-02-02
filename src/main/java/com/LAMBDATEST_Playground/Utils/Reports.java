/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.LAMBDATEST_Playground.AppConstants.AppConstant;
import com.LAMBDATEST_Playground.Enums.EnvironmentTypes;
import com.LAMBDATEST_Playground.Exceptions.EnvironmentTypeNotMatchException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author NILAVA PAL
 */
public class Reports {

	private static ExtentReports extentReports;
	private static ExtentSparkReporter reports;
	private static ExtentHtmlReporter extentHtmlReporter;
	private static PropertiesFile prop;

	/**
	 * 
	 * @return extentReports
	 * @throws EnvironmentTypeNotFoundException
	 */
	public static ExtentReports generateExtentReport() {
		try {
			prop = new PropertiesFile(AppConstant.EXTENT_FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		extentHtmlReporter = new ExtentHtmlReporter("user/build/" + Math.random());
		try {
			extentHtmlReporter.loadXMLConfig(AppConstant.PROJECT_PATH + "\\src\\test\\java\\extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentReports = new ExtentReports();
		File file = new File(
				AppConstant.PROJECT_PATH + "\\reportsLib\\report\\" + AppConstant.REPORTFILE_NAME +"_"+System.currentTimeMillis()+ ".html");
		// File file = new File(prop.getPropertiesValue("extent.reporter.html.out"));
		reports = new ExtentSparkReporter(file);

		reports.config().setTheme(Theme.DARK);
		reports.config().setDocumentTitle(AppConstant.DOCUMENT_TITLE_NAME);
		reports.config().setReportName(AppConstant.DOCUMENT_TITLE_NAME + "_Automation Report");
		reports.config().setTimeStampFormat("dd-MM-YYYY");

		extentReports.attachReporter(reports);

		extentReports.setSystemInfo("OS Version", prop.getPropertiesValue("systeminfo.os"));
		extentReports.setSystemInfo("Language", System.getProperty("user.language"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Country", System.getProperty("user.country"));

		try {
			prop = new PropertiesFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		switch (prop.getPropertiesValue("EnvType").toLowerCase().trim()) {

		case "dev":

			if (EnvironmentTypes.Dev.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				extentReports.setSystemInfo("EnvType:	", EnvironmentTypes.Dev.toString());
				extentReports.setSystemInfo("URL:		", prop.getPropertiesValue("URL"));
			} else {
				throw new EnvironmentTypeNotMatchException(">>>>>>>>>>> Please specify the env type <<<<<<<<<<<");
			}

			break;

		case "test":

			if (EnvironmentTypes.Test.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				extentReports.setSystemInfo("EnvType:	", EnvironmentTypes.Test.toString());
				extentReports.setSystemInfo("URL:		", prop.getPropertiesValue("URL"));
			} else {
				throw new EnvironmentTypeNotMatchException(">>>>>>>>>>> Please specify the env type <<<<<<<<<<<");
			}
			break;

		case "stage":
			if (EnvironmentTypes.Stage.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				extentReports.setSystemInfo("EnvType:	", EnvironmentTypes.Stage.toString());
				extentReports.setSystemInfo("URL:		", prop.getPropertiesValue("URL"));
			} else {
				throw new EnvironmentTypeNotMatchException(">>>>>>>>>>> Please specify the env type <<<<<<<<<<<");
			}

			break;

		case "prod":
			if (EnvironmentTypes.Prod.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				extentReports.setSystemInfo("EnvType:	", EnvironmentTypes.Prod.toString());
				extentReports.setSystemInfo("URL:		", prop.getPropertiesValue("URL"));
			} else {
				throw new EnvironmentTypeNotMatchException(">>>>>>>>>>> Please specify the env type <<<<<<<<<<<");
			}

			break;

		default:
			if (EnvironmentTypes.Dev.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				extentReports.setSystemInfo("EnvType:	", EnvironmentTypes.Dev.toString());
				extentReports.setSystemInfo("URL:		", prop.getPropertiesValue("URL"));
			} else {
				throw new EnvironmentTypeNotMatchException(">>>>>>>>>>> Please specify the env type <<<<<<<<<<<");
			}

			break;
		}

		return extentReports;

	}

	public static void closeExtentReport() {
		extentReports = new ExtentReports();
		extentReports.flush();
	}

	/**
	 * 
	 * @param screenshotName
	 * @return absolute path
	 * @throws IOException
	 */

	public String captureScreenshot(String screenshotName) {
		File srcPath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		File destPath = new File(AppConstant.PROJECT_PATH + "\\reportsLib\\screenShots\\" + screenshotName + "_"
				+ System.currentTimeMillis() + ".png");
		String absPath = destPath.getAbsolutePath();

		try {
			FileHandler.copy(srcPath, destPath);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(absPath);
		}catch (IOException e) {
			e.printStackTrace();
		}
		ExtentCucumberAdapter.addTestStepLog("<span style='background-color:rgb(0,102,255)>");

		return absPath;

	}

}
