package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mobiles {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobiles under 15000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id=\"p_89/Samsung\"]//i[@class=\"a-icon a-icon-checkbox\"]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li[@id=\"p_89/MI\"]//i[@class=\"a-icon a-icon-checkbox\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li[@id=\"p_89/MI\"]//i[@class=\"a-icon a-icon-checkbox\"]")).click();
//		Thread.sleep(2000);
		//driver.findElement(By.xpath("//li[@id=\"p_89/MI\"]")).click();
		
		driver.close();
	}

}
