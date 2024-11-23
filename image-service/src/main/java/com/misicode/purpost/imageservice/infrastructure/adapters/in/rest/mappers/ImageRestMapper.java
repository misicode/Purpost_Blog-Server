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
        return new Image(
                null,
                image.image(),
                null,
                null
        );
    }

    public static Image toImage(ImageUpdateRequest image) {
        return new Image(
                image.idImage(),
                image.image(),
                null,
                null
        );
    }

    public static ImageResponse toImageResponse(Image image) {
        return new ImageResponse(
                image.getIdImage(),
                image.getName(),
                image.getUrl()
        );
    }
}