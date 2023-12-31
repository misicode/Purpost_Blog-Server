package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.Role;
import com.misicode.eggnews.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(ERole name) {
        Role role = roleRepository.findByName(name).orElse(null);

        if(role == null) {
            role = roleRepository.save(new Role(name));
        }

        return role;
    }
}
