package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateRequest(
    @NotNull
    @NotBlank
    String username,

    @NotBlank
    @NotNull
    String names,

    @NotBlank
    @NotNull
    String surnames
) { }
