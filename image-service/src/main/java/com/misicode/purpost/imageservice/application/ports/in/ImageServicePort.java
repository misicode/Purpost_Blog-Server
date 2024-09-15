package com.misicode.purpost.imageservice.application.ports.in;

import com.misicode.purpost.imageservice.domain.model.Image;

public interface ImageServicePort {
    Image findById(String id);

    Image save(Image image);

    Image update(Image image);
}
