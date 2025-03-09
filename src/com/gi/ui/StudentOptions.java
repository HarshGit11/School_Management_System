package com.gi.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.gi.dao.StudentDAO;
import com.gi.dto.StudentDTO;
import com.gi.model.Student;
import com.gi.ui.Main;

public class StudentOptions {
	Scanner sc = new Scanner(System.in);
	public void studentMenu() {
		
		int choice;
		do {
			System.out.println("1. Existing Student");
			System.out.println("2. Add new Student");
			System.out.println("0. Exit");
			
			System.out.println("Enter your choice...");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Exit");
				break;
			case 1:
				try {
					StudentDTO studentDTO = Main.getStudentDetails();
					StudentDAO studentDAO = new StudentDAO();
					if(studentDAO.studentLogin(studentDTO)) {
						int num;
						do {
							System.out.println("1. calculateFeesRemaining");
							System.out.println("2. addSubjects");
							System.out.println("0. Exit");
							
							System.out.println("Enter choice:");
							num = sc.nextInt();
							switch(num) {
							case 0:
								System.out.println("Exit");
								break;
							case 1:
								studentDAO.studentCalculateFeesRemaining(studentDTO);
								break;
							case 2:
								studentDAO.addSubject(studentDTO);
								break;
							default:
								System.out.println("Invalid choice");
								break;
							}
						}while(num!=0);
						
					}
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					this.addStudent();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice!=0);
	}

	public void addStudent() throws SQLException {
		System.out.println("Enter your age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your address:");
		String address = sc.nextLine();
		System.out.println("Enter your email:");
		String email = sc.nextLine();
		System.out.println("Enter your password:");
		String password = sc.nextLine();
		System.out.println("Enter your gradelevel:");
		String gradelevel = sc.nextLine();
		System.out.println("Maths=12000||Science=15000||Social Science=13000||English=10000||Hindi=8000");
		System.out.println("Enter your subjects:");
		String subjects = sc.nextLine();
		System.out.println("Enter your FeesPaid:");
		float FeesPaid = sc.nextFloat();
		
		
		if(subjects.equalsIgnoreCase("maths")) {
			Student student = new Student(age,address,email,password,gradelevel,subjects,FeesPaid);
			StudentDAO studentdao = new StudentDAO();
			studentdao.addstudent(student);
		}
		else if(subjects.equalsIgnoreCase("science")) {
			Student student = new Student(age,address,email,password,gradelevel,subjects,FeesPaid);
			StudentDAO studentdao = new StudentDAO();
			studentdao.addstudent(student);
		}
		else if(subjects.equalsIgnoreCase("social science")) {
			Student student = new Student(age,address,email,password,gradelevel,subjects,FeesPaid);
			StudentDAO studentdao = new StudentDAO();
			studentdao.addstudent(student);
		}
		else if(subjects.equalsIgnoreCase("english")) {
			Student student = new Student(age,address,email,password,gradelevel,subjects,FeesPaid);
			StudentDAO studentdao = new StudentDAO();
			studentdao.addstudent(student);
		}
		else if(subjects.equalsIgnoreCase("hindi")) {
			Student student = new Student(age,address,email,password,gradelevel,subjects,FeesPaid);
			StudentDAO studentdao = new StudentDAO();
			studentdao.addstudent(student);
		}
		else {
			System.out.println("Please enter subject from above mentioned.");
		}
	}
}
