/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;

/**
 * @author NILAVA PAL
 * 
 */
public class ActionElement {

	private static WebDriver driver;

	private ActionElement() {

	}

	/**
	 * This method is responsible for is element present in the application or not.
	 * If element present the return true else it will return false
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * this method is responsible for to get the Title of the application
	 * 
	 * @param driver
	 * @return
	 */
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	
	public static String getCurrentPageURL() {
		return	driver.getCurrentUrl();
	}

	/**
	 * this method is responsible hover the mouse
	 * 
	 * @param element
	 * @param driver
	 */
	public static void mouseHover(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * 
	 * @param element
	 * @return element getText
	 */
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	
	

	/**
	 * 
	 * @param elements
	 * @return count
	 */

	public static int getElementsCount(List<WebElement> elements) {
		int count = elements.size();
		return count;
	}

	/**
	 * 
	 * @param elements
	 * @return ArrayList of String
	 */
	public static List<String> getListOfElements(List<WebElement> elements) {
		ArrayList<String> listOfitems = new ArrayList<String>();
		List<WebElement> listofData = elements;
		for (WebElement element : listofData) {
			listOfitems.add(element.getText());
		}
		return listOfitems;
	}

	public static String getAttribute(WebElement element, String value) {

		return element.getDomAttribute(value);
	}

	/**
	 * this method is use for implicitlyWait
	 * 
	 * @param driver
	 * @param time
	 */
	public static void implicitWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time * 1000));
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 * @return This method returns a WebElement if the element is present on the UI
	 *         page within the specified duration.
	 */
	public static WebElement waitForElementTobeClickable(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time * 1));
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * 
	 * @param driver
	 * @param time
	 * @return
	 */
	public static Alert waitForAlertIsPresent(WebDriver driver, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * 
	 * @param driver
	 * @param time
	 * @param wb
	 * @return This method will return boolean value whether element is present on
	 *         UI page or not
	 */
	public static boolean waitForvisibilityOfElement(WebDriver driver, int time, WebElement wb) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(wb)));
	}

	/**
	 * 
	 * @param driver
	 * @param time
	 * @param element
	 * @return This method will return boolean value when pop up
	 */

	public static boolean waitForPopUpDisappear(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time * 1));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));

	}

	public static WebElement elementToBeVisible(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time * 1));
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));

	}

	public static WebElement isElementPresent(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time * 1));
		return wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

	}

	public static boolean waitForElementToBeLoad(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time * 1));
		return wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	
	
}
