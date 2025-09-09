package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmpInputDto {

	// Fields
	@NotBlank(message = "Name shouldn't blank")
	@NotEmpty(message = "Name shouldn't empty")
	@NotNull(message = "Name shouldn't null")
	@Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Username must be 3 to 15 characters long and contain only letters.")
	private String name;

	@Size(min = 10, max = 10, message = "ContactNo should be 10 digit number")
	private String contactNo;
	
	@Email(message = "Enter valid email address")
	private String email;
	
	@Pattern(regexp="^[a-zA-Z0-9]{3, 8}$", message="Password min length should be 3 chars and max length should be 8 chars")
	private String password;

	
	// Constructors
	public EmpInputDto() {};
	
	public EmpInputDto(
			@NotBlank(message = "Name shouldn't blank") @NotEmpty(message = "Name shouldn't empty") @NotNull(message = "Name shouldn't null") @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Username must be 3 to 15 characters long and contain only letters.") String name,
			@Size(min = 10, max = 10, message = "ContactNo should be 10 digit number") String contactNo,
			@Email(message = "Enter valid email address") String email,
			@Pattern(regexp = "^[a-zA-Z0-9]{3, 8}$", message = "Password min length should be 3 chars and max length should be 8 chars") String password) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	@Override
	public String toString() {
		return "RegisterDto [name=" + name + ", contactNo=" + contactNo + ", email=" + email + ", password=" + password
				+ "]";
	}

}
