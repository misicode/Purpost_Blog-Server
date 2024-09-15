package com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.imageservice.domain.model.Image;
import com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.entity.ImageEntity;

public class ImagePersistenceMapper {
    private ImagePersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static ImageEntity toImageEntity(Image image) {
        return new ImageEntity(
                image.getIdImage(),
                image.getName(),
                image.getUrl()
        );
    }

    public static Image toImage(ImageEntity image) {
        return new Image(
                image.getIdImage(),
                null,
                image.getName(),
                image.getUrl()
        );
    }
}
