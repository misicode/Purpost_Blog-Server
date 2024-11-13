package com.misicode.purpost.imageservice.application.ports.in;

import com.misicode.purpost.imageservice.domain.model.Image;
import reactor.core.publisher.Mono;

public interface ImageServicePort {
    Mono<Image> findById(String id);

    Mono<Image> save(Image image);

    Mono<Image> update(Image image);
}
