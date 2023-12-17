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

    public Long getIdUser() {
        return idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
