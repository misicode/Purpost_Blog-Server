package com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.imageservice.domain.model.Image;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageCreateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.request.ImageUpdateRequest;
import com.misicode.purpost.imageservice.infrastructure.adapters.in.rest.dtos.response.ImageResponse;

public class ImageRestMapper {
    private ImageRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static Image toImage(ImageCreateRequest image) {
        return Image.builder()
                .image(image.image())
                .build();
    }

    public static Image toImage(ImageUpdateRequest image) {
        return Image.builder()
                .idImage(image.idImage())
                .image(image.image())
                .build();
    }

    public static ImageResponse toImageResponse(Image image) {
        return ImageResponse.builder()
                .idImage(image.getIdImage())
                .name(image.getName())
                .url(image.getUrl())
                .build();
    }
}