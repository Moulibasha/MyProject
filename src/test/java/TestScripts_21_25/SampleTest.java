package TestScripts_21_25;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseTest;

@Listeners(com.vtiger.genericLib.ListenerImp.class)
public class SampleTest extends BaseTest {
	
	@Test
	public void intentionalError()
	{
		System.out.println(10/0);
	}
	@Test
	public void arithmeticCal()
	{
		int i=10, j=1, k;
		k=i/j;
		System.out.println(k);
	}
}
