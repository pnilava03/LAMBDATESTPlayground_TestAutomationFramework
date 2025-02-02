/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author NILAVA PAL
 */
public class RegisterAccountPage extends PageUtility{
	
	private WebDriver driver;
	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	public String toString(WebElement element) {
		return element.getText();
		
	}
	
	private final String firstNameId="input-firstname";
	@FindBy(id =firstNameId)
	private WebElement firstName;
	
	private final String lastNameId="input-lastname";
	@FindBy(id =lastNameId)
	private WebElement lastName;
	
	private final String emailId_Id="input-email";
	@FindBy(id=emailId_Id)
	private WebElement emailId;
	
	private final String phNumberID="input-telephone";
	@FindBy(id = phNumberID)
	private WebElement phNumber;
	
	private final String password_Id="input-password";
	@FindBy(id = password_Id)
	private WebElement password;
	
	private final String confirmPassword_Id="input-confirm";
	@FindBy(id=confirmPassword_Id)
	private WebElement confirmPassword;
	
	private final String privacyPolicy_CheckBox_xpath="//div[@class='custom-control custom-checkbox custom-control-inline']/input";
	@FindBy(xpath  = privacyPolicy_CheckBox_xpath)
	private WebElement privacyPolicy;
	
	private final String privacyPolicyText_xpath="//div[@class='custom-control custom-checkbox custom-control-inline']/label";
	@FindBy(xpath = privacyPolicyText_xpath)
	private WebElement privacyPolicyText; 
	
	private final String continueButton_Xpath="//input[@type='submit']";
	@FindBy(xpath =continueButton_Xpath )
	private WebElement continueButton;
	
	
	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPrivacyPolicyText() {
		return privacyPolicyText;
	}

	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}

	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLastName() {
		return lastName;
	}
	
	public WebElement getEmailId() {
		return emailId;
	}
	
	public WebElement getPhNumber() {
		return phNumber;
	}
	
	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setConfirmPassword(WebElement confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	
	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}

	
	
}
