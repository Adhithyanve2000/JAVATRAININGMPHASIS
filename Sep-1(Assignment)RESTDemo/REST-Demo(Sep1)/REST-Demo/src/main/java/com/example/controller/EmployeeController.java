package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;
	
	// Add Employee
	@PostMapping("/employee/add")
	Employee addEmployee(@RequestBody Employee emp) {
		return empServ.addEmployee(emp);
	}
	
	@PostMapping("/employee/add/dto")
	EmpOutputDto addEmployeeDto(@RequestBody EmpInputDto empInputDto) {
		return empServ.addEmployeeDto(empInputDto);
	}
	
	
	// Update Employee
	@PutMapping("/employee/update")
	Employee updateEmployee(@RequestBody Employee emp) {
		return empServ.updateEmployee(emp);
	}
	
//	Employee updateEmployee(Employee emp) {
//		return null;
//	}
	
	// Delete Employee
	@DeleteMapping("/employee/byId/{id}")
	void deleteEmployee(@PathVariable("id") int empId) {
		empServ.deleteEmployee(empId);
	}
	
	// Get all Employees
	@GetMapping("/employee/all")
	List<Employee> getAllEmployees() {
		
		return empServ.getAllEmployees();
	}
	
	
	// Get Emp by id
	@GetMapping("/employee/byId/{id}")
	Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmployeeById(empId);
	}
	
	// Get Emp by name
	@GetMapping("/employee/byName/{name}")
	Employee getEmployeeByName(@PathVariable("name") String empName) {
		return empServ.getEmployeeByName(empName);
	}
	
	// Update emp contact No
	@PatchMapping("/employee/update/{empId}/{newContactNo}")
	Employee updateEmployeeContactNo(@PathVariable int empId, @PathVariable String newContactNo) {
		return empServ.updateEmployeeContactNo(empId, newContactNo);
	}
		
	@PostMapping("/employee/update/{empId}/address")
	public Employee updateAddress(@PathVariable int empId, @RequestBody Address addr) {
	   
	  return empServ.updateAddress(empId, addr);
	}


}
