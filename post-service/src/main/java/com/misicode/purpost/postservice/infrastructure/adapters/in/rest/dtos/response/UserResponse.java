package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

import lombok.Builder;

@Builder
public record UserResponse(
    String idUser,
    String username,
    String names,
    String surnames
) { }
