package com.misicode.purpost.postservice.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "post")
public class Post {
    @Id
    private String idPost;

    @NotNull
    private String title;

    @NotNull
    private String body;

    @NotNull
    private Boolean isActive = true;

    /*@DBRef
    @NotNull
    private User user;

    @DBRef
    @NotNull
    private Image image;*/

    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedAt;
}
