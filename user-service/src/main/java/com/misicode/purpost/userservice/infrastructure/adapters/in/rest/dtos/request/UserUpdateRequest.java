package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserUpdateRequest {
    @NotNull
    @NotBlank
    private String username;

    @NotBlank
    @NotNull
    private String names;

    @NotBlank
    @NotNull
    private String surnames;

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
