package com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
    @NotBlank
    @NotNull
    String account,

    @NotBlank
    @NotNull
    String password
) { }
