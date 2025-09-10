package com.example.service;

import com.example.entity.User;
import java.util.List;

public interface UserService {
    void addUser(int id, String username, String fullName, String contactNo,
                 String email, String password, String role, java.time.LocalDate dob);

    void delete(int id);
    List<User> list();
    User get(int id);
    User searchUserByName(String fullName);
    void update(User user);
    void deleteUserByName(String fullName);
}
