package com.tcs.jdbc_simple_crud_operation_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdateController {

	static Connection connection = null;

	public static void main(String[] args) {
		try {
			// Step 1: Load/Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Create the Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a5";
			String username = "root";
			String password = "Rizwan@123";
			connection = DriverManager.getConnection(url, username, password);

			// Step 3: Create the Statement
			Statement st = connection.createStatement();

			// Write a query to update the data
			String update_Student_Phoneno_Query = "update student set phoneno=95959595 where id=111";
			
			// Step 4: Execute Query
			// (execute-> for both DML and SELECT, executeUpdate-> DML, executeQuery->SELECT Operation)
			int result = st.executeUpdate(update_Student_Phoneno_Query);
			if (result != 0) {
				System.out.println("Data Updated");
			} else
				System.out.println("Given data is not found");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			// Step 5: Close the connection
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

}
