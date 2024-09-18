package com.misicode.purpost.userservice.application.services;

import com.misicode.purpost.userservice.application.ports.in.RoleServicePort;
import com.misicode.purpost.userservice.application.ports.out.RolePersistencePort;
import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.domain.model.RoleEnum;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RoleService implements RoleServicePort {
    private final RolePersistencePort rolePersistencePort;

    public RoleService(RolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Mono<Role> findByName(RoleEnum name) {
        return rolePersistencePort
                .findByName(name)
                .switchIfEmpty(
                        rolePersistencePort.save(new Role(null, name))
                );
    }
}
