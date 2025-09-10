package com.example.repository;

import com.example.entity.User;
import java.util.List;

public interface UserRepository {
    void add(User user);
    void delete(int id);
    void deleteUserByName(String fullName);
    User searchUserByName(String fullName);
    List<User> list();
    User get(int id);
    void update(User user);
}
