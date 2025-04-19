package com.misicode.purpost.userservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String idUser;
    private String username;
    private String email;
    private String password;
    private String names;
    private String surnames;
    private Boolean isActive;
    private String idRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
