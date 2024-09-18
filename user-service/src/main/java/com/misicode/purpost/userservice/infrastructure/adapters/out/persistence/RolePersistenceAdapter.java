package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence;

import com.misicode.purpost.userservice.application.ports.out.RolePersistencePort;
import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.domain.model.RoleEnum;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers.RolePersistenceMapper;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.repositories.RoleRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RolePersistenceAdapter implements RolePersistencePort {
    private final RoleRepository roleRepository;

    public RolePersistenceAdapter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Mono<Role> findByName(RoleEnum name) {
        return roleRepository
                .findByName(name)
                .map(RolePersistenceMapper::toRole);
    }

    @Override
    public Mono<Role> save(Role role) {
        return roleRepository
                .save(RolePersistenceMapper.toRoleEntity(role))
                .map(RolePersistenceMapper::toRole);
    }
}
