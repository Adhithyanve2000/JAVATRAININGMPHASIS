package com.example.entity;

import jakarta.persistence.CascadeType;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "empId")
public class Employee extends Person {
	
	
	
	
	private String contactNo;
	
	
	// HAS-A relationship
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_login_fk")
	private Login login;
	
	
		
	

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
    name = "employee_address",
    joinColumns = @JoinColumn(name = "emp_id"),
    inverseJoinColumns = @JoinColumn(name = "address_id")
)
private Set<Address> addresses;
public Set<Address> getAddresses() {
    return addresses;
}

public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
}

	


	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + getId() + ", name=" + getName() + ", contactNo=" + contactNo + ", login=" + login + "]";
	}

}
