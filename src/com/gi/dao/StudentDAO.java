package com.gi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gi.dto.StudentDTO;
import com.gi.model.Student;
import java.util.Scanner;

public class StudentDAO {
	Scanner sc = new Scanner(System.in);
	public StudentDAO() throws SQLException
	{
		String sql = "create table if not exists student_details(student_id int auto_increment primary key not null ,email  varchar(20) unique not null,password varchar(20) not null,age int not null,address varchar(30) not null,gradeLevel varchar(20) not null,subjects varchar(20) not null,feespaid int not null)";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
	
		
		int z = preparedStatement.executeUpdate();
		
	}
	
	public boolean addstudent(Student s) throws SQLException
	{
		String sql = "insert into student_details(email  ,password ,age ,address ,gradeLevel ,subjects ,feespaid) values(?,?,?,?,?,?,?)";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, s.getEmail());
		preparedStatement.setString(2, s.getPassword());
		preparedStatement.setInt(3, s.getAge());
		preparedStatement.setString(4, s.getAddress());
		preparedStatement.setString(5, s.getGradeLevel());
		preparedStatement.setString(6, s.getSubjects());
		preparedStatement.setFloat(7, s.getFeesPaid());
		int  y = preparedStatement.executeUpdate();
		return true;
		
	}
	
	public void viewStudents() throws SQLException{
		String sql = "select * from student_details";
		
		Connection con = DBConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet studentResultSet = preparedStatement.executeQuery();
		
		while(studentResultSet.next()) {
			System.out.println("Student_ID:"+studentResultSet.getInt("student_id"));
			System.out.println("email:"+studentResultSet.getString("email"));
			System.out.println("password:"+studentResultSet.getString("password"));
			System.out.println("age:"+studentResultSet.getInt("age"));
			System.out.println("address:"+studentResultSet.getString("address"));
			System.out.println("gradeLevel:"+studentResultSet.getString("gradeLevel"));
			System.out.println("subjects:"+studentResultSet.getString("subjects"));
			System.out.println("feespaid:"+studentResultSet.getFloat("feespaid"));
		}
	}
	
	public boolean studentLogin(StudentDTO studentDTO) throws SQLException
	{
		
		String sql = "select * from student_details where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, studentDTO.getEmail());
		preparedStatement.setString(2, studentDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		return rs.next();
	}
	
	public void studentCalculateFeesRemaining(StudentDTO studentDTO) throws SQLException{
		String sql = "select * from student_details where email = ? and password = ?";
		
		Connection con = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, studentDTO.getEmail());
		preparedStatement.setString(2, studentDTO.getPassword());
		
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.next();
		Float ReaminingFees = 0.0f;
		if(rs.getString("subjects").equalsIgnoreCase("maths")) {
			ReaminingFees = 12000-rs.getFloat("feespaid"); 
			System.out.println("Reamining Fees:"+ReaminingFees);
		}
		else if(rs.getString("subjects").equalsIgnoreCase("science")) {
			ReaminingFees = 15000-rs.getFloat("feespaid"); 
			System.out.println("Reamining Fees:"+ReaminingFees);
		}
		else if(rs.getString("subjects").equalsIgnoreCase("Social Science")) {
			ReaminingFees = 13000-rs.getFloat("feespaid"); 
			System.out.println("Reamining Fees:"+ReaminingFees);
		}
		else if(rs.getString("subjects").equalsIgnoreCase("english")) {
			ReaminingFees = 10000-rs.getFloat("feespaid"); 
			System.out.println("Reamining Fees:"+ReaminingFees);
		}
		else if(rs.getString("subjects").equalsIgnoreCase("hindi")) {
			ReaminingFees = 8000-rs.getFloat("feespaid"); 
			System.out.println("Reamining Fees:"+ReaminingFees);
		}
		else {
			System.out.println("Subject not found!");
		}
	}
	
	
	
