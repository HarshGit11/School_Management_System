package com.gi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.gi.dto.AdminDTO;
import com.gi.ui.Main;

public class AdminDAO {
	Scanner sc = new Scanner(System.in);
	public boolean adminLogin(AdminDTO adminDTO) throws SQLException
	{
		String sql = "select * from admindetails where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, adminDTO.getEmail());
		preparedStatement.setString(2, adminDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		return rs.next();
	}
	public void calculateSalary(AdminDTO adminDTO) throws SQLException
	{
			String sql = "select * from admindetails where email = ? and password = ?";
			
			Connection con = DBConnection.getConnection();
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, adminDTO.getEmail());
			preparedStatement.setString(2, adminDTO.getPassword());
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				System.out.println("Salary:"+rs.getInt("hourlyRate")*rs.getInt("hoursWorked"));
				
			}
			else {
				System.out.println("No record found!");
			}
	}
}
