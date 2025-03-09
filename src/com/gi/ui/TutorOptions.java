package com.gi.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.gi.dao.TutorDAO;
import com.gi.dto.TutorDTO;
import com.gi.ui.Main;
import com.gi.model.Tutor;

public class TutorOptions {
	Scanner sc = new Scanner(System.in);
	public void tutorMenu() {
		
		int choice;
		do {
			System.out.println("1. Existing Tutor");
			System.out.println("2. New Tutor");
			System.out.println("0. Exit");
			
			System.out.println("Enter your choice...");
			choice = sc.nextInt();
			
			switch (choice) {
			case 0:
				System.out.println("Exit");
				break;

			case 1:
				try {
					TutorDTO tutorDTO = Main.getTutorDetails();
					TutorDAO tutorDAO = new TutorDAO();
					if(tutorDAO.tutorLogin(tutorDTO)) {
						int num;
						do {
							System.out.println("1. calculate Salary");
							System.out.println("2. Assign class");
							System.out.println("0. Exit");
							
							System.out.println("Enter choice:");
							num = sc.nextInt();
							switch(num) {
							case 0:
								System.out.println("Exit");
								break;
							case 1:
								tutorDAO.tutorSalary(tutorDTO);
								break;
							case 2:
								tutorDAO.tutorAssignClass(tutorDTO);
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
					this.addTutor();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 0);
	}

	public void addTutor() throws SQLException{
		System.out.println("Enter your age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your address:");
		String address = sc.nextLine();
		System.out.println("Enter email:");
		String email = sc.nextLine();
		System.out.println("Enter password:");
		String password = sc.nextLine();
		System.out.println("Enter specialization:");
		String specialization = sc.nextLine();
		System.out.println("Enter monthlySalary:");
		float monthlySalary = sc.nextFloat();
		System.out.println("Enter classesAssigned:");
		int classesAssigned = sc.nextInt();
		
		Tutor tutor = new Tutor(age,address,email,password,specialization,monthlySalary,classesAssigned);
		TutorDAO tutorDAO = new TutorDAO();
		tutorDAO.addtutor(tutor);
	}
}
