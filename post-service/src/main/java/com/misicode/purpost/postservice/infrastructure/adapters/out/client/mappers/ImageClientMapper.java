package com.misicode.purpost.postservice.infrastructure.adapters.out.client.mappers;

import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.dtos.response.ImageClientResponse;

public class ImageClientMapper {
    public ImageClientMapper() {
        throw new UnsupportedOperationException();
    }

    public static Image toImage(ImageClientResponse imageClientResponse) {
        return new Image(
                imageClientResponse.getIdImage(),
                imageClientResponse.getName(),
                imageClientResponse.getUrl(),
                null
        );
    }
}
