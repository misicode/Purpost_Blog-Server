package com.misicode.eggnews.dto;

public class UserDto {
    private String idUser;
    private String email;
    private String names;
    private String surnames;

    public UserDto(String idUser, String email, String names, String surnames) {
        this.idUser = idUser;
        this.email = email;
        this.names = names;
        this.surnames = surnames;
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
}
