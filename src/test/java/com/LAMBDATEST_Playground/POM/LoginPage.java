/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author NILAVA PAL
 */
public class LoginPage extends PageUtility{

	private WebDriver driver;
	//private LTPlayground_accountPage accountpage;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	private final String login_xpath="(//ul[@class='mz-sub-menu-96 dropdown-menu show']/li/a/div/span)[1]";
	@FindBy(xpath =login_xpath)
	private WebElement clickOnLogin;
	
	
	public WebElement getClickOnLogin() {
		return clickOnLogin;
	}
	
	private final String returingCustomer_xpath="(//div[@class='card-body p-4']/h2)[2]";
	@FindBy(xpath = returingCustomer_xpath)
	private WebElement returningCustomerText;
	
	public WebElement getReturningCustomerText() {
		return returningCustomerText;
	}
	
	private final String emailId_Id="input-email";
	@FindBy(id =emailId_Id)
	private WebElement enterEmailId;
	
	
	public WebElement getEnterEmailId() {
		return enterEmailId;
	}

	
	private final String password_Id="input-password";
	@FindBy (id = password_Id)
	private WebElement enterPassword;
	
	public WebElement getEnterPassword() {
		return enterPassword;
	}
	
	
	private final String loginButton_xpath="//input[@type='submit']";
	@FindBy(xpath = loginButton_xpath)
	private WebElement ClickOnLoginButton;
	
	
	public WebElement getClickOnLoginButton() {
		return ClickOnLoginButton;
	}
		
	public AccountPage getAccountPage() {
		
		return new AccountPage(driver);
	}
	
	public AccountPage loginToApplication(String URL,String username, String password) {
		driver.get(URL);
		getEnterEmailId().sendKeys(username);
		getEnterPassword().sendKeys(password);
	//	getClickOnLoginButton().click();
		getClickOnLoginButton().submit();
		return getAccountPage();
		
	}
	
}
