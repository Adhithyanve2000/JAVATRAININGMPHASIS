package com.example.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Employee updateAddress(int empId, Address newAddress) {
	    Optional<Employee> optEmp = employeeRepo.findById(empId);

	    if (optEmp.isPresent()) {
	        Employee emp = optEmp.get();
	        Address savedAddress = addressRepo.save(newAddress);

	  
	        if (emp.getAddresses() == null) {
	          emp.setAddresses(new HashSet<>());
	        }
	        emp.getAddresses().add(savedAddress);

	        if (savedAddress.getEmployees() == null) {
	                  savedAddress.setEmployees(new HashSet<>());
	        }
	        savedAddress.getEmployees().add(emp);
	        addressRepo.save(savedAddress);
	        return employeeRepo.save(emp);
	    }

	    return null;
	}
	@Override
	public Employee addEmployee(Employee emp) {

		return empRepo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// verify employee with id is present in db
		Optional<Employee> optObj = empRepo.findById(emp.getId());
		// if emp present, update
		if (optObj.isPresent()) {
			return empRepo.save(emp);
		}
		// else throw exception

		return null;
	}

	@Override
	public void deleteEmployee(int empId) {
		Optional<Employee> optObj = empRepo.findById(empId);

		if (optObj.isPresent()) {
			empRepo.deleteById(empId);
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<Employee> optObj = empRepo.findById(empId);
		
		if (optObj.isPresent()) {
			return optObj.get();
		}
		return null;
	}

	@Override
	public Employee getEmployeeByName(String empName) {
		//empRepo.find
		//Optional<Employee> optObj = empRepo.findByName(empName);
		Optional<Employee> optObj = empRepo.getEmpByName(empName);
		
		if(optObj.isPresent()) {
			return optObj.get();
		} 
		return null;
	}

	@Override
	public Employee updateEmployeeContactNo(int empId, String newContactNo) {
		// find emp by id
		Optional<Employee> optObj = empRepo.findById(empId);

		if (optObj.isPresent()) {
			Employee emp = optObj.get();

			// update contact no
			emp.setContactNo(newContactNo);

			// save updated emp in the db.
			return empRepo.save(emp);
		}

		return null;
	}

	@Override
	public EmpOutputDto addEmployeeDto(EmpInputDto empInputDto) {
		// Convert EmpInputDto to Emp
		
		// Create employee and update all details
		Employee emp = new Employee();
		
		emp.setName(empInputDto.getName());
		emp.setContactNo(empInputDto.getContactNo());
		
		// Create and update login details
		Login login = new Login();
		login.setEmail(empInputDto.getEmail());
		login.setPassword(empInputDto.getPassword());
		login.setRole("Employee");
		
		// update login details into emp
		emp.setLogin(login);
		
		// Save Emp into the db
		Employee newEmp = empRepo.save(emp);
		
		// Return EmployeeOutputDto as response
		EmpOutputDto outputDto = new EmpOutputDto();
		
		outputDto.setName(newEmp.getName());
		outputDto.setEmail(newEmp.getLogin().getEmail());
		outputDto.setContactNo(newEmp.getContactNo());
		
		return outputDto;
		
	}

}
