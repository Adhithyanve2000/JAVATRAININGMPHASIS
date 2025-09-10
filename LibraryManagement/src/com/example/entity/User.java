package com.example.entity;

import java.time.LocalDate;

public class User {
    private int id;
    private String username;
    private String fullName;
    private String contactNo;
    private String email;
    private String password;
    private String role;
    private LocalDate dob;

    public User() {}

    public User(int id, String username, String fullName, String contactNo,
                String email, String password, String role, LocalDate dob) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
    public String getContactNo() { return contactNo; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public LocalDate getDob() { return dob; }

    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', fullName='" + fullName +
               "', contactNo='" + contactNo + "', email='" + email +
               "', role='" + role + "', dob=" + dob + "}";
    }
}
