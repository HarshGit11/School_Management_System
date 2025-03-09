package com.gi.model;

public class Person {
	int age;
	String address;
	
	public Person(int age, String address) {
		super();
		this.age = age;
		this.address = address;
	}
	public Person() {
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
