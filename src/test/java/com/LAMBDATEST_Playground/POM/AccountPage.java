/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;
import com.LAMBDATEST_Playground.Exceptions.MissingStrategyTpeExceptipon;
import com.LAMBDATEST_Playground.POM.PageComponent.AddOns;
import com.LAMBDATEST_Playground.POM.PageComponent.MegaMenu;
import com.LAMBDATEST_Playground.POM.PageComponent.MyAccount;
import com.LAMBDATEST_Playground.Utils.ActionElement;

/**
 * @author NILAVA PAL
 * 
 */
public class AccountPage extends PageUtility implements AppConstant {

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private final String account_xpath = "//li[text()='Account']";
	@FindBy(xpath = account_xpath)
	private WebElement account_Text;

	public WebElement getAccountText() {
		return account_Text;
	}

	public String toString(WebElement element) {
		return element.getText();
	}

	// return myAccount section page elements
	public MyAccountSection getMyAccountPage() {

		return new MyAccountSection(driver);
	}

	// return my Orders section page elements
	public MyOrdersSection getMyOrderPages() {

		return new MyOrdersSection(driver);
	}

	// return mega Menu bar element
	public MegaMenu getMegaMenuBar() {
		return new MegaMenu(driver);
	}

	// return AddOns Menu bar element
	public AddOns getAddOnsMenuBar() {
		return new AddOns(driver);
	}

	// return my account Menu bar element
	public MyAccount getMyAccountMenuBar() {
		return new MyAccount(driver);
	}

	/**
	 * this is overridden method from AppConstant(I) interface. this is dynamic
	 * strategy implementation where user provides a value in runtime based on the
	 * pageComponent classes
	 * 
	 * @param AppConstant(I) app
	 * @param element
	 */
	@Override
	public void hoverTheMouse(AppConstant app, WebElement element) {
		ActionElement.mouseHover(element, driver);

	}

	/**
	 * This is a factory strategy implementation where the user provides a custom
	 * strategy based on their requirements from the UI page. This method is
	 * responsible for returning the corresponding class.
	 * 
	 * @param strategyTpe
	 * @return PageComponent pkg classes
	 */
	private final AppConstant setStrategy(String strategyTpe) {
		if (strategyTpe.equalsIgnoreCase(getMegaMenuBar().toString())) {
			Assert.assertEquals(strategyTpe, getMegaMenuBar().toString());
			System.out.println(getMegaMenuBar().toString());
			return new MegaMenu(driver);
		} else if (strategyTpe.equalsIgnoreCase(getAddOnsMenuBar().toString())) {
			Assert.assertEquals(strategyTpe, getAddOnsMenuBar().toString());
			System.out.println(getAddOnsMenuBar().toString());
			return new AddOns(driver);
		} else if (strategyTpe.equalsIgnoreCase(getMyAccountMenuBar().toString())) {
			Assert.assertEquals(strategyTpe, getMyAccountMenuBar().toString());
			System.out.println(getMyAccountMenuBar().toString());
			return new MyAccount(driver);

		} else {
			throw new MissingStrategyTpeExceptipon(
					"=========== " + strategyTpe + ":: is missing, please specify correct strategyTpe. ===========");

		}
	}

	/**
	 * this is overridden method from AppConstant(I) interface, to check hover the
	 * mouse operation and passing argument as WebElement and String strategyType
	 * strategyType will be return corresponding pageComponent classes
	 */

	@Override
	public AppConstant hoverTheMouse(String strategyType, WebElement element) {
		setStrategy(strategyType);
		ActionElement.mouseHover(element, driver);
		return null;
	}

}
