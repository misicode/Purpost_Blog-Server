package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.Image;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface ImageWebClientPort {
    Mono<Image> findById(String id);

    Mono<Image> save(FilePart image);

    Mono<Image> update(String id, FilePart image);
}
