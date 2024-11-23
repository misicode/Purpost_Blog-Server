package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request;

import com.misicode.purpost.imageservice.domain.validators.ValidFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;

public record ImageUpdateRequest(
    @NotNull
    @NotBlank
    String idImage,

    @NotNull
    @ValidFile
    FilePart image
) { }
