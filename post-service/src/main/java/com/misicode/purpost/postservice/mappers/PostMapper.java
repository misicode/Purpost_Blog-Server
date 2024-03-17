package com.misicode.purpost.postservice.mappers;

import com.misicode.purpost.postservice.clients.ImageClient;
import com.misicode.purpost.postservice.clients.UserClient;
import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostResponse;

import java.util.List;

public class PostMapper {
    private static UserClient userClient;
    private static ImageClient imageClient;

    private PostMapper(UserClient userClient, ImageClient imageClient) {
        PostMapper.userClient = userClient;
        PostMapper.imageClient = imageClient;
    }

    public static PostResponse mapToPostResponse(Post post) {
        return new PostResponse.Builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                .user(userClient.getUserById(post.getIdUser()))
                .image(imageClient.getImageById(post.getIdImage()))
                .isActive(post.getActive())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static PostResponse mapToPostWithoutUserResponse(Post post) {
        return new PostResponse.Builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                .image(imageClient.getImageById(post.getIdImage()))
                .isActive(post.getActive())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static List<PostResponse> mapToListPostResponse(List<Post> postList) {
        return postList.stream()
                .map(PostMapper::mapToPostResponse)
                .toList();
    }

    public static List<PostResponse> mapToListPostWithoutUserResponse(List<Post> postList) {
        return postList.stream()
                .map(PostMapper::mapToPostWithoutUserResponse)
                .toList();
    }
}
