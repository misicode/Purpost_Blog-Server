package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

import java.time.LocalDateTime;

public record PostResponse(
    String idPost,
    String title,
    String body,
    Boolean isActive,
    UserResponse user,
    ImageResponse image,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) { }
