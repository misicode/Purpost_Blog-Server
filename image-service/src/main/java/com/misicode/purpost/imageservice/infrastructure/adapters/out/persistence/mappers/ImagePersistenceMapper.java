package com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.imageservice.domain.model.Image;
import com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.entity.ImageEntity;

public class ImagePersistenceMapper {
    private ImagePersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static ImageEntity toImageEntity(Image image) {
        return ImageEntity.builder()
                .idImage(image.getIdImage())
                .name(image.getName())
                .url(image.getUrl())
                .build();
    }

    public static Image toImage(ImageEntity image) {
        return Image.builder()
                .idImage(image.getIdImage())
                .name(image.getName())
                .url(image.getUrl())
                .build();
    }
}
