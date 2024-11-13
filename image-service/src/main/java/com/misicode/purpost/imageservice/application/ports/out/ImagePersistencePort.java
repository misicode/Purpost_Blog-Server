package com.misicode.purpost.imageservice.application.ports.out;

import com.misicode.purpost.imageservice.domain.model.Image;
import reactor.core.publisher.Mono;

public interface ImagePersistencePort {
    Mono<Image> findById(String id);

    Mono<Image> save(Image image);
}
