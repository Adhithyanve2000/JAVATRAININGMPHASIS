package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.entity.Login;
import com.example.exceptions.InvalidCredentialsException;
import com.example.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	// login
	@PostMapping("/login")
	Login login(@RequestBody Login login) throws InvalidCredentialsException {
		return loginService.login(login);
	}
	
	public LoginOutputDto login(LoginInputDto login) {
		return null;
	}
	
	
	// logout
	@PostMapping("/logout")
	Login logout(@RequestBody String email) {
		return loginService.logout(email);
	}
	
	// change/reset password
	
	
	// forget password

}
