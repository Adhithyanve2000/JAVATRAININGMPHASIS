package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.entity.Login;
import com.example.exceptions.InvalidCredentialsException;
import com.example.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	
	public LoginOutputDto login(LoginInputDto login) {
		return null;
	}

	// Login
	@Override
	public Login login(Login login) throws InvalidCredentialsException {
		Optional<Login> optObj = loginRepo.findById(login.getEmail());

		if (optObj.isPresent()) {
			Login dbLogin = optObj.get();

			if (login.getPassword().equalsIgnoreCase(dbLogin.getPassword())
					&& login.getRole().equalsIgnoreCase(dbLogin.getRole())) {
				dbLogin.setLogin(true);
				return loginRepo.save(dbLogin);

			} else {
				// Throw InvalidCredentialsException
				throw new InvalidCredentialsException("Invalid Credentials");
			}
		} else {
			// throw InvalidEmail exception
			return null;
		}
	}

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

}
