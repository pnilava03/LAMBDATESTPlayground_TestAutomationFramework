/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;
import com.LAMBDATEST_Playground.Enums.EnvironmentTypes;
import com.LAMBDATEST_Playground.Exceptions.BrowserNotFoundException;
import com.LAMBDATEST_Playground.Exceptions.EnvironmentTypeNotMatchException;

/**
 * 
 */
public class DriverFactory {

	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	protected DriverFactory() {

	}

	/**
	 * 
	 * @param browserName
	 * @return getDriver()
	 * @throws BrowserNotFoundException
	 * @throws FileNotFoundException
	 * @throws EnvironmentTypeNotMatchException
	 * 
	 *                                          This method is responsible to the
	 *                                          setBrowser by using ThreadLocal, so
	 *                                          at a time multiple thread can access
	 *                                          and it will return getDriver()
	 */
	private WebDriver setBrowser(String browserName)
			throws FileNotFoundException{

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			if (tldriver != null) {
				tldriver.set(new ChromeDriver());
			} else {
				throw new IllegalArgumentException("Please specify the correct Argument:: " + browserName);
			}
			break;

		case "firefox":
			if (tldriver != null) {
				System.setProperty("webdriver.firefox.marionette",
						AppConstant.PROJECT_PATH + "\\resourcesLibs\\driverLibs\\geckodriver.exe");
				tldriver.set(new FirefoxDriver());
			} else {
				throw new IllegalArgumentException("Please specify the correct Argument:: " + browserName);
			}

			break;

		case "ie":
			if (tldriver != null) {
				tldriver.set(new InternetExplorerDriver());
			} else {
				throw new IllegalArgumentException("Please specify the correct Argument:: " + browserName);
			}
			break;

		case "safari":
			if (tldriver != null) {
				tldriver.set(new SafariDriver());
			} else {
				throw new IllegalArgumentException("Please specify the correct Argument:: " + browserName);
			}
			break;

		case "edge":
			if (tldriver != null) {
				tldriver.set(new EdgeDriver());
			} else {
				throw new IllegalArgumentException("Please specify the correct Argument:: " + browserName);
			}
			break;

		default:

			throw new BrowserNotFoundException("Opps !!! Please enter correct browser name:: " + browserName);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();

	}

	/**
	 * This method is responsible for get the driver from WebDriver.
	 * @return get()
	 */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * 
	 * @param browserName
	 * @return setBrowser(browserName)
	 * @throws FileNotFoundException
	 * @throws BrowserNotFoundException
	 * @throws EnvironmentTypeNotMatchException
	 * 
	 * this method is for access for setBrowser(browserName) to child class
	 */
	
	protected WebDriver init_Driver(String browserName)
			throws FileNotFoundException {
		return setBrowser(browserName);
	}
}
