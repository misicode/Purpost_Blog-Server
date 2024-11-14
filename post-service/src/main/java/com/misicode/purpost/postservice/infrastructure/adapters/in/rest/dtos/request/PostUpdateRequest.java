package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

import java.beans.ConstructorProperties;

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

    private FilePart imageFile;

    @ConstructorProperties({"idPost", "title", "body", "image"})
    public PostUpdateRequest(String idPost, String title, String body, FilePart imageFile) {
        this.idPost = idPost;
        this.title = title;
        this.body = body;
        this.imageFile = imageFile;
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

    public FilePart getImageFile() {
        return imageFile;
    }
}
