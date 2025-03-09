package com.gi.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.gi.dao.AdminDAO;
import com.gi.dto.AdminDTO;

import com.gi.dao.StudentDAO;
import com.gi.dto.StudentDTO;

import com.gi.dao.TutorDAO;
import com.gi.dto.TutorDTO;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		try {
			do{
				System.out.println("1. Admin Login");
				System.out.println("2. Student Login");
				System.out.println("3. Tutor Login");
				System.out.println("0. Exit");
				
				System.out.println("Enter your choice...");
				choice = sc.nextInt();

				switch (choice) {
				case 0:
					System.out.println("Good Bye....");
					break;
				case 1:
					AdminDTO adminDTO = getAdminDetails();
					System.out.println(adminDTO);

					AdminDAO adminDAO = new AdminDAO();
					try {
						if (adminDAO.adminLogin(adminDTO)) {
							AdminOptions adminOptions = new AdminOptions();
							adminOptions.adminMenu(adminDTO);
							//sc.nextLine();
						} 
						else {
							System.out.println("Email and password does not match...");
						}
					} 
					catch (SQLException e) {
						System.out.println("Error Occured : " + e.getMessage());
					}
					break;
				case 2:
					try 
					{
						StudentOptions studentOptions = new StudentOptions();
						studentOptions.studentMenu();
						
					} 
					catch (Exception e) {
						System.out.println("Error Occured : " + e.getMessage());
					}
					break;
				case 3:
					try 
					{
						TutorOptions tutorOptions = new TutorOptions();
						tutorOptions.tutorMenu();
						
					} 
					catch (Exception e) {
						System.out.println("Error Occured : " + e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}while(choice!=0);
		}
		finally {
            sc.close();
        }
	}
	public static AdminDTO getAdminDetails() {				//All this three functions:getAdminDetails(),getStudentDetails(),getTutorDetails() are created outside (public static void main) so that other class can call this functions.
		sc.nextLine();
		System.out.println("Enter Email ... ");
		String email = sc.nextLine();

		System.out.println("Enter Password ... ");
		String password = sc.nextLine();

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setEmail(email);
		adminDTO.setPassword(password);
		
		return adminDTO;
	}
	public static StudentDTO getStudentDetails() {
		sc.nextLine();
		System.out.println("Enter Email ... ");
		String email = sc.nextLine();

		System.out.println("Enter Password ... ");
		String password = sc.nextLine();
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setEmail(email);
		studentDTO.setPassword(password);
		
		return studentDTO;
	}
	public static TutorDTO getTutorDetails() {
		sc.nextLine();
		System.out.println("Enter Email ...");
		String email = sc.nextLine();
		
		System.out.println("Enter Password ...");
		String password = sc.nextLine();
		
		TutorDTO tutorDTO = new TutorDTO();
		tutorDTO.setEmail(email);
		tutorDTO.setPassword(password);
		
		return tutorDTO;
	}

}
