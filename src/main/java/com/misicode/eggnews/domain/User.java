package com.misicode.eggnews.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -2952735933715107253L;

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id_user")
    private Long idUser;

    @Column(length = 150, nullable = false)
    private String email;

    @Column(length = 300, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String names;

    @Column(length = 100, nullable = false)
    private String surnames;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = News.class, mappedBy = "user")
    private List<News> news;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;
}
