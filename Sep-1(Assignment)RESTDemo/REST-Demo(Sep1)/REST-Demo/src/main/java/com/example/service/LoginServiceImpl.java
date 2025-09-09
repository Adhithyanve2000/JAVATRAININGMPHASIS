package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmpInputDto;
import com.example.dto.EmpOutputDto;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;

	

	@Override
	public String changePassword(String email, String newPassword) {

		return null;
	}

	// Logout
	@Override
	public Login logout(String email) {
		Optional<Login> optObj = loginRepo.findById(email);

		if (optObj.isPresent()) {
			Login dbLogin = optObj.get();

			dbLogin.setLogin(false);
			return loginRepo.save(dbLogin);

		} else {
			// throw InvalidEmail exception
			return null;
		}
	}
	

	    @Override
	    public EmpOutputDto login(EmpInputDto loginDto) {
	        Optional<Login> optLogin = loginRepo.findById(loginDto.getEmail());

	        if (optLogin.isPresent()) {
	            Login dbLogin = optLogin.get();

	          

	            if (loginDto.getPassword().equalsIgnoreCase(dbLogin.getPassword()) && "Employee".equalsIgnoreCase(dbLogin.getRole())) {
	                dbLogin.setLogin(true);
	                loginRepo.save(dbLogin);

	                Employee employee = dbLogin.getEmployee(); 

	                
	                EmpOutputDto outputDto = new EmpOutputDto();
	                outputDto.setName(employee.getName());
	                outputDto.setEmail(dbLogin.getEmail());
	                outputDto.setContactNo(employee.getContactNo());

	                return outputDto;
	            }
	        }

	        // Invalid credentials or email not found
	        return null;
	    }
	

}
