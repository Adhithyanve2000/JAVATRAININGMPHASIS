package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.entity.Login;
import com.example.enums.Role;
import com.example.exceptions.InvalidCredentialsException;
import com.example.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    @Override
    public Login login(Login login) {
        try {
            Optional<Login> optObj = loginRepo.findById(login.getEmail());

            if (optObj.isPresent()) {
                Login dbLogin = optObj.get();

                if (login.getPassword().equalsIgnoreCase(dbLogin.getPassword())
                        && login.getRole().equals(dbLogin.getRole())) {
                    dbLogin.setLogin(true);
                    System.out.println("Welcome " + dbLogin.getRole());
                    return loginRepo.save(dbLogin);
                } else {
                    throw new InvalidCredentialsException("Invalid Credentials");
                }
            } else {
                throw new InvalidCredentialsException("Invalid Email");
            }
        } catch (InvalidCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String changePassword(String email, String newPassword) {
        try {
            Optional<Login> optObj = loginRepo.findById(email);
            if (optObj.isPresent()) {
                Login dbLogin = optObj.get();
                dbLogin.setPassword(newPassword);
                loginRepo.save(dbLogin);
                return "Password changed successfully";
            } else {
                throw new InvalidCredentialsException("Email not found");
            }
        } catch (InvalidCredentialsException e) {
            System.out.println("Password change failed: " + e.getMessage());
            return "Failed to change password";
        }
    }

    @Override
    public Login logout(String email) {
        try {
            Optional<Login> optObj = loginRepo.findById(email);
            if (optObj.isPresent()) {
                Login dbLogin = optObj.get();
                dbLogin.setLogin(false);
                return loginRepo.save(dbLogin);
            } else {
                throw new InvalidCredentialsException("Email not found");
            }
        } catch (InvalidCredentialsException e) {
            System.out.println("Logout failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public LoginOutputDto login1(LoginInputDto loginDto) throws InvalidCredentialsException  {
        try {
            Optional<Login> optLogin = loginRepo.findById(loginDto.getEmail());

            if (optLogin.isPresent()) {
                Login dbLogin = optLogin.get();

                if (loginDto.getPassword() != null && dbLogin.getPassword() != null
                        && loginDto.getPassword().equalsIgnoreCase(dbLogin.getPassword())
                        && Role.EMPLOYEE == dbLogin.getRole()) {

                    dbLogin.setLogin(true);
                    loginRepo.save(dbLogin);

                    LoginOutputDto log1 = new LoginOutputDto();
                    log1.setLogin(true);
                    log1.setEmail(dbLogin.getEmail());
                    log1.setRole(dbLogin.getRole());

                    return log1;
                } else {
                    throw new InvalidCredentialsException("Invalid credentials");
                }
            } else {
                throw new InvalidCredentialsException("Email not found");
            }
        } catch (InvalidCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }
}