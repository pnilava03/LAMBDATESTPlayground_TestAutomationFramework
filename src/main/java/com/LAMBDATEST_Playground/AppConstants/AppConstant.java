/**
 * 
 */
package com.LAMBDATEST_Playground.AppConstants;

import org.openqa.selenium.WebElement;

/**
 * @author NILAVA PAL
 */
public interface AppConstant {

	
	public static final String FILE_NAME="testConfig";
	public static final String EXTENT_FILE_NAME="extent";
	public static final String REPORTFILE_NAME="LT_Playground_Automation_Report" ;
	public static final String DOCUMENT_TITLE_NAME="LAMBDATEST PlayGround";
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	
	
	public static void sendKeys(CharSequence enterKeys) {}
	
	public void hoverTheMouse(AppConstant app, WebElement element);

	
}
