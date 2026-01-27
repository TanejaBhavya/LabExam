package com.traineeManagement.util;
import java.sql.*;

public class ConnectionFactory {

	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return connection;
	}
}