package com.misicode.purpost.postservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post {
    private String idPost;
    private String title;
    private String body;
    private Boolean isActive;
    private User user;
    private Image image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
