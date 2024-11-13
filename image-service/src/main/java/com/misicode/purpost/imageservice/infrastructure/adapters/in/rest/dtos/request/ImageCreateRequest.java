package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request;

import com.misicode.purpost.imageservice.domain.validators.ValidFile;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;

public class ImageCreateRequest {
    @NotNull
    @ValidFile
    private FilePart image;

    public ImageCreateRequest(FilePart image) {
        this.image = image;
    }

    public FilePart getImage() {
        return image;
    }
}
