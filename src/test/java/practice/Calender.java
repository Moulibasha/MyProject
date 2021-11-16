
package practice;

import java.util.Date;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calender {

	
	 @Test(dataProvider="getValue")
	 public void mmt(String src, String dest) throws InterruptedException
	 {
		Date date=new Date();
		//System.out.println(date);
		//Wed Nov 10 14:51:40 IST 2021
		String d = date.toString();
		String[] arr = d.split(" ");
		String day = arr[0];
		String mon = arr[1];
		String currdate = arr[2];
		String year = arr[5];
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();
		driver.findElement(By.xpath("//li[@data-cy=\"account\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"From\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys(src);
		driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys(dest);
		driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();
		driver.findElement(By.xpath("//span[text()=\"DEPARTURE\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+mon+" "+currdate+" "+year+"']")).click();
		driver.close();
	}
	 
	 @DataProvider
	 public Object[][] getValue()
	 {
		 Object arr[][]=new Object[4][2];
		 
		 arr[0][0]="PNQ";
		 arr[0][1]="HYD";
		 
		 arr[1][0]="PNQ";
		 arr[1][1]="BOM";
		 
		 arr[2][0]="HYD";
		 arr[2][1]="PNQ";
		 
		 arr[3][0]="BOM";
		 arr[3][1]="HYD";
		 
		 return arr;
	 }

}
