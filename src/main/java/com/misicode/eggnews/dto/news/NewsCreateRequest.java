package com.misicode.eggnews.dto.news;

import com.misicode.eggnews.validators.ValidFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class NewsCreateRequest {
    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String body;

    @NotNull
    @ValidFile
    private MultipartFile image;

    public NewsCreateRequest(String title, String body, MultipartFile image) {
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

    public MultipartFile getImage() {
        return image;
    }
}
