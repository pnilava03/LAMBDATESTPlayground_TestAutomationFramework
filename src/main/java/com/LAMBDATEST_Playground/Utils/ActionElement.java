/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**@author NILAVA PAL
 * 
 */
public class ActionElement {
	
	//private WebDriver driver;
	
	private ActionElement() {
		
	}
	
	/**
	 * This method is responsible for is element present in the application or not.
	 * If element present the return true else it will return false
	 * @param element
	 * @return
	 */
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
		}
	
	/**
	 * this method is responsible for to get the Title of the application
	 * @param driver
	 * @return
	 */
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * this method is responsible hover the mouse
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
		int count=elements.size();
		return count;
		}
	
	/**
	 * 
	 * @param elements
	 * @return ArrayList of String
	 */
	public static List<String> getListOfElements(List<WebElement> elements) {
		ArrayList<String> listOfitems= new ArrayList<String>();
		List<WebElement> listofData=elements;
		for(WebElement element: listofData) {
			listOfitems.add(element.getText());
			}
		return listOfitems;
	}
	
	
	public static String getAttribute(WebElement element, String value) {
		
		return element.getDomAttribute(value);
	}
	
	public static void waitForElementTobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();;
	}
	
	
	public static void waitForAlertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitForvisibilityOfElement(WebDriver driver, WebElement wb) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(wb)));
	}
}


