package com.misicode.purpost.postservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class PostCreateRequest {
    @NotBlank
    @NotNull
    private String username;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String body;

    @NotNull
    private MultipartFile image;

    public PostCreateRequest(String username, String title, String body, MultipartFile image) {
        this.username = username;
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public MultipartFile getImage() {
        return image;
    }
}
