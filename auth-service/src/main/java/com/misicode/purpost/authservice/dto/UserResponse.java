package com.misicode.purpost.authservice.dto;

import java.time.LocalDateTime;

public class UserResponse {
    private String email;

    private String password;

    private String names;

    private String surnames;

    private Boolean isActive = true;

    private RoleResponse role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }

    public Boolean getActive() {
        return isActive;
    }

    public RoleResponse getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
