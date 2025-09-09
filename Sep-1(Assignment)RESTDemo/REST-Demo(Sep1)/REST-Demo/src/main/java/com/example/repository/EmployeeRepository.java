package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Optional<Employee> findByName(String name);
	
	
	// Native Query
	//@NativeQuery("select * from employee where name=:empName")
	//Optional<Employee> getEmpByName(@Param("empName") String name);
	
	
	// JPQL Query
	@Query("select e from Employee e where e.name=:empName")
	Optional<Employee> getEmpByName(@Param("empName") String name);
}
