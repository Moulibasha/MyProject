package com.vtiger.genericLib;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IPathConsts {

	public static WebDriver driver;
	FileLib flib = new FileLib();
	
	//@Parameters("browser")
	@BeforeClass
	
	//Opening the Browser
	public void openBrowser() throws Throwable
	{

		String browserValue = flib.readPropertyData(PROP_PATH, "browser");

		if(browserValue.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}

		else if(browserValue.equalsIgnoreCase("Firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();

		}

		else
		{
			System.out.println("Enter Proper Browser Name");

		}
		driver.manage().window().maximize();
	}

	@BeforeMethod
	
	//Logging In
	public void login() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String appUrl = flib.readPropertyData(PROP_PATH, "url");
		driver.get(appUrl);
		String UN = flib.readPropertyData(PROP_PATH, "username");
		String PWD = flib.readPropertyData(PROP_PATH, "password");
		
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	}

	@AfterMethod
	
	//Signing Out
	public void logout() throws Throwable
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Actions a=new Actions(driver);

		WebElement add = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		a.moveToElement(add).perform();

		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}

	@AfterClass
	
	//Closing the Browser
	public void closeBrowser()
	{
		driver.quit();
	}

}