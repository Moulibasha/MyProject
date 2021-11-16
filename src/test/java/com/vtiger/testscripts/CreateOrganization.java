package com.vtiger.testscripts;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.vtiger.genericLib.JSONFileUtility;
import com.vtiger.genericLib.JavaUtility;
import com.vtiger.genericLib.WebDriverUtility;

/**
 * This class is to create Organization
 * @author Mouly
 *
 */
public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String orgName = "MK Foundation";
		JSONFileUtility jUtil=new JSONFileUtility();
		String URL = jUtil.jsonFileUtility("url");
		String UN = jUtil.jsonFileUtility("username");
		String PWD = jUtil.jsonFileUtility("password");
		driver.get(URL);
		wUtil.maximizeWindow(driver);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName+JavaUtility.generateRandomNumber());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		Reporter.log("Saved");
		
		WebElement orgInfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]"));
		String OrganizationInfo = orgInfo.getText();
		Assert.assertTrue(OrganizationInfo.contains(orgName));
		System.out.println("verified");
		Actions a=new Actions(driver);
		WebElement add = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		a.moveToElement(add).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		Thread.sleep(3000);
		Reporter.log("SignedOut", true);
		driver.close();
	}

}
