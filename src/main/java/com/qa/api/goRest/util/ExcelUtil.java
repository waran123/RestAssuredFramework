package com.qa.api.goRest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String Testdata_sheet_path = "C:\\Users\\vigneshwaranv\\eclipse-workspace\\RestAssuredAutomationFrameWork\\src\\main\\java\\com\\qa\\api\\goRest\\testData\\TestData.xlsx";


	static Workbook book ;
	public static org.apache.poi.ss.usermodel.Sheet sheet ;

	public static Object[][] getTestData(String sheetName) {
		
		try {
			FileInputStream fis = new FileInputStream(Testdata_sheet_path) ;
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
		}
		catch (IOException | EncryptedDocumentException  e) {
			e.printStackTrace();
		}

		Object ob[][] = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];



		for(int i = 0 ; i<sheet.getLastRowNum();i++) {
			for(int j= 0 ;j<sheet.getRow(0).getLastCellNum();j++) {
				ob[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return ob ;	
	}
}
