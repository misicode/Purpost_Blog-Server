package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

import lombok.Builder;

@Builder
public record ImageResponse(
    String idImage,
    String name,
    String url
) { }
