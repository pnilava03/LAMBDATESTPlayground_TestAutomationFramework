/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**@author NILAVA PAL
 * 
 */
public class MyAccountPage  extends PageUtility{

	
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String toString(WebElement element) {
		return element.getText();
	}
}
