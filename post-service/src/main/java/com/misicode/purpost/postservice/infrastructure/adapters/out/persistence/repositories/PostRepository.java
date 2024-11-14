package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.repositories;

import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.entity.PostEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PostRepository extends ReactiveMongoRepository<PostEntity, String> {
    Flux<PostEntity> findByIsActiveTrueOrderByCreatedAtDesc();

    Flux<PostEntity> findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(String idUser);
}
