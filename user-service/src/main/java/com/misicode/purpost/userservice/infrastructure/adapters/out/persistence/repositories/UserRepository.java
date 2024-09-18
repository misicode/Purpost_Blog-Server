package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.repositories;

import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {
    Mono<UserEntity> findByEmail(String email);

    Mono<UserEntity> findByUsername(String username);

    Mono<UserEntity> findByUsernameOrEmail(String username, String email);

    Mono<Boolean> existsByEmail(String email);

    Mono<Boolean> existsByUsername(String username);
}
