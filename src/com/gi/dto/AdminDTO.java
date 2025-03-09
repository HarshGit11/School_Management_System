package com.gi.dto;

public class AdminDTO {
	private String email;
	private String password;

	@Override
	public String toString() {
		return "AdminDTO [email=" + email + ", password=" + password + "]";
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

	public AdminDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AdminDTO() {
		super();
	}

}
