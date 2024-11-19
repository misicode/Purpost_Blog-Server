package com.misicode.purpost.authservice.infrastructure.adapters.out.webclient.dtos.response;

public class UserDataWebClientResponse {
    private String username;
    private String password;
    private String idRole;

    public UserDataWebClientResponse(String username, String password, String idRole) {
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
