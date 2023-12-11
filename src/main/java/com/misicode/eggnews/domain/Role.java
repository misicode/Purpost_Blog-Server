package com.misicode.eggnews.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('USER', 'ADMIN') default 'USER'")
    private ERole role;
}
