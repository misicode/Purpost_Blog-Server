package com.misicode.eggnews.dto;

import java.time.LocalDateTime;

public class NewsResponse {
    private String idNews;
    private String title;
    private String body;
    private UserDto user;
    private ImageDto image;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public NewsResponse(String idNews, String title, String body, UserDto user, ImageDto image, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public UserDto getUser() {
        return user;
    }

    public ImageDto getImage() {
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
