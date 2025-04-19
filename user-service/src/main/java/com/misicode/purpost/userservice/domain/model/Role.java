package com.misicode.purpost.userservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    private String idRole;
    private RoleEnum name;
}
