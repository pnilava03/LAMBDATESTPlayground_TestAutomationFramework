/**@author NILAVA PAL
 * 
 */
package com.LAMBDATEST_Playground.POM.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LAMBDATEST_Playground.POM.AccountPage;


/**
 * 
 */
public class AddOns extends AccountPage {

	
	private WebDriver driver;
	public AddOns(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	private final String addOnsMenu_xpath = "//span[contains(text(),'AddOns')]";
	@FindBy(xpath =addOnsMenu_xpath )
	private WebElement addOnsMenu;
	
	public WebElement getAddOnsMenu() {
		return addOnsMenu;
	}

	public String toString() {
		return getAddOnsMenu().getText();
	}
	
	

}
