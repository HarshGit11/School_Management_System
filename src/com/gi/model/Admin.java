package com.gi.model;

public class Admin extends Person{

	public String email;
	public String password;
	public String department;
	public float hourlyRate;
	public int hoursWorked;

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", department=" + department + ", hourlyRate="
				+ hourlyRate + ", hoursWorked=" + hoursWorked + ", age=" + age + ", address="
				+ address + "]";
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public Admin(int age, String address, String email, String password, String department,
			float hourlyRate, int hoursWorked) 
	{
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
		this.department = department;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	

	public Admin() {
		super();
	}

}