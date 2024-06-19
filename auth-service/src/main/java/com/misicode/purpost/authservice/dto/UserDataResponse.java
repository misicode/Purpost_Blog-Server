package com.misicode.purpost.authservice.dto;

public class UserDataResponse {
    private String email;

    private String password;

    private RoleResponse role;

    public UserDataResponse() {
    }

    public UserDataResponse(String email, String password, RoleResponse role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }
}
