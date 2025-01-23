package com.LAMBDATEST_Playground.stepDefinations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.LAMBDATEST_Playground.POM.DashboardPage;
import com.LAMBDATEST_Playground.POM.RegisterAccountPage;
import com.LAMBDATEST_Playground.Utils.ActionElement;
import com.LAMBDATEST_Playground.Utils.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

	private String actualTitle;
	private WebDriver driver;
	private DashboardPage dashboadPage;
	private RegisterAccountPage registerAccountPage;

	@Given("user is on LambdaTest Playground dashboard page")
	public void user_is_on_lambda_test_playground_dashboard_page() {
		// initialize driver
		driver = DriverFactory.getDriver();

		dashboadPage = new DashboardPage(driver);

		boolean b = ActionElement.isElementDisplayed(dashboadPage.getVerifyLogo());
		System.out.println("Logo is diaplayed::" + b);
		Assert.assertTrue(ActionElement.isElementDisplayed(dashboadPage.getVerifyLogo()));

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		actualTitle = ActionElement.getTitle(driver);
		System.out.println("Application title is:: " + actualTitle);
	}

	@When("user verify the Application title {string}")
	public void verify_the_application_title(String expectedValue) {
		Assert.assertEquals(actualTitle, expectedValue);
	}

	@Given("user trying to hover the mouse on {string}")
	public void user_trying_to_hover_the_mouse_on(String expectedText) throws InterruptedException {
		String actualText = ActionElement.getText(dashboadPage.getMegaMenu());
		System.out.println("Actual text value is:: " + actualText);
		Assert.assertEquals(expectedText, actualText);
		Thread.sleep(4000);
		WebElement element = dashboadPage.getMegaMenu();
		ActionElement.mouseHover(element, driver);

	}

	@Then("user verifying {int} menu item in dashborad page")
	public void user_verifying_menu_item_in_dashborad_page(Integer expectedMenuItem) {
		int actualMenuItems = ActionElement.getElementsCount(dashboadPage.getDashboardMenuItem());
		System.out.println("Actual Menu Items:: " + actualMenuItems);
		System.out.println("Expected Menu Items:: " + expectedMenuItem);
		Assert.assertTrue(actualMenuItems == expectedMenuItem);
	}

	@Then("user gets dashborad menu items")
	public void user_gets_dashborad_menu_items(DataTable dataTable) {
		// expected value from feature file
		List<String> expectedList = dataTable.asList();
		System.out.println("Expected list contains:: " + expectedList.toString());

		// Actual value from UI Page
		List<String> actualList = ActionElement.getListOfElements(dashboadPage.getDashboardMenuItem());
		System.out.println("Actual list contains:: " + actualList.toString());

		// verifying both expectedList & actualList is same
		Assert.assertEquals(actualList.toString().equals(expectedList.toString()), true);
	}

	@When("user trying to hover the mouse on  My account menu item")
	public void user_trying_to_hover_the_mouse_on_my_account_menu_item() {
		ActionElement.mouseHover(dashboadPage.getMyAccount(), driver);

	}

	@Then("user can able to see {string} and {string} button")
	public void user_can_able_to_see_and_button(String expectedValue1, String expectedValue2) {
		String actualValue = null;
		int elementCount = ActionElement.getElementsCount(dashboadPage.getSubMenuListItem());
		System.out.println("Element Count is::" + elementCount);
		List<String> listOfSumMenu = ActionElement.getListOfElements(dashboadPage.getSubMenuListItem());
		for (String value : listOfSumMenu) {
			actualValue = value;
			if (actualValue.equals(expectedValue1)) {
				System.out.println("Actual Value is::" + actualValue);
				Assert.assertEquals(actualValue, expectedValue1);
			} else if (actualValue.equals(expectedValue2)) {
				System.out.println("Actual Value is::" + actualValue);
				Assert.assertEquals(actualValue, expectedValue2);
			}
		}

	}

	@And("user clicks on {string} button")
	public void user_clicks_on_button(String expectedValue) {
		dashboadPage.clickOnRegisterButton(expectedValue);
	}

	@Then("{string} page will be displayed")
	public void page_will_be_displayed(String expectdValue) {
		registerAccountPage = dashboadPage.getRegisterAccountPage();
		String actualValue = registerAccountPage.toString(dashboadPage.getRegisterAccountPageText());
		System.out.println("Register Actual Value is:: " + actualValue);
		Assert.assertEquals(expectdValue, actualValue);
	}
}
