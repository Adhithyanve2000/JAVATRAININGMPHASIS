package com.example.entity;
import com.example.enums.Role;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee extends Person {
	
	
	
	private String contactNo;
	

   @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYEE;

	// HAS-A relationship
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_login_fk")
	private Login login;
	
	
	// One-TO-Many
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_addr_fk")
	private List<Address> addrList;
	
	
	// ManyToMany
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "employees_skills", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private List<Skill> skill;
	
	// Constructors
	
	

		



		
	
	// Getters & Setters
	// Getter


	

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
	
	public List<Address> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<Address> addrList) {
		this.addrList = addrList;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + getId() + ", name=" + getName() + ", contactNo=" + contactNo + ", login=" + login + "]";
	}

}
//	@Override
//	public String toString() {
//		return "Employee [empId=" + empId + ", name=" + name + ", contactNo=" + contactNo + ", login=" + login
//				+ ", addrList=" + addrList + "]";
//	}

	



