package com.misicode.purpost.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserCreateRequest {
    @NotBlank
    @NotNull
    private String username;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Size(min = 6)
    private String password;

    @NotBlank
    @NotNull
    private String names;

    @NotBlank
    @NotNull
    private String surnames;

    public String getUsername() {
        return username;
    }

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
}
