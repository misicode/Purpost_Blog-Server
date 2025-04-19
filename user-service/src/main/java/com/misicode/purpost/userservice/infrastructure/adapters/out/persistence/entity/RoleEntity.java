package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity;

import com.misicode.purpost.userservice.domain.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Builder
@Document(collection = "roles")
public class RoleEntity {
    @Id
    private String idRole;

    private RoleEnum name;
}
