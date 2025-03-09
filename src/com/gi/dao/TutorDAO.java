package com.gi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gi.dto.TutorDTO;
import com.gi.model.Tutor;
import java.util.Scanner;

public class TutorDAO 
{
	Scanner sc = new Scanner(System.in);
	public TutorDAO() throws SQLException{
		String sql = "create table if not exists tutor_details(tutor_id int auto_increment primary key,age int not null,address varchar(20) not null,email varchar(20) unique not null,password varchar(20) not null,specialization varchar(20) not null,monthlySalary int not null,classesAssigned int not null)";
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		int z = preparedStatement.executeUpdate();
	}
	
	public boolean addtutor(Tutor t) throws SQLException{
		String sql = "insert into tutor_details(age,address,email,password,specialization,monthlySalary,classesAssigned) values(?,?,?,?,?,?,?)";
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		preparedStatement.setInt(1,t.getAge());
		preparedStatement.setString(2,t.getAddress());
		preparedStatement.setString(3,t.getEmail());
		preparedStatement.setString(4,t.getPassword());
		preparedStatement.setString(5,t.getSpecialization());
		preparedStatement.setFloat(6,t.getMonthlySalary());
		preparedStatement.setInt(7,t.getClassesAssigned());
		
		int y = preparedStatement.executeUpdate();
		return true;
	}
	
	public boolean tutorLogin(TutorDTO tutorDTO) throws SQLException
	{
		String sql = "select * from tutor_details where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, tutorDTO.getEmail());
		preparedStatement.setString(2, tutorDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		return rs.next();
	}
	
	public void tutorSalary(TutorDTO tutorDTO) throws SQLException{
		String sql = "select * from tutor_details where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, tutorDTO.getEmail());
		preparedStatement.setString(2, tutorDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		if(rs.getInt("classesAssigned")>5) {
			float Bonus = rs.getFloat("monthlySalary")*0.10f;
			float Bonus_Salary = rs.getFloat("monthlySalary")+Bonus;
			System.out.println("Salary:"+Bonus_Salary);
		}
		else {
			System.out.println("Salary:"+rs.getFloat("monthlySalary"));
		}
	}
	
	public void tutorAssignClass(TutorDTO tutorDTO) throws SQLException{
		String sql = "select classesAssigned from tutor_details where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, tutorDTO.getEmail());
		preparedStatement.setString(2, tutorDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		System.out.println("Enter no.classes you want to add:");
		int c = sc.nextInt();
		
		int totalClassesAssigned = rs.getInt("classesAssigned")+c;
		
		String sql1 = "update tutor_details set classesAssigned=? where email = ? and password = ?";
		Connection con1 = DBConnection.getConnection();
		
		PreparedStatement preparedStatement1 = con1.prepareStatement(sql1);
		preparedStatement1.setInt(1, totalClassesAssigned);
		preparedStatement1.setString(2, tutorDTO.getEmail());
		preparedStatement1.setString(3, tutorDTO.getPassword());
		int z = preparedStatement1.executeUpdate();
		
		
		System.out.println("Total classes Assigned:"+totalClassesAssigned);
		//rs.classesAssigned = rs.getInt("classesAssigned")+n;
	}
}
