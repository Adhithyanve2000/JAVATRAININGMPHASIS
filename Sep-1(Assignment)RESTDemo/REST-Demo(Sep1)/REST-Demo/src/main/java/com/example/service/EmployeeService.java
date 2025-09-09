package com.example.service;

import java.util.List;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;

public interface EmployeeService {
	// Add Employee
	Employee addEmployee(Employee emp);

	// Update Employee
	Employee updateEmployee(Employee emp);

	// Delete Employee
	void deleteEmployee(int empId);

	// Get all Employees
	List<Employee> getAllEmployees();

	// Get Emp by id
	Employee getEmployeeById(int empId);

	// Get Emp by name
	Employee getEmployeeByName(String empName);

	// Update emp contact No
	Employee updateEmployeeContactNo(int empId, String newContactNo);

	 Employee updateAddress(int empId, Address newAddress);
	EmpOutputDto addEmployeeDto(EmpInputDto empDto);
}
