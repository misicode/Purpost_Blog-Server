package com.misicode.purpost.authservice.services.role;

import com.misicode.purpost.authservice.domain.Role;
import com.misicode.purpost.authservice.domain.RoleEnum;
import com.misicode.purpost.authservice.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(RoleEnum name) {
        Role role = roleRepository.findByName(name).orElse(null);

        if(role == null) {
            role = roleRepository.save(new Role(name));
        }

        return role;
    }
}
