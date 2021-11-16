package com.vtiger.testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.PropertyFileUtilityTest;

/**
 * This is to create Contact
 * @author Mouly
 *
 */

public class CreateContactWithOrganisation {

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
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(3000);
		WebElement salutation=driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select sel=new Select(salutation);
		sel.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Arjun"+JavaUtility.generateRandomNumber());
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Set<String> allwh = driver.getWindowHandles();
		 System.out.println(allwh.size());
			String parentTitle=driver.getTitle();
			String pw=driver.getWindowHandle();
			for(String wh:allwh)
			{
				String title=driver.switchTo().window(wh).getTitle();
				if(!title.equals(parentTitle))
				{
					driver.switchTo().window(wh);
					Thread.sleep(2000);
					driver.findElement(By.id("1")).click();
				}

				driver.switchTo().window(pw);		
			}

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			Thread.sleep(3000);
			Actions ac=new Actions(driver);
			WebElement icon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			ac.moveToElement(icon).perform();
			Thread.sleep(2000);
			WebElement out=driver.findElement(By.xpath("//a[text()='Sign Out']"));
			out.click();
			
			Thread.sleep(3000);
			driver.close();
			
	}
	}