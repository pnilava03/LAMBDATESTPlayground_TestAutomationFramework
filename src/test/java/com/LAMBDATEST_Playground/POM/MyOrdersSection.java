/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public class MyOrdersSection extends AccountPage {

	private WebDriver driver;

	public MyOrdersSection(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	
	
public String getMyOrderText(String expectedValue) {
		
		return driver.findElement(By.xpath("//div[@id='content']/div/h2[text()='"+expectedValue+"']")).getText();
	}

}
