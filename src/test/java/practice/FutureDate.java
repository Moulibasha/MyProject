package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FutureDate {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable {
	
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class=\"langCardClose\"]")).click();
		driver.findElement(By.xpath("//li[@data-cy=\"account\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"DEPARTURE\"]")).click();
		try
		{
			for(int i=1; i<=11;i++)
			{
				
			driver.findElement(By.xpath("//div[@aria-label=\"Sat Apr 02 2022\"]")).click();
			break;
			}
			
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
			Thread.sleep(2000);
			
		}
		
		//driver.close();
	}
	 
	 
}
