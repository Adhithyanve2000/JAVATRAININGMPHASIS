package com.example.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String street;
    
    private String city;
    private String state;

    @ManyToMany(mappedBy = "addresses")
    private Set<Employee> employees;

    
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
          this.addressId = addressId;
    }

      public String getStreet() {
       return street;
    }

   public void setStreet(String street) {
        this.street = street;
    }

       public String getCity() {
          return city;
    }

      public void setCity(String city) {
         this.city = city;
    }

    public String getState() {
       return state;
    }

      public void setState(String state) {
          this.state = state;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}