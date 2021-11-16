package com.vtiger.genericLib;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	//Printing single value from excel sheet
		public String readExcelData(String excelpath, String sheetname, int row, int cell) throws Throwable {
			FileInputStream fis = new FileInputStream(excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			String excelvalue=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue().toString();
			return excelvalue;
		
		}
		//Printing RowCount
		public int getRowCount(String excelpath, String sheetname) throws Throwable {
			FileInputStream fis=new FileInputStream(excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			int rc=wb.getSheet(sheetname).getLastRowNum();
			return rc;
			
			
		}
		//To write data in excel
		public String WriteDataInExcel(String sheetname, int row, int cell, String excelpath, String data) throws Throwable {
			FileInputStream fis = new FileInputStream(excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(data);
			
			FileOutputStream fo = new FileOutputStream(excelpath);
			wb.write(fo);
			return data;
			
			
		}
		
		//Merging DataDriven & keyword Driven
		//Keyword Driven Program taken
		public String readPropertyData(String propPath, String Key) throws Throwable
		{
			FileInputStream fis = new FileInputStream(propPath);
			Properties prop = new Properties();
			prop.load(fis);
			String propValue = prop.getProperty(Key, "Incorrect Key");
			return propValue;
			
			
	

}
}