package com.misicode.eggnews.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "news")
public class News implements Serializable {
    @Serial
    private static final long serialVersionUID = -2952735933715107252L;

    @Id
    @SequenceGenerator(
            name = "news_sequence",
            sequenceName = "news_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "news_sequence"
    )
    @Column(name = "id_news")
    private Long idNews;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 2500, nullable = false)
    private String body;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public News() {}

    public News(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getFormatBody() {
        return body.replace("\n", "<br>");
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getCreatedAtWithTime() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a"));
    }
}
