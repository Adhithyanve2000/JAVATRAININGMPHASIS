package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.entity.Skill;
import com.example.enums.Role;
import com.example.exceptions.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;
import com.example.repository.LoginRepository;
import com.example.repository.SkillRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	SkillRepository skillRepo;

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

		throw new EmployeeNotFoundException("Employee not found with id: "+ emp.getId());
	}

	@Override
	public void deleteEmployee(int empId) {
		Optional<Employee> optObj = empRepo.findById(empId);

		if (optObj.isPresent()) {
			empRepo.deleteById(empId);
		}
		
		throw new EmployeeNotFoundException("Employee not found with id: "+ empId);

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
		throw new EmployeeNotFoundException("Employee not found with id: "+ empId);
	}

	@Override
	public Employee getEmployeeByName(String empName) {
		// empRepo.find
		// Optional<Employee> optObj = empRepo.findByName(empName);
		Optional<Employee> optObj = empRepo.getEmpByName(empName);

		if (optObj.isPresent()) {
			return optObj.get();
		}
		throw new EmployeeNotFoundException("Employee not found with name: "+ empName);
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
		login.setRole(Role.EMPLOYEE);

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

	@Override
	public EmpOutputDto getEmpByEmail(String email) {
		return empRepo.getEmpByEmail(email);
	}

	
	@Override
	public Employee updateAddress(int empId, Address addr) {
		// Verify emp present in db or not
		// find emp by id
		Optional<Employee> optObj = empRepo.findById(empId);

		if (optObj.isPresent()) {
			Employee emp = optObj.get();
			// Get existing addresses 
//			List<Address> addrList = emp.getAddrList();
//			
//			// add new address to the existing list
//			addrList.add(addr);
			
			emp.getAddrList().add(addr);
			
			// save emp 
			return empRepo.save(emp);
		}

		// if emp present in the db, update address
		return null;
	}

    @Override
    public List<Skill> getSkillsByEmployeeId(Long empId) {
        return empRepo.findSkillsByEmployeeId(empId);
    }

	@Override
	public Employee updateEmpSkills(int empId, int skillId) { ;// s3
		Optional<Employee> optObj = empRepo.findById(empId);
		Optional<Skill> skillOptObj = skillRepo.findById(skillId);
		
		if(optObj.isPresent() && skillOptObj.isPresent()) {
			// update skill
			Employee emp = optObj.get();
			Skill skill = skillOptObj.get();
			
			// Get existing skill list
			List<Skill> skillList = emp.getSkill(); // s1, s2
			
			// add new skill to the existing skill list
			skillList.add(skill); //  s1, s2, s3
			
			//emp.setSkill(skillList);
			
			return empRepo.save(emp);
		}
		
		return null;
	}

}
