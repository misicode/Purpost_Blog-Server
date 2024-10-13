package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

public class UserResponse {
    private String idUser;
    private String username;
    private String names;
    private String surnames;

    public UserResponse(String idUser, String username, String names, String surnames) {
        this.idUser = idUser;
        this.username = username;
        this.names = names;
        this.surnames = surnames;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }
}
