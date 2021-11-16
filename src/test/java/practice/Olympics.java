package practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Olympics {

	public static void main(String[] args) throws Throwable {
	
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/");
		driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
		WebElement add = driver.findElement(By.xpath("//h2[text()=\"Featured\"]"));
		Point loc = add.getLocation();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy"+loc);
		List<WebElement> all = driver.findElements(By.xpath("//a[@class=\"featured-athlete__name d-flex text-body\"]"));
		for(WebElement one:all)
		{
			String name = one.getText();
			System.out.println(driver.findElement(By.xpath("//span[text()='"+name+"']")).getText());
			System.out.println("-----M E D A L S-----");
			System.out.println(driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::ul/li[1]//"
					+ "div[@class=\"featured-athlete__medals text-body-sm\"]")).getText());
			
		}
		
		driver.close();
	}
	 
	 
}
