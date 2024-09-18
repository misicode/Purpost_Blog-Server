package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.userservice.domain.model.Role;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.RoleEntity;

public class RolePersistenceMapper {
    private RolePersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static RoleEntity toRoleEntity(Role role) {
        return new RoleEntity(
                role.getIdRole(),
                role.getName()
        );
    }

    public static Role toRole(RoleEntity roleEntity) {
        return new Role(
                roleEntity.getIdRole(),
                roleEntity.getName()
        );
    }
}
