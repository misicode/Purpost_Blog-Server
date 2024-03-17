package com.misicode.purpost.imageservice.services.image;

import com.misicode.purpost.imageservice.domain.Image;
import com.misicode.purpost.imageservice.dto.ImageCreateRequest;
import com.misicode.purpost.imageservice.dto.ImageUpdateRequest;

public interface IImageService {
    Image getImageById(String id);

    Image saveImage(ImageCreateRequest imageRequest);

    Image updateImage(ImageUpdateRequest imageRequest);
}
