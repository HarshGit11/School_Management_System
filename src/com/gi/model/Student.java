package com.gi.model;

public class Student extends Person{
	private String email;
	private String password;
	private String gradeLevel;
	private String subjects;
	private float feesPaid;
	
	@Override
	public String toString() {
		return "Student [email=" + email + ", password=" + password + ", gradeLevel=" + gradeLevel + ", subjects="
				+ subjects + ", feesPaid=" + feesPaid + ", age=" + age + ", address="
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

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public float getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(float feesPaid) {
		this.feesPaid = feesPaid;
	}

	public Student(int age, String address, String email, String password, String gradeLevel,
			String subjects, float feesPaid) 
	{
		this.age = age;
		this.address = address;
		this.email = email;
		this.password = password;
		this.gradeLevel = gradeLevel;
		this.subjects = subjects;
		this.feesPaid = feesPaid;
	}
	
	public Student()
	{}
	
}
