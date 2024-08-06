package com.misicode.purpost.userservice.repositories;

import com.misicode.purpost.userservice.domain.Role;
import com.misicode.purpost.userservice.domain.RoleEnum;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoleRepository extends ReactiveMongoRepository<Role, String> {
    Mono<Role> findByName(RoleEnum name);
}