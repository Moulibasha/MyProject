package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VTigerTable2 {

	//public static void main(String[] args) throws Throwable {
		@Test
		public void vtiger() throws InterruptedException {
			
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		List<WebElement> data = driver.findElements(By.xpath("//table[@class=\"lvt small\"]//tr[*]//td[1]"));
		System.out.println(data.size());
		for(int i=4; i<data.size();i++)
		{
			driver.findElement(By.xpath("//table[@class=\"lvt small\"]//tr['"+i+"']//td[1]")).click();
			Thread.sleep(2000);
		}
		
		driver.close();
	}

}
