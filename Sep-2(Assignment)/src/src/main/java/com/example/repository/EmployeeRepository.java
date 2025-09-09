package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dto.EmpOutputDto;
import com.example.entity.Employee;
import com.example.entity.Skill;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Optional<Employee> findByName(String name);
	
	
	// Native Query
	//@NativeQuery("select * from employee where name=:empName")
	//Optional<Employee> getEmpByName(@Param("empName") String name);
	
	
	// JPQL Query
	@Query("select e from Employee e where e.name=:empName")
	Optional<Employee> getEmpByName(@Param("empName") String name);
	
	
	@NativeQuery("select employee.name, employee.contact_no, login.email from employee join login on employee.emp_login_fk=login.email where login.email=:email;")
	EmpOutputDto getEmpByEmail(@Param("email") String email);
	
	@Query("SELECT s FROM Employee e JOIN e.skills s WHERE e.id = :empId")
    List<Skill> findSkillsByEmployeeId(@Param("empId") Long empId);
}
