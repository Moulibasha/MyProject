package practice;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchingToFrames {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for(String window:allWin)
		{
			String Title = driver.switchTo().window(window).getTitle();
			
			if(Title.equalsIgnoreCase("Cognizant"))
				{
				driver.manage().window().maximize();
				driver.close();
				break;
				}
		
		}
		
		driver.switchTo().window(parentwin);
		driver.close();
		
}
}
