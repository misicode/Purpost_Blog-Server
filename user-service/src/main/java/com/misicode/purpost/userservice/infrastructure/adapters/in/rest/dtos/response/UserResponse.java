package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

public record UserResponse(
    String idUser,
    String username,
    String email,
    String names,
    String surnames,
    String idRole
) { }