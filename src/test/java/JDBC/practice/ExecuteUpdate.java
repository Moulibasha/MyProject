package JDBC.practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {

	@Test
	public void executeUpate() throws Throwable
	{
		Connection con=null;
		try{
			//register database
	
				Driver dref = new Driver();
				DriverManager.registerDriver(dref);
				
				//connect to database
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				
				//create statement
				Statement stat = con.createStatement();
				
				//Execute my Query and we will get data
				int res = stat.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('4', 'shyam','gowda', 'h');");
				if(res==1)
				{
					System.out.println("Data inserted into the database");
					
				}
				else
				{
					System.out.println("Data not inserted");
					
				}
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
	
	}
}