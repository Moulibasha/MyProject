package DDT.practice;

import java.io.FileInputStream;

import java.util.Properties;

import org.testng.annotations.Test;


public class ReadTheDataFromPropertiesFileTest {

	@Test
	public void readTheDataFromPropertiesFileTest() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PWD=p.getProperty("password");
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
		
		
	}
}
