package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.PropertyFileUtilityTest;

/**
 * This class is to create Organization with Industry
 * @author Mouly
 *
 */
public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		
		PropertyFileUtilityTest pUtil = new PropertyFileUtilityTest();
		String URL = pUtil.propertyFileUtilityTest("url");
		String UN = pUtil.propertyFileUtilityTest("username");
		String PWD = pUtil.propertyFileUtilityTest("password");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("MB Visions"+JavaUtility.generateRandomNumber());
		Thread.sleep(3000);
		WebElement add = driver.findElement(By.xpath("//select[@name='industry']"));
		Select dd=new Select(add);
		dd.selectByValue("Education");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		Actions a=new Actions(driver);
		WebElement add1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		a.moveToElement(add1).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
