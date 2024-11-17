package com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
    @NotBlank
    @NotNull
    private String account;

    @NotBlank
    @NotNull
    private String password;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
