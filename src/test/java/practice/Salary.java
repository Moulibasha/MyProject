package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Salary {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./Data/TData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lrn = wb.getSheet("Sheet1").getLastRowNum();
		for(int i=1;i<=lrn;i++)
		{
			double sal = wb.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue();
			if(sal>49000)
			{
				System.out.println(wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue()+" "+sal);
			}
		
		
		}
		
}
}
