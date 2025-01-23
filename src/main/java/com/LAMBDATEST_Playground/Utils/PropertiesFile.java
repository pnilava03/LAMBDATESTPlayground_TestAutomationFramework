/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;

/**
 * 
 */
public class PropertiesFile {

	Properties prop = new Properties();

	public PropertiesFile() throws FileNotFoundException {

//		System.out.println(
//				AppConstant.PROJECT_PATH + "\\resourcesLibs\\configs\\" + AppConstant.FILE_NAME + ".properties");
		try {
			prop.load(new FileInputStream(
					AppConstant.PROJECT_PATH + "\\resourcesLibs\\configs\\" + AppConstant.FILE_NAME + ".properties"));
		} catch (IOException e) {
			throw new FileNotFoundException("Opps!!!! Properties file is not available in the location path !!!" + e);

		}

	}

	public PropertiesFile(String reportFileName) throws FileNotFoundException {
		//System.out.println(AppConstant.PROJECT_PATH + "\\src\\test\\java\\" + reportFileName + ".properties");
		try {
			prop.load(new FileInputStream(
					AppConstant.PROJECT_PATH + "\\src\\test\\java\\" + reportFileName + ".properties"));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Opps!!!! Properties file is not available in the location path !!!" + e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPropertiesValue(String key) {
		return prop.getProperty(key);

	}

}
