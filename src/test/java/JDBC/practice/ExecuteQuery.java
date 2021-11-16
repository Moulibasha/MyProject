package JDBC.practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {

	@Test
	public void executeQueryTest() throws Throwable
	{
		//register database
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		
		//connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//create statement
		Statement stat = con.createStatement();
		
		//Execute my Query and we will get data
		ResultSet res = stat.executeQuery("select * from students_info;");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
		}
		
		//close the connection
		con.close();
	}
}
