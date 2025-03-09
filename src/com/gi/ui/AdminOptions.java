package com.gi.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.gi.dao.AdminDAO;
import com.gi.dao.StudentDAO;
import com.gi.dao.TutorDAO;
import com.gi.dto.AdminDTO;
import com.gi.dto.StudentDTO;
import com.gi.model.Admin;
import com.gi.model.Student;
import com.gi.model.Tutor;

public class AdminOptions {
	public void adminMenu(AdminDTO adminDTO) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1. List all the students");
			System.out.println("2. Add new Student");
			System.out.println("3. Add new Trainer");
			System.out.println("4. Calculate Admin Salary");
			System.out.println("0. Logout");
			
			System.out.println("Enter your choice...");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Exit");
				break;
			case 1:
				try {
					StudentDAO studentdao = new StudentDAO();
					studentdao.viewStudents();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				 try {
					StudentOptions studentOptions = new StudentOptions();
					studentOptions.addStudent();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					TutorOptions tutorOptions = new TutorOptions();
					tutorOptions.addTutor();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					AdminDAO admindao = new AdminDAO();
					admindao.calculateSalary(adminDTO);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 0);
	}
	
}
