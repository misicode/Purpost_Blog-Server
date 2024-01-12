package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.Image;
import com.misicode.eggnews.dto.ImageDto;

public class ImageMapper {
    public static ImageDto mapToImageDto(Image image) {
        return new ImageDto(
                image.getName(),
                image.getUrl()
        );
    }
}