//	public void addSubject(StudentDTO studentDTO) throws SQLException{
//		System.out.println("Enter subject you want to add:");
//		String sub = sc.nextLine();
//		
//		String sql = "select * from student_details where email=? and password=?";
//		Connection con = DBConnection.getConnection();
//		
//		PreparedStatement preparedStatement = con.prepareStatement(sql);
//		preparedStatement.setString(1, studentDTO.getEmail());
//		preparedStatement.setString(2, studentDTO.getPassword());
//		
//		ResultSet rs = preparedStatement.executeQuery();
//		rs.next();
//		
//		if(rs.getString("subjects").equalsIgnoreCase(sub)) {
//			System.out.println(sub+"Already exists.");
//		}
//		else {
//			 sql = "select name from subjects where name=?";
//			 PreparedStatement preparedStatement1= con.prepareStatement(sql);
//			 preparedStatement1.setString(1, sub);
//			 
//			 ResultSet rs1 = preparedStatement.executeQuery();
//			 if(rs1.next())
//			 {
//				 sql = "insert into enrollcourse(student_id,subject_name)  values(?,?)";
//				 PreparedStatement preparedStatement2= con.prepareStatement(sql);
//				 preparedStatement2.setInt(1, rs.getInt("student_id"));
//				 preparedStatement2.setString(2, sub);
//				 System.out.println("subject added...!");
//			 }
//			 else {
//				 System.out.println("sub not found");
//			 }
//			 		
//		}
//	}
//}
	public void addSubject(StudentDTO studentDTO) throws SQLException {
		Connection con = DBConnection.getConnection();
		try 
		{
			System.out.println("Enter subject you want to add:");
		    String sub = sc.nextLine();
		
		    String sql = "SELECT student_id, subjects FROM student_details WHERE email=? AND password=?";
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, studentDTO.getEmail());
	        preparedStatement.setString(2, studentDTO.getPassword());
	
	        ResultSet rs = preparedStatement.executeQuery();
	
	        if (rs.next()) 
	        { // Ensure record exists
	            int studentId = rs.getInt("student_id"); // ✅ Store student_id before closing rs
	            String existingSubjects = rs.getString("subjects");
	
	            rs.close(); // ✅ Close first ResultSet
	            preparedStatement.close(); // ✅ Close first PreparedStatement
	
	            if (existingSubjects != null && existingSubjects.equalsIgnoreCase(sub)) 
	            {
	                System.out.println(sub + " already exists.");
	            } 
	            else 
	            {
	                // ✅ Second Query: Check if subject exists
	                sql = "SELECT name FROM subjects WHERE name=?";
	                PreparedStatement preparedStatement1 = con.prepareStatement(sql);
	                preparedStatement1.setString(1, sub);
	                ResultSet rs1 = preparedStatement1.executeQuery();
	                
	                if (rs1.next()) 
	                {
	                    rs1.close(); // ✅ Close second ResultSet
	                    preparedStatement1.close(); // ✅ Close second PreparedStatement
	
	                    // ✅ Third Query: Insert the subject into enrollcourse
	                    sql = "INSERT INTO enrollcourse(student_id, subjects_name) VALUES (?, ?)";
	                    PreparedStatement preparedStatement2 = con.prepareStatement(sql);
	                    preparedStatement2.setInt(1, studentId); // ✅ Use stored studentId
	                    preparedStatement2.setString(2, sub);
	                    preparedStatement2.executeUpdate();
	                    System.out.println("Subject added successfully!");
	
	                    preparedStatement2.close(); // ✅ Close third PreparedStatement
	                }
	                else 
	                {
	                    System.out.println("Subject not found.");
	                    rs1.close();
	                    preparedStatement1.close();
	                }
	            }
	        }
	        else 
	        {
	            System.out.println("Invalid email or password.");
	        }

		} 
		catch (SQLException e) {
	        System.out.println("Error Occurred: " + e.getMessage());
	    } 
		finally {
	        con.close(); // ✅ Close connection to avoid leaks
	    }
	}
}


