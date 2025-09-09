package com.example.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;

	import java.util.Arrays;
	import java.util.Optional;

	import com.example.dto.EmpInputDto;
	import com.example.dto.EmpOutputDto;
	import com.example.entity.Address;
	import com.example.entity.Employee;
	import com.example.entity.Login;
	import com.example.entity.Skill;
	import com.example.exceptions.EmployeeNotFoundException;
	import com.example.repository.EmployeeRepository;
	import com.example.repository.LoginRepository;
	import com.example.repository.SkillRepository;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;

	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

	import java.util.List;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceMockitoTest {
	


	// @InjectMock - Creates instance of a class and injects mocks that are created
		// with @Mock

		@InjectMocks
		EmployeeServiceImpl empServ;

		// @MockBean - Creates Mock of a class or interface
		@MockBean
		EmployeeRepository empRepo;


	    @MockBean
	    LoginRepository loginRepo;

	    @MockBean
	    SkillRepository skillRepo;


		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}

	    @Test
	    void testGetEmployeeById() {
	        Employee emp = new Employee();
	        emp.setEmpId(10);
	        emp.setName("Ravi");

	        Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
            Employee result = empServ.getEmployeeById(10);
	        assertEquals(10, result.getEmpId());
	        assertEquals("Ravi", result.getName());
	    }

	    @Test
	    void testAddEmployee() {
	        Employee emp = new Employee();
	        emp.setEmpId(10);
	        emp.setName("Ravi");
	        Mockito.when(empRepo.save(emp)).thenReturn(emp);
             Employee result = empServ.addEmployee(emp);
	        assertEquals("Ravi", result.getName());
	    }

	    @Test
	    void testUpdateEmployee() {
	        Employee emp = new Employee();
	        emp.setEmpId(11);
	        emp.setName("Kiran");
	        Mockito.when(empRepo.findById(11)).thenReturn(Optional.of(emp));
	        Mockito.when(empRepo.save(emp)).thenReturn(emp);
           Employee result = empServ.updateEmployee(emp);
	        assertEquals("Kiran", result.getName());
	    }

	    @Test
	    void testDeleteEmployee() {
	        Employee emp = new Employee();
	        emp.setEmpId(12);
	        emp.setName("Sita");

	        Mockito.when(empRepo.findById(12)).thenReturn(Optional.of(emp));
	        empServ.deleteEmployee(12);
	        Mockito.verify(empRepo).deleteById(12);
	    }

	    @Test
	    void testGetAllEmployees() {
	        Employee emp1 = new Employee();
	        Employee emp2 = new Employee();
	        emp1.setEmpId(101);
	        emp1.setName("Ram");
	        emp1.setContactNo("9999999999");
	        emp2.setEmpId(102);
	        emp2.setName("Raj");
	        emp2.setContactNo("8888888888");
            Mockito.when(empRepo.findAll()).thenReturn(Arrays.asList(emp1, emp2));
            List<Employee> result = empServ.getAllEmployees();
	        assertEquals(2, result.size());
	        assertEquals("Ram", result.get(0).getName());
	    }

	    @Test
	    void testGetEmployeeByName() {
	        Employee emp = new Employee();
	        emp.setEmpId(13);
	        emp.setName("Lakshmi");

	        Mockito.when(empRepo.getEmpByName("Lakshmi")).thenReturn(Optional.of(emp));
  Employee result = empServ.getEmployeeByName("Lakshmi");
	        assertEquals("Lakshmi", result.getName());
	    }

	    @Test
	    void testUpdateEmployeeContactNo() {
	        Employee emp = new Employee();
	        emp.setEmpId(14);
	        emp.setName("Arjun");
	        emp.setContactNo("1234567890");

	        Mockito.when(empRepo.findById(14)).thenReturn(Optional.of(emp));
	        Mockito.when(empRepo.save(emp)).thenReturn(emp);
	        Employee result = empServ.updateEmployeeContactNo(14, "9876543210");
	        assertEquals("9876543210", result.getContactNo());
	    }

	    @Test
	    void testAddEmployeeDto() {
	        EmpInputDto inputDto = new EmpInputDto("Ravi", "9999999999", "ravi@example.com", "pass123");

	        Employee emp = new Employee();
	        emp.setName("Ravi");
	        emp.setContactNo("9999999999");

	        Login login = new Login();
	        login.setEmail("ravi@example.com");
	        login.setPassword("pass123");
	        login.setRole("Employee");
            emp.setLogin(login);

	        Mockito.when(empRepo.save(Mockito.any(Employee.class))).thenReturn(emp);

	        EmpOutputDto result = empServ.addEmployeeDto(inputDto);
	        assertEquals("Ravi", result.getName());
	        assertEquals("ravi@example.com", result.getEmail());
	        assertEquals("9999999999", result.getContactNo());
	    }

	    @Test
	    void testGetEmpByEmail() {
	        EmpOutputDto outputDto = new EmpOutputDto("Ravi", "9999999999", "ravi@example.com");

	        Mockito.when(empRepo.getEmpByEmail("ravi@example.com")).thenReturn(outputDto);

	        EmpOutputDto result = empServ.getEmpByEmail("ravi@example.com");
	        assertEquals("Ravi", result.getName());
	    }

	    @Test
	    void testUpdateAddress() {
	        Address addr = new Address();
	        addr.setCity("Hyderabad");

	        Employee emp = new Employee();
	        emp.setEmpId(15);
	        emp.setName("Karthik");
	        emp.setAddrList(Arrays.asList());

	        Mockito.when(empRepo.findById(15)).thenReturn(Optional.of(emp));
	        Mockito.when(empRepo.save(emp)).thenReturn(emp);

	        Employee result = empServ.updateAddress(15, addr);
	        assertEquals("Karthik", result.getName());
	    }

	    @Test
	    void testUpdateEmpSkills() {
	        Skill skill = new Skill();
	        skill.setSkillId(1);
	        skill.setSkillName("Java");

	        Employee emp = new Employee();
	        emp.setEmpId(16);
	        emp.setName("Meena");
	        emp.setSkill(Arrays.asList());

	        Mockito.when(empRepo.findById(16)).thenReturn(Optional.of(emp));
	        Mockito.when(skillRepo.findById(1)).thenReturn(Optional.of(skill));
	        Mockito.when(empRepo.save(emp)).thenReturn(emp);

	        Employee result = empServ.updateEmpSkills(16, 1);
	        assertEquals("Meena", result.getName());
	    }

	    @Test
	    void testUpdateEmployeeNotFound() {
	        Employee emp = new Employee();
	        emp.setEmpId(99);
	        emp.setName("Ghost");

	        Mockito.when(empRepo.findById(99)).thenReturn(Optional.empty());

	        assertThrows(EmployeeNotFoundException.class, () -> empServ.updateEmployee(emp));
	    }

	    @Test
	    void testDeleteEmployeeNotFound() {
	        Mockito.when(empRepo.findById(999)).thenReturn(Optional.empty());

	        assertThrows(EmployeeNotFoundException.class, () -> empServ.deleteEmployee(999));
	    }
	



	
	
	/*@Test
	void testUpdateEmployeeName() {
		Employee emp = new Employee();
		emp.setEmpId(10);
		emp.setEmpName("Ravi");
		
		Employee updatedEmp = new Employee();
		updatedEmp.setEmpId(10);
		updatedEmp.setEmpName("Sam");
		
		Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
		Mockito.when(empRepo.save(emp)).thenReturn(updatedEmp);
		
		Employee emp2  =empServ.updateEmployeeName(10, "Sam");
		assertEquals("Sam", emp2.getEmpName());
	}
	@Test
	void testDeleteEmployee() {
		Employee emp = new Employee();
		emp.setEmpId(10);
		emp.setEmpName("Ravi");
		
		Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
		//Mockito.when(empRepo.deleteById(10)).
		Employee emp1= empServ.deleteEmployee(10);
		assertEquals(10, emp1.getEmpId());
		
	}
	*/

}
