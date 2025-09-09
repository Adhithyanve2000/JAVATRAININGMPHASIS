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

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empServ;
	
	// Add Employee
	@PostMapping("/employee/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return empServ.addEmployee(emp);
	}
	
	@PostMapping("/employee/add/dto")
	public EmpOutputDto addEmployeeDto(@Valid @RequestBody EmpInputDto empInputDto) {
		return empServ.addEmployeeDto(empInputDto);
	}
	
	
	// Update Employee
	@PutMapping("/employee/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return empServ.updateEmployee(emp);
	}
	
//	Employee updateEmployee(Employee emp) {
//		return null;
//	}
	
	// Delete Employee
	@DeleteMapping("/employee/byId/{id}")
	public void deleteEmployee(@PathVariable("id") int empId) {
		empServ.deleteEmployee(empId);
	}
	
	// Get all Employees
	@GetMapping("/employee/all")
	
	public List<Employee> getAllEmployees() {
		
		return empServ.getAllEmployees();
	}
	
	
	// Get Emp by id
	@GetMapping("/employee/byId/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmployeeById(empId);
	}
	
	// Get Emp by name
	@GetMapping("/employee/byName/{name}")
	public Employee getEmployeeByName(@PathVariable("name") String empName) {
		return empServ.getEmployeeByName(empName);
	}
	
	// Update emp contact No
	@PatchMapping("/employee/update/{empId}/{newContactNo}")
	public Employee updateEmployeeContactNo(@PathVariable int empId, @PathVariable String newContactNo) {
		return empServ.updateEmployeeContactNo(empId, newContactNo);
	}
		
	// Update emp email address

	
	// Get Emp by email
	@GetMapping("/employee/byEmail/{email}")
	public EmpOutputDto getEmpByEmail(@PathVariable String email) {
		return empServ.getEmpByEmail(email);
	}
	
	@PostMapping("/employee/update/{empId}/address")
	public Employee updateAddress(@PathVariable int empId, @RequestBody Address addr) {
	   // logic to update address
		return empServ.updateAddress(empId, addr);
	}
	
	
	// update Skill to the Employee
	@PutMapping("employee/{empId}/update/skill/{skillId}")
	public Employee updateEmpSkills(@PathVariable int empId, @PathVariable int skillId) {
		return empServ.updateEmpSkills(empId, skillId);
	}
}
