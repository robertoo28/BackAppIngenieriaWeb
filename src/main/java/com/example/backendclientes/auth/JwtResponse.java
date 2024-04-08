package com.example.backendclientes.auth;

public class JwtResponse {
    private String token;
    private String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

    // Getters y Setters
    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return this.type;
    }

    public void setTokenType(String type) {
        this.type = type;
    }
}

