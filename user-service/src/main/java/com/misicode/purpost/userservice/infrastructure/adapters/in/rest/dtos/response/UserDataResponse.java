package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

public record UserDataResponse(
    String username,
    String password,
    String idRole
) { }
