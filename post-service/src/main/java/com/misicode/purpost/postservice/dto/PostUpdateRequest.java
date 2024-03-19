package com.misicode.purpost.postservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class PostUpdateRequest {
    @NotBlank
    @NotNull
    private String idPost;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String body;

    private MultipartFile image;

    public PostUpdateRequest(String idPost, String title, String body, MultipartFile image) {
        this.idPost = idPost;
        this.title = title;
        this.body = body;
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }
}
