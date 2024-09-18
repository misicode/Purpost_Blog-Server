package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.repositories;

import com.misicode.purpost.userservice.domain.model.RoleEnum;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.RoleEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoleRepository extends ReactiveMongoRepository<RoleEntity, String> {
    Mono<RoleEntity> findByName(RoleEnum name);
}