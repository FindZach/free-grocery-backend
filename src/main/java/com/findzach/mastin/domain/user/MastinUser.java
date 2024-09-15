package com.findzach.mastin.domain.user;

import com.findzach.mastin.domain.BaseEntity;
import jakarta.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class MastinUser extends BaseEntity implements UserDetails {

    private String username;
    private String password;

    // Store authorities as a comma-separated string in the database
    private String roles;

    // No-arg constructor for JPA
    public MastinUser() {
    }

    // Custom constructor
    public MastinUser(Long id, String username, String password, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    // Convert the comma-separated roles into a Collection of GrantedAuthority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
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

}