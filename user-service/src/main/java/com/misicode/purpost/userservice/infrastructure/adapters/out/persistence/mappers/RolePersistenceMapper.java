package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.RoleEntity;

public class RolePersistenceMapper {
    private RolePersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static RoleEntity toRoleEntity(Role role) {
        return RoleEntity.builder()
                .idRole(role.getIdRole())
                .name(role.getName())
                .build();
    }

    public static Role toRole(RoleEntity roleEntity) {
        return Role.builder()
                .idRole(roleEntity.getIdRole())
                .name(roleEntity.getName())
                .build();
    }
}
