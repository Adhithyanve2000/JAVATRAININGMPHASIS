package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int empId;
	
	@NotBlank(message="Name shouldn't blank")
	@NotEmpty(message="Name shouldn't empty")
	@NotNull(message="Name shouldn't null")
    @Pattern(regexp = "^[a-zA-Z]{3,15}$", 
             message = "Username must be 3 to 15 characters long and contain only letters.")
	private String name;
	
	//regexp = "^[0-9]{10}$" 
	
	@Size(min=10, max=10, message="contactNo length should be equals to 10 digits.")
	private String contactNo;
	
	
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
	public int getEmpId() {
		return this.empId;
	}
	
	// Setter
	public void setEmpId(int id) {
		this.empId = id;
	}

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

	
//	@Override
//	public String toString() {
//		return "Employee [empId=" + empId + ", name=" + name + ", contactNo=" + contactNo + ", login=" + login
//				+ ", addrList=" + addrList + "]";
//	}

	


}
