package TestScripts_21_25;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider
	public Object[][] db()
	{
		Object[][] obj = new Object[3][2];
		
		obj[0][0]="Mouli";
		obj[0][1]=123;
		
		obj[1][0]="Arjun";
		obj[1][1]=456;
		
		obj[2][0]="Satya";
		obj[2][1]=789;
		
		return obj;
		
	}
	@Test(dataProvider="db")
	
	public void details(String username, int amount)
	{
		Reporter.log("Name of the user: "+username+" Amount is :"+amount, true);
	}
}
