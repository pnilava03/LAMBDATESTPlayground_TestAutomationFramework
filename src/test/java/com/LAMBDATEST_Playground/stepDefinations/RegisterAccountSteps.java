/**
 * 
 */
package com.LAMBDATEST_Playground.stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LAMBDATEST_Playground.POM.DashboardPage;
import com.LAMBDATEST_Playground.POM.RegisterAccountPage;
import com.LAMBDATEST_Playground.Utils.ActionElement;
import com.LAMBDATEST_Playground.Utils.DriverFactory;
import com.LAMBDATEST_Playground.Utils.Reports;

import io.cucumber.java.en.Then;

/**
 * @author NILAVA PAL
 * 
 */
public class RegisterAccountSteps {

//	private LTPlayground_dashboardPage dashboardPage;
	private RegisterAccountPage registerPage;

	private WebDriver driver;
	private DashboardPage dashboardPage;

//	private Reports report = new Reports();;

	@Then("user enters firstName {string}")
	public void user_enters_first_name(String firstName) throws InterruptedException, IOException {
		Thread.sleep(4000);
		driver = DriverFactory.getDriver();
		registerPage = new RegisterAccountPage(driver);

		// registerPage= dashboardPage.getRegisterAccountPage();
		registerPage.getFirstName().sendKeys(firstName);
		// report.captureScreenshot(firstName);
	}

	@Then("user enters LastName {string}")
	public void user_enters_last_name(String lastName) throws InterruptedException, IOException {
		Thread.sleep(2000);
		registerPage.getLastName().sendKeys(lastName);
		// report.captureScreenshot(lastName);
	}

	@Then("user enters emailId {string}")
	public void user_enters_email_id(String emailId) throws InterruptedException, IOException {
		Thread.sleep(2000);
		registerPage.getEmailId().sendKeys(emailId);
		// report.captureScreenshot(emailId);

	}

	@Then("user enters TelephoneNumber {string}")
	public void user_enters_telephone_number(String phNumber) throws InterruptedException, IOException {
		Thread.sleep(2000);
		registerPage.getPhNumber().sendKeys(phNumber);
//		/report.captureScreenshot(phNumber);
	}

	@Then("user enters password {string}")
	public void user_enters_password(String password) throws InterruptedException, IOException {
		Thread.sleep(2000);
		registerPage.getPassword().sendKeys(password);
		// report.captureScreenshot(password);
	}

	@Then("user enters confirmPassword {string}")
	public void user_enters_confirm_password(String confirmPassword) throws InterruptedException, IOException {
		Thread.sleep(2000);
		registerPage.getConfirmPassword().sendKeys(confirmPassword);
		// report.captureScreenshot(confirmPassword);
	}

	@Then("user clicks on {string} checkBox")
	public void user_clicks_on_check_box(String ExpectedPrivacyPlicy) throws InterruptedException, IOException {
		Thread.sleep(2000);
		String actualPrivacyPloicy = ActionElement.getText(registerPage.getPrivacyPolicyText());
		String finalPrivacyPolicy = actualPrivacyPloicy.substring(29, 43);
		System.out.println("Privacy Policy===========>" + finalPrivacyPolicy);
		Assert.assertEquals(finalPrivacyPolicy, ExpectedPrivacyPlicy);
		registerPage.getPrivacyPolicy().click();

		// report.captureScreenshot(finalPrivacyPolicy);
		// ActionElement.waitForElementTobeClickable(driver,
		// registerPage.getPrivacyPolicy());
	}

	@Then("user click on {string} button")
	public void user_click_on_button(String expectedContinueButton) throws InterruptedException {
		Thread.sleep(2000);
		String actualContinuebutton = ActionElement.getAttribute(registerPage.getContinueButton(), "value");
		Assert.assertEquals(expectedContinueButton, actualContinuebutton);

	}

}
