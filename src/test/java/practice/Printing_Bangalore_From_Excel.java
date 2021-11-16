package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Printing_Bangalore_From_Excel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./Data/TData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("Location is "+wb.getSheet("Sheet1").getRow(2).getCell(3).getStringCellValue());

		
	}
	

}
