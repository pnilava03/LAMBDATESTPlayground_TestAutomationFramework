/**
 * 
 */
package com.LAMBDATEST_Playground.stepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LAMBDATEST_Playground.POM.AccountPage;
import com.LAMBDATEST_Playground.POM.DashboardPage;
import com.LAMBDATEST_Playground.POM.LoginPage;
import com.LAMBDATEST_Playground.POM.MyAccountPage;
import com.LAMBDATEST_Playground.POM.RegisterAccountPage;
import com.LAMBDATEST_Playground.Utils.ActionElement;
import com.LAMBDATEST_Playground.Utils.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 */
public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountPage;
	//private MyAccountPage myAccountPage;
	

	@When("user clicks on the {string} button")
	public void user_clicks_on_the_button(String expectedText) throws InterruptedException {
		Thread.sleep(4000);
		// initialize driver
		driver = DriverFactory.getDriver();
		loginpage = new LoginPage(driver);
		
//		registerAccountPage=dashboardPage.getRegisterAccountPage();		
//		loginpage=registerAccountPage.getLoginPage();
//		driver=(WebDriver) loginpage;
		
		String actualText = ActionElement.getText(loginpage.getClickOnLogin());
		Assert.assertEquals(expectedText, actualText);
		loginpage.getClickOnLogin().click();
	}

	@When("user gets the title of the login page {string}")
	public void user_gets_the_title_of_the_login_page(String expectedTitle) throws InterruptedException {
		Thread.sleep(2000);

		String actualTitle = ActionElement.getTitle(driver);
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("user will verify {string} text on the login page")
	public void user_will_verify_text_on_the_login_page(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		String actualText = ActionElement.getText(loginpage.getReturningCustomerText());
		Assert.assertEquals(expectedText, actualText);

	}

	@Then("user enters")
	public void user_enters(DataTable dataTable) throws InterruptedException {
		Thread.sleep(2000);
		List<Map<String, String>> list = dataTable.asMaps();
		String username = list.get(0).get("userName");
		String password = list.get(0).get("passWord");
		loginpage.getEnterEmailId().sendKeys(username);
		loginpage.getEnterPassword().sendKeys(password);

	}

	@Then("user click on the {string} button")
	public void user_click_on_the_button(String expectedValue) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Login=========>"+expectedValue);
		String actualValue = ActionElement.getAttribute(loginpage.getClickOnLoginButton(),"value");
		Assert.assertEquals(expectedValue, actualValue);
		loginpage.getClickOnLoginButton().click();

	}

	@Then("user navigate to {string} page")
	public void user_navigate_to_page(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		
		accountPage=loginpage.getMyAccountPage();
		String actualValue=accountPage.toString(accountPage.getAccountText());
		Assert.assertEquals(expectedText, actualValue);
		
	

	}
	
	
	@Then("user will able to see {string} text")
	public void user_will_able_to_see_text(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		String actualText=accountPage.getMyAccountPage().getMyAccountText(expectedText);
		Assert.assertEquals(expectedText, actualText);
	}
	

	@Then("user can see the {string} text")
	public void user_can_see_the_text(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		String actualText=accountPage.getMyOrderPages().getMyOrderText(expectedText);
		Assert.assertEquals(expectedText, actualText);
	}

}
