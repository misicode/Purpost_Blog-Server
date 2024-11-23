package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

public record UserResponse(
    String idUser,
    String username,
    String names,
    String surnames
) { }
