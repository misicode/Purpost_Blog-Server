package com.misicode.purpost.postservice.domain.model;

import java.time.LocalDateTime;

public class Post {
    private String idPost;
    private String title;
    private String body;
    private Boolean isActive;
    private User user;
    private Image image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(String idPost, String title, String body, Boolean isActive, User user, Image image, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idPost = idPost;
        this.title = title;
        this.body = body;
        this.isActive = isActive;
        this.user = user;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIdUser(String idUser) {
        this.user.setIdUser(idUser);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setIdImage(String idImage) {
        this.image.setIdImage(idImage);
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
