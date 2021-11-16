
package TestScripts_21_25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseTest;
import com.vtiger.genericLib.FileLib;
import com.vtiger.genericLib.WebDriverCommonLib;

public class SearchByAlphabetsTest extends BaseTest {

	@Test
	public void searchByAlphabets() throws Throwable
	{
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(2000);
		
		WebElement element=driver.findElement(By.xpath("//select[@name=\"search_field\"]"));
		Thread.sleep(2000);
		wlib.selectOption(element, "accountname");
		Thread.sleep(2000);
		
		FileLib flib = new FileLib();
		
		String AlphaNum = flib.readPropertyData(PROP_PATH, "19");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"search_text\"]")).sendKeys(AlphaNum);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value=\" Search Now \"]")).click();
		Thread.sleep(2000);
	}
}
