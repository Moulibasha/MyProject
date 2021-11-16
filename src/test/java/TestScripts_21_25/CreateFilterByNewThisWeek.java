package TestScripts_21_25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseTest;
import com.vtiger.genericLib.WebDriverCommonLib;

public class CreateFilterByNewThisWeek extends BaseTest {

	@Test
	public void searchByAlphabets() throws InterruptedException
	{

		WebDriverCommonLib wlib = new WebDriverCommonLib();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("//select[@id=\"viewname\"]"));
		wlib.selectOption(element, "6");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()=\"Create Filter\"]")).click();
		Thread.sleep(4000);

	}

}
