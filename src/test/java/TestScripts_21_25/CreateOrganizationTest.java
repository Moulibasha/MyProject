package TestScripts_21_25;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseTest;
import com.vtiger.genericLib.JavaUtility;

public class CreateOrganizationTest extends BaseTest{

	@Test
	public void createOrganization() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("MK Foundation"+JavaUtility.generateRandomNumber());

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
