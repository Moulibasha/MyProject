import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestAnnotations {

	@BeforeSuite
	public void connectToDB()
	{
		System.out.println("Connect to database");
	}
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("Open the Browser");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login to app");
	}
	@Test
	public void createOrg()
	{
	System.out.println("Create the Org");
	}
	
	@Test
	public void modifyOrg()
	{
	System.out.println("Modify the Org");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout to app");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close the Browser");
	}
	
	@AfterSuite
	public void disconnectToDB()
	{
		System.out.println("disconnect to database");
	}
}
