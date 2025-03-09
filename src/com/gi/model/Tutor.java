package com.gi.model;

public class Tutor extends Person{

	private String email;
	private String password;
	private String specialization;
	private float monthlySalary;
	private int classesAssigned;
	
	@Override
	public String toString() {
		return "Tutor [email=" + email + ", password=" + password + ", specialization=" + specialization
				+ ", monthlySalary=" + monthlySalary + ", classesAssigned=" + classesAssigned + ", age=" + age + ", address=" + address + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public float getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(float monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getClassesAssigned() {
		return classesAssigned;
	}

	public void setClassesAssigned(int classesAssigned) {
		this.classesAssigned = classesAssigned;
	}

	public Tutor(int age, String address, String email, String password, String specialization,
			float monthlySalary, int classesAssigned) 
	{
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
		this.specialization = specialization;
		this.monthlySalary = monthlySalary;
		this.classesAssigned = classesAssigned;
	}
	
	public Tutor() 
	{}
	
}