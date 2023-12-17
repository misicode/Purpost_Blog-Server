package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.Role;
import com.misicode.eggnews.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleByName(ERole role) {
        return roleRepository.findByRole(role).orElse(null);
    }
}
