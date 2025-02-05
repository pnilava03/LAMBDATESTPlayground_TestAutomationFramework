/**
 * 
 */
package com.LAMBDATEST_Playground.stepDefinations;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.LAMBDATEST_Playground.POM.AccountPage;
import com.LAMBDATEST_Playground.POM.LoginPage;
import com.LAMBDATEST_Playground.POM.PageComponent.AddOns;
import com.LAMBDATEST_Playground.POM.PageComponent.MegaMenu;
import com.LAMBDATEST_Playground.POM.PageComponent.MyAccount;
import com.LAMBDATEST_Playground.Utils.ActionElement;
import com.LAMBDATEST_Playground.Utils.DriverFactory;
import com.LAMBDATEST_Playground.Utils.PropertiesFile;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * 
 */
public class VerifyMouseHoverMenuContent {

	private LoginPage loginpage;
	private AccountPage accountPage;
	private WebDriver driver;
	private PropertiesFile prop;

	@Given("Login to the application")
	public void login_to_the_application(DataTable dataTable) {
		driver = DriverFactory.getDriver();
		try {
			prop = new PropertiesFile();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String URL = prop.getPropertiesValue("URL");
		List<Map<String, String>> data = dataTable.asMaps();
		String username = data.get(0).get("userName");
		String password = data.get(0).get("passWord");
		loginpage = new LoginPage(driver);
		accountPage = loginpage.loginToApplication(URL, username, password);

	}


		//This is the show case of dynamic strategy implementation
	@Then("verify mouse hover menu content from menu bar")
	public void verify_mouse_hover_menu_content_from_menu_bar() throws InterruptedException {
		Thread.sleep(1500);
		accountPage.hoverTheMouse(new MegaMenu(driver), accountPage.getMegaMenuBar().getMegaMenu());
		Thread.sleep(3000);
		accountPage.hoverTheMouse(new AddOns(driver), accountPage.getAddOnsMenuBar().getAddOnsMenu());
		Thread.sleep(3000);
		accountPage.hoverTheMouse(new MyAccount(driver), accountPage.getMyAccountMenuBar().getMyAccountMenu());
		
	}

	//This is the show case of factory strategy implementation
	@Then("verify mouse hover menu content from menu bar {string}, {string} and {string}")
	public void verify_mouse_hover_menu_content_from_menu_bar_and(String expectedValue1, String expectedValue2,
			String expectedValue3) throws InterruptedException {
		Thread.sleep(3000);
		accountPage.hoverTheMouse(expectedValue1, accountPage.getMegaMenuBar().getMegaMenu());
		Thread.sleep(3000);
		accountPage.hoverTheMouse(expectedValue2, accountPage.getAddOnsMenuBar().getAddOnsMenu());
		Thread.sleep(3000);
		accountPage.hoverTheMouse(expectedValue3, accountPage.getMyAccountMenuBar().getMyAccountMenu());
	}

}
