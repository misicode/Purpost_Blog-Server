package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;

public record PostCreateRequest(
    @NotBlank
    @NotNull
    String username,

    @NotBlank
    @NotNull
    String title,

    @NotBlank
    @NotNull
    String body,

    @NotNull
    FilePart image
) { }
