package com.example.service;

import java.util.List;

import com.example.enitty.Employee;

public interface IEmployeeService {
	
	Employee addEmployee(Employee emp);
	Employee updateEmployee(Employee emp);
	void deleteEmployeeById(int empId);
	Employee getEmpById(int empId);
	Employee getEmpByName(String empName);
	List<Employee> getAllEmployees();

}
