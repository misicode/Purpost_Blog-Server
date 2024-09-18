package com.misicode.purpost.userservice.application.ports.out;

import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.domain.model.RoleEnum;
import reactor.core.publisher.Mono;

public interface RolePersistencePort {
    Mono<Role> findByName(RoleEnum name);

    Mono<Role> save(Role role);
}
