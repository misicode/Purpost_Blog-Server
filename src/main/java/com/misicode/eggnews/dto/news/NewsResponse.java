package com.misicode.eggnews.dto.news;

import com.misicode.eggnews.dto.user.UserResponse;
import com.misicode.eggnews.dto.image.ImageResponse;

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

    private NewsResponse(Builder builder) {
        this.idNews = builder.idNews;
        this.title = builder.title;
        this.body = builder.body;
        this.user = builder.user;
        this.image = builder.image;
        this.isActive = builder.isActive;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
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

    public static class Builder {
        private String idNews;
        private String title;
        private String body;
        private UserResponse user;
        private ImageResponse image;
        private Boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder idNews(String idNews) {
            this.idNews = idNews;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder user(UserResponse user) {
            this.user = user;
            return this;
        }

        public Builder image(ImageResponse image) {
            this.image = image;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public NewsResponse build() {
            return new NewsResponse(this);
        }
    }
}
