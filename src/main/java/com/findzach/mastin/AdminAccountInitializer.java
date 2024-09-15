package com.findzach.mastin;

import com.findzach.mastin.domain.MastinUser;
import com.findzach.mastin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AdminAccountInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminAccountInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner createAdminAccount() {
        return args -> {
            String encodedPassword = passwordEncoder.encode("adminpassword");
            MastinUser adminUser = new MastinUser(1L, "admin", encodedPassword, "ROLE_ADMIN");
            System.out.println("Admin user created with username: " + adminUser.getUsername() + " and password: " + adminUser.getPassword());
            userRepository.save(adminUser);
        };
    }
}