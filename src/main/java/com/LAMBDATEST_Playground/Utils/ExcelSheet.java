/**
 * 
 */
package com.LAMBDATEST_Playground.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.LAMBDATEST_Playground.AppConstants.AppConstant;

/**
 * 
 */
public class ExcelSheet {

	/**
	 * @param args
	 */
	private static PropertiesFile prop;
	private static FileInputStream fis;
	private static Workbook workbook;
	private static Sheet sheet;
	private static Row row;
	private static Cell keyCell;
	private static Cell cellValue;

	private String excelFileName;

	public ExcelSheet(String excelFileName) {
		if (excelFileName.isEmpty() & excelFileName.isBlank()) {
			throw new NullPointerException(
					"Please specify the excel fileName in testConfig Properties file:: " + excelFileName);
		} else {
			try {
				fis = new FileInputStream(
						new File(AppConstant.PROJECT_PATH + AppConstant.testDataFilePath + excelFileName));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
			this.excelFileName = excelFileName;
		}
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public int getSheetCount() throws IOException {
		int numberOfSheet = workbook.getNumberOfSheets();
		return numberOfSheet;

	}

	public List<String> getExcelSheetName() {
		List<String> list = new ArrayList<String>();
		int numberOfSheet = 0;
		try {
			numberOfSheet = getSheetCount();
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (int i = 0; i <= numberOfSheet - 1; i++) {
			list.add(workbook.getSheetName(i));

		}
		return list;

	}

	public int rowCount(String sheetName) {
		int totalRowCount = 0;
		List<String> list = getExcelSheetName();
		for (int i = 0; i < list.size(); i++) {
			if (sheetName.equals(list.get(i))) {
				sheet = workbook.getSheet(list.get(i));
				totalRowCount = sheet.getLastRowNum();

			}
		}
		return totalRowCount;
	}

	public List<Integer> cellCount(String sheetName) {
		List<Integer> list = new ArrayList<Integer>();
		int totalRow = rowCount(sheetName);

		for (int i = 0; i <= totalRow; i++) {

			list.add(i);
//			
		}

		return list;
	}

	/**
	 * Multiple column single row
	 * @param sheetName
	 * @param key
	 */
	public void cellValue(String sheetName, String key) {
		String value="";
		Map<String, String> map = new HashMap<String, String>();
		int totalRow= rowCount(sheetName);
		System.out.println("Total Row:: "+totalRow);

			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				
				key= sheet.getRow(0).getCell(j).getStringCellValue().trim();
			
				value=sheet.getRow(1).getCell(j).getStringCellValue();
			
				map.put(key, value);

				}
}

	public Map<String, List<String>> getCellValue(String sheetName, String key) {
		String value = "";
		List<String> listOfKey=new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> list= new ArrayList<String>();
		List<List<String>> list1= new ArrayList<List<String>>();
		
		int totalRow = rowCount(sheetName);
		System.out.println("Total Row:: " + totalRow);
		
		
		//for(int i=1;i<=sheet.getLastRowNum();i++) {
			list1.add(list);
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				

			key = sheet.getRow(0).getCell(j).getStringCellValue().trim();
			listOfKey.add(key);
			
			//list.add(sheet.getRow(i).getCell(i).getStringCellValue());
			

		}
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				int c=0;
				for(int i=1;i<=sheet.getLastRowNum();i++) {
				list.add(sheet.getRow(i).getCell(k).getStringCellValue());
				}
				list1.add(list);
				//System.out.println(list1.get(k));
				System.out.println(list);
				map.put(listOfKey.get(k), list1.get(c++));
			
			//	list1.clear();
				
			}
		
		//	list.removeAll(list);
		

	//}
	return map;

	}

	public static void main(String[] args) throws IOException {

		try {
			prop = new PropertiesFile();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		ExcelSheet excel = new ExcelSheet(prop.getPropertiesValue("ExcelFileName"));
		String fileName = excel.getExcelFileName();
		System.out.println(fileName);

		int sheetNumber = excel.getSheetCount();
		System.out.println("Number of Sheet ::" + sheetNumber);
		List<String> list = excel.getExcelSheetName();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Excel sheet Name:: " + list.get(i).toString());

		}

		int rowCount = excel.rowCount("Sheet1");
		System.out.println("Row count is:: " + rowCount);
		List<Integer> list1 = excel.cellCount("Sheet1");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("cell Count is:: " + list1.get(i));
		}

		//excel.cellValue("Sheet1", "Password");
		
	System.out.println(excel.getCellValue("Sheet1", "Password"));

	}
}
