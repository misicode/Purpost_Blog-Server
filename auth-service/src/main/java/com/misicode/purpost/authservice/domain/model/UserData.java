package com.misicode.purpost.authservice.domain.model;

public class UserData {
    private String username;

    private String password;

    private String idRole;

    public UserData() {
    }

    public UserData(String username, String password, String idRole) {
        this.username = username;
        this.password = password;
        this.idRole = idRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
}
