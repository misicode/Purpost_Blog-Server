package com.misicode.purpost.authservice.dto;

import java.time.LocalDateTime;

public class UserResponse {
    private String email;

    private String password;

    private String names;

    private String surnames;

    private Boolean isActive = true;

    private Role role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
