package com.findzach.mastin.domain.jwt;

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

    // Setter (optional, if needed)
    public void setToken(String token) {
        this.token = token;
    }
}
