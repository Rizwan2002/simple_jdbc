package com.tcs.jdbc_simple_crud_operation_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDisplayController {

	static Connection connection = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

			// Write a query to display the data
			String select_query = "select * from student";

			// Step 4: Execute Query (execute-> for both DML and SELECT,executeUpdate->
			// DML,executeQuery-> SELECT Operation)
			ResultSet resultSet = st.executeQuery(select_query);
			if (resultSet != null) {
				while (resultSet.next()) {
					// either we can pass parameter or position (according to table) in getInt or
					// getString
					System.out.println(resultSet.getInt("id") + " " + resultSet.getString(2) + " "
							+ resultSet.getString("email") + " " + resultSet.getInt("phoneno"));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
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
