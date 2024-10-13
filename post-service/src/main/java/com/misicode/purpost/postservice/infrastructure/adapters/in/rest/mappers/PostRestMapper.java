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
                postRequest.getTitle(),
                postRequest.getBody(),
                null,
                new User(
                        null,
                        postRequest.getUsername(),
                        null,
                        null
                ),
                new Image(
                        null,
                        null,
                        null,
                        postRequest.getImageFile()
                ),
                null,
                null
        );
    }

    public static Post toPost(PostUpdateRequest postRequest) {
        return new Post(
                postRequest.getIdPost(),
                postRequest.getTitle(),
                postRequest.getBody(),
                null,
                null,
                new Image(
                        null,
                        null,
                        null,
                        postRequest.getImageFile()
                ),
                null,
                null
        );
    }

    public static PostResponse toPostResponse(Post post) {
        return new PostResponse.Builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                .isActive(post.getActive())
                .user(UserRestMapper.toUserResponse(post.getUser()))
                .image(ImageRestMapper.toImageResponse(post.getImage()))
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static List<PostResponse> toListPostResponse(List<Post> postList) {
        return postList.stream()
                .map(PostRestMapper::toPostResponse)
                .toList();
    }
}
