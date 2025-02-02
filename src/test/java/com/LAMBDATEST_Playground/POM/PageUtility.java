/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.LAMBDATEST_Playground.Utils.DriverFactory;

/**
 * @author NILAVA PAL
 */
public abstract class PageUtility{
	
	private WebDriver driver;
	

	public PageUtility(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		
	}
	

}
