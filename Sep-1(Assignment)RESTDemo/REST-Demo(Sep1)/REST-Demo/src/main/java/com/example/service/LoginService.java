package com.example.service;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Login;

public interface LoginService {
	EmpOutputDto login(EmpInputDto login);
	
	Login logout(String email);
	
	String changePassword(String email, String newPassword);

}
