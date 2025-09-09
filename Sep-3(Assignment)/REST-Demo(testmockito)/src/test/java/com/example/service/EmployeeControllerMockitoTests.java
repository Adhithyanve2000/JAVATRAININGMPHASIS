package com.example.service;

import com.example.controller.EmployeeController;
import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Skill;
import com.example.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class EmployeeControllerMockitoTests {

    @InjectMocks
    EmployeeController empController;

    @Mock
    EmployeeService empServ;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }
       void testAddEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Ravi");
        emp.setContactNo( "9999999999");
        Mockito.when(empServ.addEmployee(emp)).thenReturn(emp);

        Employee result = empController.addEmployee(emp);
        assertEquals("Ravi", result.getName());
    }

    @Test
    void testAddEmployeeDto() {
        EmpInputDto inputDto = new EmpInputDto("Ravi", "9999999999", "ravi@example.com", "pass123");
        EmpOutputDto outputDto = new EmpOutputDto("Ravi", "9999999999", "ravi@example.com");

        Mockito.when(empServ.addEmployeeDto(inputDto)).thenReturn(outputDto);

        EmpOutputDto result = empController.addEmployeeDto(inputDto);
        assertEquals("Ravi", result.getName());
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee();
        emp.setEmpId(102);
        emp.setName("Raj");
        emp.setContactNo( "9999999999");
        Mockito.when(empServ.updateEmployee(emp)).thenReturn(emp);

        Employee result = empController.updateEmployee(emp);
        assertEquals("Raj", result.getName());
    }

    @Test
    void testDeleteEmployee() {
        Mockito.doNothing().when(empServ).deleteEmployee(103);
        empController.deleteEmployee(103);
        Mockito.verify(empServ).deleteEmployee(103);
    }

    @Test
    void testGetAllEmployees() {
        Employee emp1 = new Employee();
        emp1.setEmpId(102);
        emp1.setName("Raj");
        emp1.setContactNo( "9999999999");
        Employee emp2 = new Employee();
        emp2.setEmpId(101);
        emp2.setName("Raji");
        emp2.setContactNo( "9999999999");
        

        Mockito.when(empServ.getAllEmployees()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> result = empController.getAllEmployees();
        assertEquals(2, result.size());
        assertEquals("Raj", result.get(0).getName());
    }

    @Test
    void testGetEmployeeById() {
        Employee emp = new Employee();
        emp.setEmpId(111);
        emp.setName("Raki");
        emp.setContactNo( "88888888");
        Mockito.when(empServ.getEmployeeById(104)).thenReturn(emp);

        Employee result = empController.getEmployeeById(104);
        assertEquals("Raki", result.getName());
    }

    @Test
    void testGetEmployeeByName() {
        Employee emp = new Employee();
        emp.setEmpId(131);
        emp.setName("Sneha");
        emp.setContactNo( "9999999999");

        Mockito.when(empServ.getEmployeeByName("Sneha")).thenReturn(emp);

        Employee result = empController.getEmployeeByName("Sneha");
        assertEquals("Sneha", result.getName());
    }

    @Test
    void testUpdateEmployeeContactNo() {
        Employee emp = new Employee();
        emp.setEmpId(151);
        emp.setName("Arjun");
        emp.setContactNo( "9999999999");

        Mockito.when(empServ.updateEmployeeContactNo(106, "8888888888")).thenReturn(emp);

        Employee result = empController.updateEmployeeContactNo(106, "8888888888");
        assertEquals("Arjun", result.getName());
        assertEquals("7777777777", result.getContactNo()); // assuming service doesn't update in mock
    }

    @Test
    void testGetEmpByEmail() {
        EmpOutputDto outputDto = new EmpOutputDto("Kiran", "9999999999", "kiran@example.com");

        Mockito.when(empServ.getEmpByEmail("kiran@example.com")).thenReturn(outputDto);

        EmpOutputDto result = empController.getEmpByEmail("kiran@example.com");
        assertEquals("Kiran", result.getName());
    }

    @Test
    void testUpdateAddress() {
        Address addr = new Address();
        addr.setCity("Hyderabad");
        addr.setState("Telangana");

        Employee emp = new Employee();
        emp.setEmpId(107);
        emp.setName("Ovia");
        emp.setContactNo( "9999999999");
        emp.setAddrList(new ArrayList<>(List.of(addr)));

        Mockito.when(empServ.updateAddress(107, addr)).thenReturn(emp);

        Employee result = empController.updateAddress(107, addr);
        assertEquals("Ovia", result.getName());
        assertEquals("Hyderabad", result.getAddrList().get(0).getCity());
    }

    @Test
    void testUpdateEmpSkills() {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Raji");
        emp.setContactNo( "9999999999");

        Mockito.when(empServ.updateEmpSkills(108, 5)).thenReturn(emp);

        Employee result = empController.updateEmpSkills(108, 5);
        assertEquals("Raji", result.getName());
    }
}
