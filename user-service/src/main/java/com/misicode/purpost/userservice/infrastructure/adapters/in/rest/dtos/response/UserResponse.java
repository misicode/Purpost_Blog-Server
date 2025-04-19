package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

import lombok.Builder;

@Builder
public record UserResponse(
    String idUser,
    String username,
    String email,
    String names,
    String surnames,
    String idRole
) { }