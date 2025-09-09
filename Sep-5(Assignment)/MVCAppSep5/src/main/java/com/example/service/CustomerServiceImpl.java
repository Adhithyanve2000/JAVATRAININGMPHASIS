package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enitty.Customer;
import com.example.enitty.Employee;
import com.example.repository.CusRepo;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CusRepo cusRepo;
	
	@Override
	public Customer addCustomer(Customer cus) {
		return cusRepo.save(cus);
		
	}
	@Override
	public Customer updateCustomer(Customer cus) {
				Customer dbCus = cusRepo.findById(cus.getcusId()).get();

				dbCus.setcusName(cus.getcusName());
	
				dbCus.setContactNo(cus.getContactNo());
		
		return cusRepo.save(dbCus);
		
	}
	
	@Override
	 public Customer getCusById(int cusId)
	 {
		return cusRepo.getById(cusId);
	 }

	@Override
	public void deleteCustomerById(int cusId) {
		cusRepo.deleteById(cusId);
		
	}
	public List<Customer> getAllCustomers(){
		return cusRepo.findAll();
	}
}
