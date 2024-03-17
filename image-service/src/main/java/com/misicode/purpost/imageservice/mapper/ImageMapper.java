package com.misicode.purpost.imageservice.mapper;

import com.misicode.purpost.imageservice.domain.Image;
import com.misicode.purpost.imageservice.dto.ImageResponse;

public class ImageMapper {
    private ImageMapper() {
        throw new UnsupportedOperationException();
    }

    public static ImageResponse mapToImageResponse(Image image) {
        return new ImageResponse(
                image.getIdImage(),
                image.getName(),
                image.getUrl()
        );
    }
}