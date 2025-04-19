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
        return Post.builder()
                .title(postRequest.title())
                .body(postRequest.body())
                .user(User.builder()
                        .username(postRequest.username())
                        .build()
                )
                .image(Image.builder()
                        .image(postRequest.image())
                        .build()
                )
                .build();
    }

    public static Post toPost(PostUpdateRequest postRequest) {
        return Post.builder()
                .idPost(postRequest.idPost())
                .title(postRequest.title())
                .body(postRequest.body())
                .image(Image.builder()
                        .image(postRequest.image())
                        .build()
                )
                .build();
    }

    public static PostResponse toPostResponse(Post post) {
        return PostResponse.builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                .isActive(post.getIsActive())
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
