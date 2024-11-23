package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostCreateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostUpdateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response.PostResponse;

import java.util.List;

public class PostRestMapper {
    public PostRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static Post toPost(PostCreateRequest postRequest) {
        return new Post(
                null,
                postRequest.title(),
                postRequest.body(),
                null,
                new User(
                        null,
                        postRequest.username(),
                        null,
                        null
                ),
                new Image(
                        null,
                        null,
                        null,
                        postRequest.image()
                ),
                null,
                null
        );
    }

    public static Post toPost(PostUpdateRequest postRequest) {
        return new Post(
                postRequest.idPost(),
                postRequest.title(),
                postRequest.body(),
                null,
                null,
                new Image(
                        null,
                        null,
                        null,
                        postRequest.image()
                ),
                null,
                null
        );
    }

    public static PostResponse toPostResponse(Post post) {
        return new PostResponse(
                post.getIdPost(),
                post.getTitle(),
                post.getBody(),
                post.getActive(),
                UserRestMapper.toUserResponse(post.getUser()),
                ImageRestMapper.toImageResponse(post.getImage()),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public static List<PostResponse> toListPostResponse(List<Post> postList) {
        return postList.stream()
                .map(PostRestMapper::toPostResponse)
                .toList();
    }
}
