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
public class MyAccountPage extends AccountPage{
	
	
	private WebDriver driver;
	

	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}


	public String getMyAccountText(String element) {
		
		return driver.findElement(By.xpath("//div[@id='content']/div/h2[text()='"+element+"']")).getText();
	}
	
	

}
