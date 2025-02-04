/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LAMBDATEST_Playground.AppConstants.AppConstant;
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

	// return myAccount page elements
	public MyAccountSection getMyAccountPage() {

		return new MyAccountSection(driver);
	}

	// return my Orders page elements
	public MyOrdersSection getMyOrderPages() {

		return new MyOrdersSection(driver);
	}

	// return mega Menu page element
	public MegaMenu getMegaMenuBar() {
		return new MegaMenu(driver);
	}

	// return AddOns Menu page element
	public AddOns getAddOnsMenuBar() {
		return new AddOns(driver);
	}

	// return my account Menu page element
	public MyAccount getMyAccountMenuBar() {
		return new MyAccount(driver);
	}

	/**
	 * this is overridden method from AppConstant interface, to check hover the mouse operation 
	 * and passing argument as  WebElement and AppConstant Interface
	 */
	@Override
	public void hoverTheMouse(AppConstant app, WebElement element) {
		ActionElement.mouseHover(element, driver);

	}

}
