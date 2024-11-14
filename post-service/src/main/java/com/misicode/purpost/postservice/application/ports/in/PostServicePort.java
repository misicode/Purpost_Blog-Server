package com.misicode.purpost.postservice.application.ports.in;

import com.misicode.purpost.postservice.domain.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostServicePort {
    Mono<Post> findById(String id);

    Flux<Post> findByUsername(String username);

    Flux<Post> findAll();

    Mono<Post> create(Post post);

    Mono<Post> update(Post post);

    Mono<Void> deleteById(String id);
}
