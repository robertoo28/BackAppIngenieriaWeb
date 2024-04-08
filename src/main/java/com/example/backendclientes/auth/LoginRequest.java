package com.example.backendclientes.auth;

public class LoginRequest {
    private String username;
    private String password;

    // Constructor vacío necesario para la deserialización
    public LoginRequest() {}

    // Constructor con todos los campos
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

