package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.entity.PostEntity;

public class PostPersistenceMapper {
    public PostPersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static PostEntity toPostEntity(Post post) {
        return PostEntity.builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                .isActive(post.getIsActive())
                .idUser(post.getUser().getIdUser())
                .idImage(post.getImage().getIdImage())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static Post toPost(PostEntity postEntity) {
        return Post.builder()
                .idPost(postEntity.getIdPost())
                .title(postEntity.getTitle())
                .body(postEntity.getBody())
                .isActive(postEntity.getIsActive())
                .user(User.builder()
                        .idUser(postEntity.getIdUser())
                        .build()
                )
                .image(Image.builder()
                        .idImage(postEntity.getIdImage())
                        .build()
                )
                .createdAt(postEntity.getCreatedAt())
                .updatedAt(postEntity.getUpdatedAt())
                .build();
    }
}
