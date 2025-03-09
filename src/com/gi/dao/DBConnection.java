package com.gi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static String URL = "jdbc:mysql://localhost:3306/schoolManagementAPK_1";
	public static String USER = "root";
	public static String PASSWORD = "root";
	
	
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	
	public static Connection getConnection() throws SQLException
	{
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		return con;
	}
	
	private DBConnection()
	{}
}
