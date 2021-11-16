import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority=1, enabled=false)
	public void run()
	{
		System.out.println("Run");
	}
	
	@Test(priority=2)
	public void gun()
	{
		System.out.println("Gun");
	}
	@Test(priority=0, dependsOnMethods="gun")
	public void fun()
	{
		System.out.println("Fun");
	}
	
	
	
	
}
