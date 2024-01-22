package com.misicode.eggnews.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewsUpdateRequest {
    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String body;

    private ImageRequest image;

    public NewsUpdateRequest(String title, String body, ImageRequest image) {
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public ImageRequest getImage() {
        return image;
    }
}
