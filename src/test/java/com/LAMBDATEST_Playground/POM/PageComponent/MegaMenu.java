/**
 * @author NILAVA PAL
 */
package com.LAMBDATEST_Playground.POM.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LAMBDATEST_Playground.POM.AccountPage;


/**
 * 
 */
public class MegaMenu extends AccountPage{

	private WebDriver driver;
	
	public MegaMenu(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}

	private final String megaMenu_xpath = "//span[contains(text(),'Mega Menu')]";
	
	@FindBy(xpath = megaMenu_xpath)
	private WebElement megaMenu;

	public WebElement getMegaMenu() {
		return megaMenu;
	}

	

	
	
	

}
