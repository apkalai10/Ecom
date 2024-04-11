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
			//String url = "jdbc:sqlserver://localhost:1433;authenticationScheme=NTLM;databaseName=arvind;encrypt=true;trustServerCertificate=true;domain=myDomain"
			String url = "jdbc:sqlserver://localhost:1433;databaseName=arvind;trustServerCertificate=true";
			Connection con = DriverManager.getConnection(url, "Tomcat", "Tomcat@2023");
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("select * from student");
	
			while(rs.next())
			{
				System.out.println("name = " + rs.getString("s_name"));
				
			}
			state.executeUpdate("insert into student(s_name) values('rachel')");
			
			ResultSet rs1 = state.executeQuery("select s_dob from student where s_roolno=4");
			rs1.next();
			Date date = rs1.getDate("s_dob");
			System.out.println(date);
			con.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
