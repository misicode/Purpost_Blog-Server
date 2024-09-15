package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request;

import com.misicode.purpost.imageservice.domain.validators.ValidFile;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ImageCreateRequest {
    @NotNull
    @ValidFile
    private MultipartFile image;

    public ImageCreateRequest(MultipartFile image) {
        this.image = image;
    }

    public MultipartFile getImage() {
        return image;
    }
}
