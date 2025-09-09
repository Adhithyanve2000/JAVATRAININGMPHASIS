package com.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enitty.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository empRepo;

	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
				Employee dbEmp = empRepo.findById(emp.getEmpId()).get();

		dbEmp.setEmpName(emp.getEmpName());
		dbEmp.setSalary(emp.getSalary());
		dbEmp.setContactNo(emp.getContactNo());
		
		return empRepo.save(dbEmp);
		
	}

	@Override
	public void deleteEmployeeById(int empId) {
		empRepo.deleteById(empId);
		
	}

	@Override
	public Employee getEmpById(int empId) {
		
		return empRepo.getById(empId);
	}

	@Override
	public Employee getEmpByName(String empName) {
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}
}
