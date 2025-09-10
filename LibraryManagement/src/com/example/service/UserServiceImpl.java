package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepo = new UserRepositoryImpl();

    @Override
    public void addUser(int id, String username, String fullName, String contactNo,
                        String email, String password, String role, LocalDate dob) {
        try {
            User user = new User(id, username, fullName, contactNo, email, password, role, dob);
            userRepo.add(user);
            System.out.println("The user has been added");
        } catch (Exception e) {
            System.out.println("Error while adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            userRepo.delete(id);
            System.out.println("The user has been deleted");
        } catch (Exception e) {
            System.out.println("Error while deleting user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<User> list() {
        try {
            System.out.println("Here is the list of all Users:");
            return userRepo.list();
        } catch (Exception e) {
            System.out.println("Error while listing users: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User get(int id) {
        try {
            return userRepo.get(id);
        } catch (Exception e) {
            System.out.println("Error while retrieving user by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User searchUserByName(String fullName) {
        try {
            return userRepo.searchUserByName(fullName);
        } catch (Exception e) {
            System.out.println("Error while searching user by name: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user) {
        try {
            userRepo.update(user);
            System.out.println("The user has been updated");
        } catch (Exception e) {
            System.out.println("Error while updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserByName(String fullName) {
        try {
            userRepo.deleteUserByName(fullName);
            System.out.println("The user has been deleted by name");
        } catch (Exception e) {
            System.out.println("Error while deleting user by name: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
