package com.example.demo.entity;

import com.example.demo.entity.customer.Customer;

import java.util.List;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String userTime;
    private Customer customer;
    private List<String> roles;

    public JwtResponse() {
    }

    public JwtResponse(String token, Integer id, String username, String userTime, Customer customer, List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.userTime = userTime;
        this.customer = customer;
        this.roles = roles;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}