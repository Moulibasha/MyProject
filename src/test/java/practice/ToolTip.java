package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lenskart.com/");
		WebElement c = driver.findElement(By.xpath("//img[@src=\"https://static.lenskart.com/media/mobile/images/lkLogo.svg\"]"));
		Thread.sleep(3000);
		System.out.println(c.getAttribute("title"));
//		WebElement d = driver.findElement(By.xpath("//span[text()=\"Track Order\"]/../.."));
//		Thread.sleep(3000);
//		System.out.println(d.getAttribute("title"));
		System.out.println(driver.findElement(By.xpath("//span[text()=\\\"Track Order\\\"]/../..")).getAttribute("title"));
		driver.close();
	}

}
