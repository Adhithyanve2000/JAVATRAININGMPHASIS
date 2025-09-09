package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	EmployeeService empServ;

	/*
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp()");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown()");
	}

	@Test
	void test4() {
		fail("Not yet implemented");
	}
	
	@Test
	void test2() {
		fail("Not yet implemented");
	}
	
	@Test
	void test1() {
		fail("Not yet implemented");
	}
	
	@Test
	void test3() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	@DisplayName("Get All Employees Test")
	@Tag("Sanity")
	void getAllEmployeesTest() {
		// Call EmployeeService getAllEmp()
		List<Employee> empList = empServ.getAllEmployees();
		
		// Verify
		assertEquals(3, empList.size());
		assertEquals("Ram", empList.get(0).getName());
		
	}
	
	@Test
	@Tag("Sanity-2")
	@RepeatedTest(3)
	void getEmployeeByIdTest() {
		// Call EmployeeService getAllEmp()
		Employee emp = empServ.getEmployeeById(202);
		
		// Verify
		assertEquals(202, emp.getEmpId());
		
	}
	
	
	@Test
	void addEmployeeDtoTest() {
		EmpInputDto inputDto = new EmpInputDto("RajeshKumar", "9999955555", "rajesh_4@example.com", "abc.123");
		EmpOutputDto outputDto = empServ.addEmployeeDto(inputDto);
		assertEquals("RajeshKumar", outputDto.getName());
		assertEquals("rajesh_4@example.com", outputDto.getEmail());
		assertEquals("9999955555", outputDto.getContactNo());
	}
	
	@Test
	@DisplayName("Add Employee Test")
	void addEmployeeTest() {
	    Employee emp = new Employee();
	    emp.setEmpId(301);
	    emp.setName("Kiran");
	    emp.setContactNo("9876543210");

	    Employee savedEmp = empServ.addEmployee(emp);
	    assertEquals("Kiran", savedEmp.getName());
	    assertEquals("9876543210", savedEmp.getContactNo());
	}

	@Test
	@DisplayName("Update Employee Test")
	void updateEmployeeTest() {
	    Employee emp = new Employee();
	    emp.setEmpId(202);
	    emp.setName("Raj Updated");

	    Employee updatedEmp = empServ.updateEmployee(emp);
	    assertEquals("Raj Updated", updatedEmp.getName());
	}

	@Test
	@DisplayName("Delete Employee Test")
	void deleteEmployeeTest() {
	    empServ.deleteEmployee(203); 
	    Employee emp = empServ.getEmployeeById(203);
	    assertNull(emp); 
	}

	@Test
	@DisplayName("Get Employee by Name Test")
	void getEmployeeByNameTest() {
	    Employee emp = empServ.getEmployeeByName("Ram");
	    assertEquals("Ram", emp.getName());
	}

	@Test
	@DisplayName("Update Employee Contact No Test")
	void updateEmployeeContactNoTest() {
	    Employee updatedEmp = empServ.updateEmployeeContactNo(202, "7777777777");
	    assertEquals("7777777777", updatedEmp.getContactNo());
	}

	@Test
	@DisplayName("Get Employee by Email Test")
	void getEmpByEmailTest() {
	    EmpOutputDto outputDto = empServ.getEmpByEmail("rajesh_4@example.com");
	    assertEquals("RajeshKumar", outputDto.getName());
	    assertEquals("rajesh_4@example.com", outputDto.getEmail());
	}

	@Test
	@DisplayName("Update Address Test")
	void updateAddressTest() {
	    Address addr = new Address();
	    addr.setCity("Hyderabad");
	    addr.setState("Telangana");

	    Employee updatedEmp = empServ.updateAddress(202, addr);
	    assertEquals("Hyderabad", updatedEmp.getAddrList().get(updatedEmp.getAddrList().size() - 1).getCity());
	}

	@Test
	@DisplayName("Update Employee Skills Test")
	@Tag("Slow")
	void updateEmpSkillsTest() {
	    Employee updatedEmp = empServ.updateEmpSkills(202, 3); 
	    assertEquals(3,updatedEmp.getSkill().get(updatedEmp.getAddrList().size() - 1).getSkillId());
	}
	

}
