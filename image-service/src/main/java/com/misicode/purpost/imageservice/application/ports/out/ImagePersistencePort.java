package com.misicode.purpost.imageservice.application.ports.out;

import com.misicode.purpost.imageservice.domain.model.Image;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ImagePersistencePort {
    Optional<Image> findById(String id);

    Image save(Image image);
}
