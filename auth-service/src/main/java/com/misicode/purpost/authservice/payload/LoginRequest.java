package com.misicode.purpost.authservice.payload;

import jakarta.validation.constraints.Email;
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
