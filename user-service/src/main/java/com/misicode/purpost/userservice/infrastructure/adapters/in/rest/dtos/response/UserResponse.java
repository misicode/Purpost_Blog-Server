package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

public class UserResponse {
    private String idUser;
    private String username;
    private String email;
    private String names;
    private String surnames;
    private String idRole;

    public UserResponse(String idUser, String username, String email, String names, String surnames, String idRole) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.names = names;
        this.surnames = surnames;
        this.idRole = idRole;
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

    public String getIdRole() {
        return idRole;
    }
}