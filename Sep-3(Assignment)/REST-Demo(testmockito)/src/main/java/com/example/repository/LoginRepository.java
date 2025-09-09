package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	


}
