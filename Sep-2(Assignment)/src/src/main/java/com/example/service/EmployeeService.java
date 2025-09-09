package com.example.service;

import java.util.List;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Skill;

public interface EmployeeService {
	// Add Employee
	Employee addEmployee(Employee emp);

	// Update Employee
	Employee updateEmployee(Employee emp);

      public List<Skill> getSkillsByEmployeeId(Long empId);

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

	EmpOutputDto addEmployeeDto(EmpInputDto empDto);

	EmpOutputDto getEmpByEmail(String email);

	Employee updateAddress(int empId, Address addr);

	Employee updateEmpSkills(int empId, int skillId);
}
