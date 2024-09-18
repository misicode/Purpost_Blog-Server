package com.misicode.purpost.userservice.domain.model;

public class Role {
    private String idRole;
    private RoleEnum name;

    public Role(String idRole, RoleEnum name) {
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
