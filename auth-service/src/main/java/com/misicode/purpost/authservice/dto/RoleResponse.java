package com.misicode.purpost.authservice.dto;

public class RoleResponse {
    private String name;

    public RoleResponse() {
    }

    public RoleResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
