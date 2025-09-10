package com.example.repository;

import com.example.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        try {
            users.add(user);
        } catch (Exception e) {
            System.out.println("Error while adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == id) {
                    users.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while deleting user by ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserByName(String fullName) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getFullName().trim().equalsIgnoreCase(fullName.trim())) {
                    users.remove(i);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while deleting user by name: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User searchUserByName(String fullName) {
        try {
            for (User u : users) {
                if (u.getFullName().equalsIgnoreCase(fullName)) {
                    System.out.println("The user:");
                    return u;
                }
            }
            System.out.println("There is no such user");
            return null;
        } catch (Exception e) {
            System.out.println("Error while searching user by name: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> list() {
        try {
            return users;
        } catch (Exception e) {
            System.out.println("Error while listing users: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User get(int id) {
        try {
            for (User u : users) {
                if (u.getId() == id) {
                    System.out.println("The user:");
                    return u;
                }
            }
            System.out.println("There is no such user");
            return null;
        } catch (Exception e) {
            System.out.println("Error while getting user by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId() == user.getId()) {
                    users.set(i, user);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
