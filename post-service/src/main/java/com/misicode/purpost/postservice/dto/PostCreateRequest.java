package com.misicode.purpost.postservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class PostCreateRequest {
    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String body;

    @NotNull
    private MultipartFile image;

    public PostCreateRequest(String email, String title, String body, MultipartFile image) {
        this.email = email;
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getEmail() {
        return email;
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
