package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request;

import com.misicode.purpost.imageservice.domain.validators.ValidFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ImageUpdateRequest {
    @NotNull
    @NotBlank
    private String idImage;

    @NotNull
    @ValidFile
    private MultipartFile image;

    public ImageUpdateRequest(String idImage, MultipartFile image) {
        this.idImage = idImage;
        this.image = image;
    }

    public String getIdImage() {
        return idImage;
    }

    public MultipartFile getImage() {
        return image;
    }
}
