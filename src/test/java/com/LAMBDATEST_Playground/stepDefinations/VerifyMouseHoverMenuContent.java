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

	@Then("verify mouse hover menu content from menu bar")
	public void verify_mouse_hover_menu_content_from_menu_bar() throws InterruptedException {
		accountPage.hoverTheMouse(new MegaMenu(driver), 
				accountPage.getMegaMenuBar().getMegaMenu());
		Thread.sleep(3000);
		accountPage.getAddOnsMenuBar().hoverTheMouse(new AddOns(driver),
				accountPage.getAddOnsMenuBar().getAddOnsMenu());
		Thread.sleep(3000);
		accountPage.getAddOnsMenuBar().hoverTheMouse(new MyAccount(driver),
				accountPage.getMyAccountMenuBar().getMyAccountMenu());

	}

}
