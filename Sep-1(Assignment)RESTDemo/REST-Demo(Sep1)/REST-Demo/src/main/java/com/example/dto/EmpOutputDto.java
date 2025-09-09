package com.example.dto;

public class EmpOutputDto {
	
	// Fields
	private String name;
	private String email;
	private String contactNo;
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	// toString method
	@Override
	public String toString() {
		return "EmpOutputDto [name=" + name + ", email=" + email + ", contactNo=" + contactNo + "]";
	}
	
	

}
