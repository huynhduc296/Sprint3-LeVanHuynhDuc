package com.example.demo.service.Impl;

import com.example.demo.entity.account.Account;
import com.example.demo.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer accountId;

    private String accountUsername;

    private String userTime;

    private Customer customer;

    @JsonIgnore
    private String accountPassword;

    private Collection<? extends GrantedAuthority> authorities;



    public UserDetailsImpl(Integer accountId, String accountUsername, Customer customer, String accountPassword, List<GrantedAuthority> authorities) {
        this.accountId = accountId;
        this.accountUsername = accountUsername;
        this.userTime = userTime;
        this.customer = customer;
        this.accountPassword = accountPassword;
        this.authorities = authorities;
    }


    public static UserDetailsImpl build(Account accout) {
        List<GrantedAuthority> authorities = accout.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                accout.getAccountId(),
                accout.getAccountUsername(),
                accout.getCustomer(),
                accout.getAccountPassword(),
                authorities
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return accountId;
    }

    public String getUserTime() {
        return userTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String getPassword() {
        return accountPassword;
    }

    @Override
    public String getUsername() {
        return accountUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(accountId, user.accountId);
    }

}