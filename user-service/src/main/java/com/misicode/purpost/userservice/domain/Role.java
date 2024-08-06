package com.misicode.purpost.userservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Id
    private String idRole;

    private RoleEnum name;

    public Role() {
    }

    public Role(RoleEnum name) {
        this.name = name;
    }

    public String getIdRole() {
        return idRole;
    }

    public RoleEnum getName() {
        return name;
    }
}
