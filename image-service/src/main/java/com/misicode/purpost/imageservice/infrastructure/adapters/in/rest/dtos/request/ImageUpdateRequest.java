package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request;

import com.misicode.purpost.imageservice.domain.validators.ValidFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;

public class ImageUpdateRequest {
    @NotNull
    @NotBlank
    private String idImage;

    @NotNull
    @ValidFile
    private FilePart image;

    public ImageUpdateRequest(String idImage, FilePart image) {
        this.idImage = idImage;
        this.image = image;
    }

    public String getIdImage() {
        return idImage;
    }

    public FilePart getImage() {
        return image;
    }
}
