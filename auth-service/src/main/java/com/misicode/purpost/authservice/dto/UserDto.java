package com.misicode.purpost.authservice.dto;

import java.time.LocalDateTime;

public class UserDto {
    private String email;

    private String password;

    private String names;

    private String surnames;

    private Boolean isActive = true;

    private RoleDto role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public UserDto() {
    }

    public UserDto(String email, String names, String surnames) {
        this.email = email;
        this.names = names;
        this.surnames = surnames;
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

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }
}
