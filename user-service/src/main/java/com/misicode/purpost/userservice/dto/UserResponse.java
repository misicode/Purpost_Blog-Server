package com.misicode.purpost.userservice.dto;

public class UserResponse {
    private String idUser;

    private String username;

    private String email;

    private String names;

    private String surnames;

    private String role;

    public UserResponse(String idUser, String username, String email, String names, String surnames, String role) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.names = names;
        this.surnames = surnames;
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getRole() {
        return role;
    }
}