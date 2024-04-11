package com.webdriver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {

	public static void main(String[] args)   {
		try {
			//String url = "jdbc:sqlserver://localhost:1433;authenticationScheme=NTLM;databaseName=arvind;encrypt=true;trustServerCertificate=true;domain=myDomain";
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=arvind;trustServerCertificate=true";
			String username="Tomcat";
			String password="Tomcat@2023";
			Connection connection = DriverManager.getConnection(connectionUrl, username, password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from student");
	
			while(rs.next())
			{
				System.out.println("name = " + rs.getString("s_name"));
				
			}
			statement.executeUpdate("insert into student(s_name) values('rachel')");
			
			ResultSet rs1 = statement.executeQuery("select s_dob from student where s_roolno=4");
			rs1.next();
			Date date = rs1.getDate("s_dob");
			System.out.println(date);
			connection.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
