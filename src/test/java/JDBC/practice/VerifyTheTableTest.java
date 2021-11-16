package JDBC.practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheTableTest {

	@Test
	public void verifyTheTableTest() throws SQLException
	{
		Connection con=null;
		try {
		String expected="ram";
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		Statement stat = con.createStatement();
		
		ResultSet res = stat.executeQuery("select * from students_info;");
		boolean flag=false;
		while(res.next())
		{
			String actualData = res.getString(2);
			if(actualData.equals(expected))
					{
				System.out.println(expected+" is present");
				flag=true;
				break;
					}
		}
		Assert.assertEquals(flag, true);
		}
		
	catch (Exception e) {
		// TODO: handle exception
	}
		finally {
		System.out.println("Connection has been closed");
			con.close();
							
		}
		
	}}

