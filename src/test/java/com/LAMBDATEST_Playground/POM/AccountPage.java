/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**@author NILAVA PAL
 * 
 */
public class AccountPage  extends PageUtility{

	
	private WebDriver driver;
	
	//WebElement accountText;
	
//	WebElement accountText;
	
	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	
		
		}
	
	//return myAccount page elements
		public MyAccountPage getMyAccountPage() {
			
			return new MyAccountPage(driver);
		}
		
	
	private final String account_xpath="//li[text()='Account']";
	@FindBy(xpath = account_xpath)
	private WebElement account_Text;
	
	
	public WebElement getAccountText() {
		return account_Text;
	}
	
	public String toString(WebElement element) {
		return element.getText();
	}
	
	
	
	
	
	//return my Orders page elements
//	public MyOrdersPage getMyOrderPages() {
//		
//		return new MyOrdersPage(driver, accountText);
//	}
}
