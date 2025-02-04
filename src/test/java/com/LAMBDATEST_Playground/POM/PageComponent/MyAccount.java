/**
 * @author NILAVA PAL
 */
package com.LAMBDATEST_Playground.POM.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LAMBDATEST_Playground.POM.AccountPage;


/**
 * 
 */
public class MyAccount extends AccountPage {
	
	private WebDriver driver;

	public MyAccount(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}

	private final String myAccountMenu_Xpath="(//span[contains(text(),'My account')])[2]";
	
	@FindBy(xpath = myAccountMenu_Xpath)
	private WebElement myAccountMenu;
	
	public WebElement getMyAccountMenu() {
		return myAccountMenu;
	}

	

}
