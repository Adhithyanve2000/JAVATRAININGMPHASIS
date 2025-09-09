package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.enitty.Customer;
import com.example.enitty.Employee;

@Repository
public interface CusRepo extends JpaRepository<Customer, Integer> {
 

}
