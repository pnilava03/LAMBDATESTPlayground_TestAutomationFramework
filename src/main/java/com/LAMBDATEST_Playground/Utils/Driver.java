/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;
import com.LAMBDATEST_Playground.Enums.EnvironmentTypes;
import com.LAMBDATEST_Playground.Exceptions.BrowserNotFoundException;
import com.LAMBDATEST_Playground.Exceptions.EnvironmentTypeNotMatchException;

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
	 * @return WebDriver
	 * @throws FileNotFoundException
	 * @throws BrowserNotFoundException
	 * @throws EnvironmentTypeNotMatchException
	 * 
	 *                                          This method is responsible to launch
	 *                                          the Application by passing two
	 *                                          parameters @browserName & @url
	 *                                          and return WebDriver driver
	 */

	public WebDriver launchTheApplication(String browserName, String url)
			throws FileNotFoundException, BrowserNotFoundException, EnvironmentTypeNotMatchException {
		prop = new PropertiesFile();
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);

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
			driver.quit();
		}
	}

}
