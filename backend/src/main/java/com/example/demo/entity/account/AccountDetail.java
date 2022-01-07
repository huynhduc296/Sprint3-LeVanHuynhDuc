//package com.example.demo.entity.account;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Setter
//@Getter
//public class AccountDetail implements UserDetails {
//    private final Account account;
//
//    public AccountDetail(Account account) {
//        this.account = account;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        for (Role role : this.account.getRoles()) {
//            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
//        }
//        return authorityList;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.account.getAccountPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.account.getAccountUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.account.isActiveFlag();
//    }
//}