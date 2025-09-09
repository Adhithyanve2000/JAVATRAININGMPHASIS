package com.example.service;

import com.example.controller.EmployeeController;
import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeControllerTests {

    @Autowired
    EmployeeController empController;

    @Test
    @DisplayName("Get All Employees from Controller")
    @Tag("ControllerTest")
    void getAllEmployeesTest() {
        List<Employee> empList = empController.getAllEmployees();
        assertNotNull(empList);
        assertTrue(empList.size() >= 0);
    }

    @Test
    @DisplayName("Get Employee by ID from Controller")
    @Tag("ControllerTest")
    void getEmployeeByIdTest() {
        Employee emp = empController.getEmployeeById(202);
        assertNotNull(emp);
        assertEquals(202, emp.getEmpId());
    }

    @Test
    @DisplayName("Get Employee by Invalid ID from Controller")
    @Tag("ControllerTest")
    void getEmployeeByInvalidIdTest() {
        Employee emp = empController.getEmployeeById(99999);
        assertNull(emp); // Assuming service returns null if not found
    }

    @Test
    @DisplayName("Add Employee via Controller (non-DTO)")
    @Tag("ControllerTest")
    void addEmployeeTest() {
        Employee emp = new Employee();
        emp.setName("Manoj");
        emp.setContactNo("9876543210");
        Employee addedEmp = empController.addEmployee(emp);
        assertNotNull(addedEmp);
        assertEquals("Manoj", addedEmp.getName());
    }

    @Test
    @DisplayName("Add Employee DTO via Controller")
    @Tag("ControllerTest")
    void addEmployeeDtoTest() {
        EmpInputDto inputDto = new EmpInputDto("RajeshKumar", "9999955555", "rajesh_4@example.com", "abc.123");
        EmpOutputDto outputDto = empController.addEmployeeDto(inputDto);
        assertEquals("RajeshKumar", outputDto.getName());
        assertEquals("9999955555", outputDto.getContactNo());
        assertEquals("rajesh_4@example.com", outputDto.getEmail());
    }

    @Test
    @DisplayName("Delete Employee via Controller")
    @Tag("ControllerTest")
    void deleteEmployeeTest() {
        empController.deleteEmployee(202);
        Employee emp = empController.getEmployeeById(202);
        assertNull(emp); // assuming service returns null if not found
    }

    @Test
    @DisplayName("Update Employee Contact No via Controller")
    @Tag("ControllerTest")
    void updateContactNoTest() {
        Employee updatedEmp = empController.updateEmployeeContactNo(203, "7777777777");
        assertNotNull(updatedEmp);
        assertEquals("7777777777", updatedEmp.getContactNo());
    }

    @Test
    @DisplayName("Update Employee Contact No with Invalid Number")
    @Tag("ControllerTest")
    void updateContactNoInvalidTest() {
        Employee updatedEmp = empController.updateEmployeeContactNo(203, "123");
        assertNotEquals("123", updatedEmp.getContactNo()); // Should fail validation or not update
    }

    @Test
    @DisplayName("Get Employee by Name from Controller")
    @Tag("ControllerTest")
    void getEmployeeByNameTest() {
        Employee emp = empController.getEmployeeByName("Raj");
        assertNotNull(emp);
        assertEquals("Raj", emp.getName());
    }

    @Test
    @DisplayName("Get Employee by Email from Controller")
    @Tag("ControllerTest")
    void getEmployeeByEmailTest() {
        EmpOutputDto empDto = empController.getEmpByEmail("raj@example.com");
        assertNotNull(empDto);
        assertEquals("raj@example.com", empDto.getEmail());
    }

    @Test
    @DisplayName("Update Employee Address via Controller")
    @Tag("ControllerTest")
    void updateEmployeeAddressTest() {
        Address newAddress = new Address();
        newAddress.setCity("Hyderabad");
        newAddress.setState("TS");

        Employee updatedEmp = empController.updateAddress(203, newAddress);
        assertNotNull(updatedEmp);
        assertTrue(updatedEmp.getAddrList().stream()
                .anyMatch(addr -> "Hyderabad".equals(addr.getCity())));
    }

    @Test
    @DisplayName("Update Employee Skill via Controller")
    @Tag("ControllerTest")
    void updateEmployeeSkillTest() {
        Employee updatedEmp = empController.updateEmpSkills(203, 101); // Assuming skillId 101 exists
        assertNotNull(updatedEmp);
        assertTrue(updatedEmp.getSkill().stream().anyMatch(skill -> skill.getSkillId() == 101));
    }

    @Test
    @DisplayName("Update Full Employee via Controller")
    @Tag("ControllerTest")
    void updateEmployeeTest() {
        Employee emp = new Employee();
        emp.setEmpId(203);
        emp.setName("Raj Updated");
        emp.setContactNo("8888888888");
        Employee updatedEmp = empController.updateEmployee(emp);
        assertEquals("Raj Updated", updatedEmp.getName());
        assertEquals("8888888888", updatedEmp.getContactNo());
    }

    @Test
    @DisplayName("Add Employee DTO with Invalid Name - Validation Failure")
    @Tag("ValidationTest")
    void addEmployeeDtoInvalidNameTest() {
        EmpInputDto invalidDto = new EmpInputDto("Ra", "1234567890", "invalid@example.com", "pass123");

        Exception exception = assertThrows(Exception.class, () -> {
            empController.addEmployeeDto(invalidDto);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("Username must be 3 to 15 characters long"));
    }

    @Test
    @DisplayName("Update Address for Non-Existent Employee")
    @Tag("ControllerTest")
    void updateAddressForInvalidEmployeeTest() {
        Address address = new Address();
        address.setCity("Pune");
        address.setState("MH");

        Employee emp = empController.updateAddress(99999, address);
        assertNull(emp); // Assuming null or 404 response when employee not found
    }
    @Test
    @DisplayName("Get Employee by Email via Controller")
    void getEmpByEmailTest() {
        EmpOutputDto empDto = empController.getEmpByEmail("john@example.com");
        assertNotNull(empDto);
        assertEquals("john@example.com", empDto.getEmail());
    }
    @Test
    @DisplayName("Update Employee Address via Controller")
    void updateAddressTest() {
        Address addr = new Address();
        addr.setCity("Mumbai");
        addr.setState("MH");

        Employee emp = empController.updateAddress(203, addr);
        assertTrue(emp.getAddrList().stream().anyMatch(a -> a.getCity().equals("Mumbai")));
    }

    @Test
    @DisplayName("Update Employee Skill via Controller")
    void updateSkillTest() {
        Employee emp = empController.updateEmpSkills(203, 101); // Assuming skillId 101 exists
        assertTrue(emp.getSkill().stream().anyMatch(skill -> skill.getSkillId() == 101));
    }

    

    
}

