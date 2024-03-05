package com.misicode.purpost.imageservice.dto;

import com.misicode.purpost.imageservice.validators.ValidFile;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ImageRequest {
    @NotNull
    @ValidFile
    private MultipartFile image;

    public ImageRequest(MultipartFile image) {
        this.image = image;
    }

    public MultipartFile getImage() {
        return image;
    }
}
