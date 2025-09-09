package com.example.enitty;
import com.example.enitty.Login;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@ToString
public class Customer {



		
		@Id
		@GeneratedValue
		private int cusId;
		private String cusName;
	
		private String contactNo;
		
		// HAS-A relationship
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="emp_login_fk")
		private Login login;
		
		public int getcusId() {
			return cusId;
		}
		public void setcusId(int cusId) {
			this.cusId = cusId;
		}
		public String getcusName() {
			return cusName;
		}
		public void setcusName(String cusName) {
			this.cusName = cusName;
		}
	
		public String getContactNo() {
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

	}

