package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.beans.ConstructorProperties;

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
    private MultipartFile imageFile;

    @ConstructorProperties({"username", "title", "body", "image"})
    public PostCreateRequest(String username, String title, String body, MultipartFile imageFile) {
        this.username = username;
        this.title = title;
        this.body = body;
        this.imageFile = imageFile;
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

    public MultipartFile getImageFile() {
        return imageFile;
    }
}
