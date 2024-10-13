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
        return new PostEntity(
                post.getIdPost(),
                post.getTitle(),
                post.getBody(),
                post.getActive(),
                post.getUser().getIdUser(),
                post.getImage().getIdImage(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public static Post toPost(PostEntity postEntity) {
        return new Post(
                postEntity.getIdPost(),
                postEntity.getTitle(),
                postEntity.getBody(),
                postEntity.getActive(),
                new User(
                        postEntity.getIdUser(),
                        null,
                        null,
                        null
                ),
                new Image(
                        postEntity.getIdImage(),
                        null,
                        null,
                        null
                ),
                postEntity.getCreatedAt(),
                postEntity.getUpdatedAt()
        );
    }
}
