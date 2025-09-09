package com.example.service;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.entity.Login;
import com.example.exceptions.InvalidCredentialsException;

public interface LoginService {
	Login login(Login login) throws InvalidCredentialsException;
    LoginOutputDto login1(LoginInputDto loginDto) throws InvalidCredentialsException;
	
	Login logout(String email);
	
	String changePassword(String email, String newPassword);

}
