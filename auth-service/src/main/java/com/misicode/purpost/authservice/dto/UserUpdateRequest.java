package com.misicode.purpost.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserUpdateRequest {
    @NotBlank
    @NotNull
    private String names;

    @NotBlank
    @NotNull
    private String surnames;

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }
}
