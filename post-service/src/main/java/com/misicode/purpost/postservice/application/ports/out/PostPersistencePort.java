package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostPersistencePort {
    Mono<Post> findById(String id);

    Flux<Post> findByIdUser(String idUser);

    Flux<Post> findAll();

    Mono<Post> save(Post post);

    Mono<Void> deleteById(String id);
}
