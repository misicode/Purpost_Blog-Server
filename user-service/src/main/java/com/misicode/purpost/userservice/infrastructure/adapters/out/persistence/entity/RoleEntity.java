package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity;

import com.misicode.purpost.userservice.domain.model.RoleEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class RoleEntity {
    @Id
    private String idRole;

    private RoleEnum name;

    public RoleEntity(String idRole, RoleEnum name) {
        this.idRole = idRole;
        this.name = name;
    }

    public String getIdRole() {
        return idRole;
    }

    public RoleEnum getName() {
        return name;
    }
}
