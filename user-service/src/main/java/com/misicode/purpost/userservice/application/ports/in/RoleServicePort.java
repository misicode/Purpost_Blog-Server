package com.misicode.purpost.userservice.application.ports.in;

import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.domain.model.RoleEnum;
import reactor.core.publisher.Mono;

public interface RoleServicePort {
    Mono<Role> findByName(RoleEnum name);
}
