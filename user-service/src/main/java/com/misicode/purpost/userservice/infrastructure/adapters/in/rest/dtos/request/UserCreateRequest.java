package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
    @NotBlank
    @NotNull
    String username,

    @NotBlank
    @NotNull
    @Email
    String email,

    @NotBlank
    @NotNull
    @Size(min = 6)
    String password,

    @NotBlank
    @NotNull
    String names,

    @NotBlank
    @NotNull
    String surnames
) { }
