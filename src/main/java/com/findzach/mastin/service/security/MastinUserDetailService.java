package com.findzach.mastin.service.security;

import com.findzach.mastin.domain.user.MastinUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MastinUserDetailService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here we are hardcoding an admin account for simplicity / testing
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
