package com.example.service;

import java.util.List;

import com.example.enitty.Customer;
import com.example.enitty.Employee;

public interface CustomerService {


		List<Customer> getAllCustomers();
		 void deleteCustomerById(int cusId);
		 Customer updateCustomer(Customer cus);
		 Customer addCustomer(Customer cus);
		 Customer getCusById(int cusId);
	}
