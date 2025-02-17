/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.FileNotFoundException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;
import com.LAMBDATEST_Playground.Enums.EnvironmentTypes;
import com.LAMBDATEST_Playground.Exceptions.BrowserNotFoundException;
import com.LAMBDATEST_Playground.Exceptions.EmptyURLException;
import com.LAMBDATEST_Playground.Exceptions.EnvironmentTypeNotMatchException;
import com.LAMBDATEST_Playground.Exceptions.httpMissingException;

/**
 * @author NILAVA PAL
 */
public class Driver {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private PropertiesFile prop;

	/**
	 * 
	 * @param browserName
	 * @param url
	 * @return it will return driver (WebDriver)
	 * @throws FileNotFoundException
	 * @throws BrowserNotFoundException
	 * @throws EnvironmentTypeNotMatchException
	 * @throws NullPointerException
	 * 
	 *                                          This method is responsible to launch
	 *                                          the Application by passing two
	 *                                          parameters @browserName & @url is
	 *                                          String format and return WebDriver
	 *                                          driver
	 */

	public WebDriver launchTheApplication(String browserName, String url) throws FileNotFoundException {
		prop = new PropertiesFile();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
		nullCheck(url);
		lengthCheck(url);
		httpCheck(url);

		switch (prop.getPropertiesValue("EnvType").trim().toLowerCase()) {
		case "dev":
			if (EnvironmentTypes.Dev.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);

			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;

		case "test":
			if (EnvironmentTypes.Test.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;
		case "stage":
			if (EnvironmentTypes.Stage.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;

		case "prod":
			if (EnvironmentTypes.Prod.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {
				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");

			}

			break;

		default:
			throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
					+ " is not match, please specify the proper Env type ");

		}
		return driver;

	}

	/**
	 * This method is responsible to launch the Application by passing two
	 * parameters @browserName & @url is URL format and return WebDriver driver
	 * 
	 * @param browserName
	 * @param appURL
	 * @return it will return driver (WebDriver);
	 * @throws FileNotFoundException
	 * @throws EmptyURLException
	 * @throws httpMissingException
	 * @throws NullPointerException
	 */

	public WebDriver launchTheApplication(String browserName, URL appURL) throws FileNotFoundException {
		String url = String.valueOf(appURL);

		prop = new PropertiesFile();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);

		nullCheck(url);
		lengthCheck(url);
		httpCheck(url);


		switch (prop.getPropertiesValue("EnvType").trim().toLowerCase()) {
		case "dev":
			if (EnvironmentTypes.Dev.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);

			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;

		case "test":
			if (EnvironmentTypes.Test.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;
		case "stage":
			if (EnvironmentTypes.Stage.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {

				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");
			}

			break;

		case "prod":
			if (EnvironmentTypes.Prod.toString().equalsIgnoreCase(prop.getPropertiesValue("EnvType"))) {
				driver.get(url);
			} else {
				throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
						+ " is not match, please specify the proper Env type ");

			}

			break;

		default:
			throw new EnvironmentTypeNotMatchException("Opps !!! Env type:: " + prop.getPropertiesValue("EnvType")
					+ " is not match, please specify the proper Env type ");

		}
		return driver;

	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

		/**
		 * This method will check if URL is null then throw Null Pointer exception 
		 * @param url
		 */
	private void nullCheck(String url) {
		if (url == null)
			throw new NullPointerException("URL is null::" + url);
	}
	
	/**
	 * This method will check if URL is length is 0 then it will throw EmptyURLException
	 * @param url
	 */

	private void lengthCheck(String url) {
		if (url.length() == 0) {
			throw new EmptyURLException("=========Empty URL========="+url);
		}
	}

	/**
	 * This method will check if URL is NOT contains http/https then it will throw httpMissingException
	 * @param url
	 */
	private void httpCheck(String url) {
		if (url.indexOf("http") != 0) {
			throw new httpMissingException("=========http is missing from URL========="+url);
		}

	}
	
	
}
