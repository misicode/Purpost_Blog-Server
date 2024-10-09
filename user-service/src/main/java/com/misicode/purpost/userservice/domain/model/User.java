package com.misicode.purpost.userservice.domain.model;

public class User {
    private String idUser;
    private String username;
    private String email;
    private String password;
    private String names;
    private String surnames;
    private Boolean isActive;
    private String idRole;

    public User(String idUser, String username, String email, String password, String names, String surnames, Boolean isActive, String idRole) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.names = names;
        this.surnames = surnames;
        this.isActive = isActive;
        this.idRole = idRole;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
}
