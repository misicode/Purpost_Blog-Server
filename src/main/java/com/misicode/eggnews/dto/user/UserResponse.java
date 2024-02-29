package com.misicode.eggnews.dto.user;

public class UserResponse {
    private String idUser;

    private String email;

    private String names;

    private String surnames;

    private String role;

    public UserResponse(String idUser, String email, String names, String surnames, String role) {
        this.idUser = idUser;
        this.email = email;
        this.names = names;
        this.surnames = surnames;
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
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
