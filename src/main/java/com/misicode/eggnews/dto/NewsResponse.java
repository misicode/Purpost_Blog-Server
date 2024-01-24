package com.misicode.eggnews.dto;

import java.time.LocalDateTime;

public class NewsResponse {
    private String idNews;
    private String title;
    private String body;
    private UserResponse user;
    private ImageResponse image;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public NewsResponse(String idNews, String title, String body, UserResponse user, ImageResponse image, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idNews = idNews;
        this.title = title;
        this.body = body;
        this.user = user;
        this.image = image;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getIdNews() {
        return idNews;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public UserResponse getUser() {
        return user;
    }

    public ImageResponse getImage() {
        return image;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
