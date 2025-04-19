package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response.ImageResponse;

public class ImageRestMapper {
    public ImageRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static ImageResponse toImageResponse(Image image) {
        return ImageResponse.builder()
                .idImage(image.getIdImage())
                .name(image.getName())
                .url(image.getUrl())
                .build();
    }
}
