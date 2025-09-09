package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enitty.Login;

public interface LoginRepo extends JpaRepository<Login, String> {

}