package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.Image;
import com.misicode.eggnews.dto.ImageResponse;

public class ImageMapper {
    private ImageMapper() {
        throw new UnsupportedOperationException();
    }

    public static ImageResponse mapToImageResponse(Image image) {
        return new ImageResponse(
                image.getName(),
                image.getUrl()
        );
    }
}
