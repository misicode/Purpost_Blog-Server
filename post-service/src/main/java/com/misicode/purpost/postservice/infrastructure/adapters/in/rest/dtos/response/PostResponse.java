package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response;

import java.time.LocalDateTime;

public class PostResponse {
    private String idPost;
    private String title;
    private String body;
    private Boolean isActive;
    private UserResponse user;
    private ImageResponse image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private PostResponse(Builder builder) {
        this.idPost = builder.idPost;
        this.title = builder.title;
        this.body = builder.body;
        this.isActive = builder.isActive;
        this.user = builder.user;
        this.image = builder.image;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public String getIdPost() {
        return idPost;
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
        private String idPost;
        private String title;
        private String body;
        private Boolean isActive;
        private UserResponse user;
        private ImageResponse image;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder idPost(String idPost) {
            this.idPost = idPost;
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

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
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

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PostResponse build() {
            return new PostResponse(this);
        }
    }
}
