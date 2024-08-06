package com.misicode.purpost.userservice.services.role;

import com.misicode.purpost.userservice.domain.Role;
import com.misicode.purpost.userservice.domain.RoleEnum;
import com.misicode.purpost.userservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RoleServiceImpl implements IRoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Mono<Role> getRoleByName(RoleEnum name) {
        return roleRepository.findByName(name)
                .switchIfEmpty(roleRepository.save(new Role(name)));
    }
}
