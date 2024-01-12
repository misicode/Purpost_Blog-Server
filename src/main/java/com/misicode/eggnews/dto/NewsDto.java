package com.misicode.eggnews.dto;

import java.time.LocalDateTime;

public class NewsDto {
    private String idNews;
    private String title;
    private String body;
    private UserDto user;
    private ImageDto image;
    private LocalDateTime createdAt;
    private Boolean isActive;

    public NewsDto(String idNews, String title, String body, UserDto user, ImageDto image, LocalDateTime createdAt, Boolean isActive) {
        this.idNews = idNews;
        this.title = title;
        this.body = body;
        this.user = user;
        this.image = image;
        this.createdAt = createdAt;
        this.isActive = isActive;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getActive() {
        return isActive;
    }
}
