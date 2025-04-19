package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response;

import lombok.Builder;

@Builder
public record UserDataResponse(
    String username,
    String password,
    String idRole
) { }
