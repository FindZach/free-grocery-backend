package com.findzach.mastin.service;

import com.findzach.mastin.domain.MastinUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MastinUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here we are hardcoding an admin account for simplicity
        if ("admin".equals(username)) {
            return new MastinUser(
                    1L,
                    "admin",
                    "{noop}adminpassword", // {noop} for no password encoding, replace with BCrypt for production
                    "ROLE_ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
