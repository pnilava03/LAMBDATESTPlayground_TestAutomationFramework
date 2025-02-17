/**
 * 
 */
package com.LAMBDATEST_Playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */
public class Checking {

	/**
	 * @param args
	 */
	
	private static WebDriver driver;
	public static void main(String[] args) {
//		System.getProperties().list(System.out);
//		
//		System.out.println("Hello");
//		driver.findElement(By.xpath("")).sendKeys("");
		driver= new ChromeDriver();
		
		for(Object obj : driver.getClass().getMethods()) {
			System.out.println(obj.getClass().getName());
		}
		
		
		

	}
	
	
//	public static <T extends WebDriver> void main() {
//		Runtime.getRuntime().addShutdownHook(new Thread());
//
//}
	
	
	
	
}
