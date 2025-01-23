/**
 * 
 */
package com.LAMBDATEST_Playground.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

/**
 * 
 */
public class DashboardPage extends PageUtility {

	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
//	private LTPlayground_registerAccountPage registerAccountPage;

	private final String megaMenuXpath = "//div/span[contains(text(),'Mega Menu')]";
	private final String shopByCategoryXpath = "//div[@id='entry_217832']/a/span";
	private final String verifyLogoId = "entry_217821";
	private final String dashboardMenuItemXpath = "//div[@id='entry_217834']/nav/div/ul/li/a/div/span";
	private final String myAccountXpath = "(//li[@class='nav-item dropdown dropdown-hoverable'])[2]";
	private final String subMenuListFromMyAccount_Xpath = "//ul[@class='mz-sub-menu-96 dropdown-menu show']/li/a/div/span";
	private final String registerAccountPageText_Xpath="//div[@id='content']/h1";

	@FindBy(xpath = megaMenuXpath)
	private WebElement megaMenu;

	@FindBy(xpath = shopByCategoryXpath)
	private WebElement shopByCategory;

	@FindBy(id = verifyLogoId)
	private WebElement verifyLogo;

	@FindBy(xpath = dashboardMenuItemXpath)
	private List<WebElement> dashboardMenuItem;

	@FindBy(xpath = myAccountXpath)
	private WebElement myAccount;

	@FindBy(xpath = subMenuListFromMyAccount_Xpath)
	private List<WebElement> subMenuItemList;
	
	@FindBy(xpath = registerAccountPageText_Xpath)
	private WebElement registerAccountPageText;

	// return mega menu xpath
	public WebElement getMegaMenu() {
		return megaMenu;
	}

	// return shop Category type xpath
	public WebElement getShopByCategory() {
		return shopByCategory;
	}

	// return logo id
	public WebElement getVerifyLogo() {
		return verifyLogo;
	}

	// return List of menu item
	public List<WebElement> getDashboardMenuItem() {
		return dashboardMenuItem;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public List<WebElement> getSubMenuListItem() {
		return subMenuItemList;
	}

	public void clickOnRegisterButton(String value) {
		WebElement element = driver.findElement(By.xpath(
				"//ul[@class='mz-sub-menu-96 dropdown-menu show']/li/a/div/span[contains(text(),'" + value + "')]"));
		String actualValue = element.getText();
		Assert.assertEquals(actualValue, value);
		element.click();

	}
	
	public WebElement getRegisterAccountPageText() {
		return registerAccountPageText;
	}
	
	public RegisterAccountPage getRegisterAccountPage() {
		
		return new RegisterAccountPage(driver);
	}
	
	

}
