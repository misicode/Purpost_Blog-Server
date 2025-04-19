package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@Document(collection = "users")
public class UserEntity {
    @Id
    private String idUser;

    private String username;

    private String email;

    private String password;

    private String names;

    private String surnames;

    private Boolean isActive;

    private String idRole;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
