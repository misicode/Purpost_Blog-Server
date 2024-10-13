package com.misicode.purpost.postservice.domain.model;

public class User {
    private String idUser;
    private String username;
    private String names;
    private String surnames;

    public User(String idUser, String username, String names, String surnames) {
        this.idUser = idUser;
        this.username = username;
        this.names = names;
        this.surnames = surnames;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }
}
