package com.misicode.purpost.authservice.dto;

public class UserDataResponse {
    private String username;

    private String password;

    private RoleResponse role;

    public UserDataResponse() {
    }

    public UserDataResponse(String username, String password, RoleResponse role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

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

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }
}
