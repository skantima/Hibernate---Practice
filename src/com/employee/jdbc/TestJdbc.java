package com.employee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_tracker?useSSL=false";
		String user = "employeetest";
		String pass = "employeetest";
		
		try {
			System.out.println("Connecting to Database... " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection established !!");
		} 
		
		catch (Exception exc) {
			
			exc.printStackTrace();
		}
	}
}
