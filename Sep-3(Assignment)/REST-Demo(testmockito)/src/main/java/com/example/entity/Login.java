package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
	
	// Fields
	@Id
	private String email;
	
	private String password;
	private String role;
	
	private boolean isLogin;
	
	@OneToOne(mappedBy="login")
	private Employee emp;
	
	
	// Getters & Setter
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
//	@Override
//	public String toString() {
//		return "Login [email=" + email + ", password=" + password + ", role=" + role + ", isLogin=" + isLogin + "]";
//	}
	
	
	
}
