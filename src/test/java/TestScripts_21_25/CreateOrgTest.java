package TestScripts_21_25;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.genericLib.FileLib;
import com.vtiger.genericLib.IPathConsts;
import com.vtiger.genericLib.JavaUtility;

public class CreateOrgTest implements IPathConsts{
	

	@Test
	public void createOrganization() throws Throwable
	
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		FileLib flib=new FileLib();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String appUrl = flib.readPropertyData(PROP_PATH, "url");
		driver.get(appUrl);
		String UN = flib.readPropertyData(PROP_PATH, "username");
		String PWD = flib.readPropertyData(PROP_PATH, "password");
		
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("MK Foundation"+JavaUtility.generateRandomNumber());

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions a=new Actions(driver);

		WebElement add = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		a.moveToElement(add).perform();

		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.quit();

	}

}
