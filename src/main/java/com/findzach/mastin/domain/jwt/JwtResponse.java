package com.findzach.mastin.domain.jwt;

/**
 * @author Zach Smith
 * @since 9/15/2024
 */
public class JwtResponse {

    private String token;

    // Constructor
    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

}
