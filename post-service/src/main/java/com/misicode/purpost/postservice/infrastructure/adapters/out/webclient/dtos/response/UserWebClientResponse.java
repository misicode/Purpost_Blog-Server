package com.misicode.purpost.postservice.infrastructure.adapters.out.webclient.dtos.response;

public class UserWebClientResponse {
    private String idUser;
    private String username;
    private String email;
    private String names;
    private String surnames;
    private String idRole;

    public UserWebClientResponse(String idUser, String username, String email, String names, String surnames, String idRole) {
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
