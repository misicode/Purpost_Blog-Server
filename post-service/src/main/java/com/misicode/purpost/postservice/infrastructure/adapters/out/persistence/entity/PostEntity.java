package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "posts")
public class PostEntity {
    @Id
    private String idPost;

    private String title;

    private String body;

    private Boolean isActive;

    private String idUser;

    private String idImage;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public PostEntity(String idPost, String title, String body, Boolean isActive, String idUser, String idImage, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idPost = idPost;
        this.title = title;
        this.body = body;
        this.isActive = isActive;
        this.idUser = idUser;
        this.idImage = idImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getIdPost() {
        return idPost;
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

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
