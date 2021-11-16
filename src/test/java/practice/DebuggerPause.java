package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebuggerPause {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"What are you looking for \"]")).click();
		List<WebElement> data = driver.findElements(By.xpath("//ul[@class=\"trending_list menu-link\"]"));
		for(WebElement one:data)
		{
			System.out.println("----Trend Search----");
			System.out.println(one.getText());
		}
		driver.close();
	}

}
