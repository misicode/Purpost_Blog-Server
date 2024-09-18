package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

public class UserDataResponse {
    private String username;

    private String password;

    private String idRole;

    public UserDataResponse(String username, String password, String idRole) {
        this.username = username;
        this.password = password;
        this.idRole = idRole;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdRole() {
        return idRole;
    }
}
