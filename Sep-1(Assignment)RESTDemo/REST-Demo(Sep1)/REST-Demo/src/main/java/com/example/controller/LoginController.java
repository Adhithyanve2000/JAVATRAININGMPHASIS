package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Login;
import com.example.service.LoginService;
import com.example.service.LoginServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginServiceI;
	
	// login
	@PostMapping("/login")
	EmpOutputDto login(@RequestBody EmpInputDto login) {
		return loginServiceI.login(login);
	}
	
	// logout
	@PostMapping("/logout")
	Login logout(@RequestBody String email) {
		return loginServiceI.logout(email);
	}
	
	// change/reset password
	
	
	// forget password

}
