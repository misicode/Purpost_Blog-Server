package com.misicode.purpost.postservice.mappers;

import com.misicode.purpost.postservice.clients.ImageClient;
import com.misicode.purpost.postservice.clients.UserClient;
import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostMapper {
    private UserClient userClient;
    private ImageClient imageClient;

    public PostMapper(UserClient userClient, ImageClient imageClient) {
        this.userClient = userClient;
        this.imageClient = imageClient;
    }

    public PostResponse mapToPostResponse(Post post) {
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

    public PostResponse mapToPostWithoutUserResponse(Post post) {
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

    public List<PostResponse> mapToListPostResponse(List<Post> postList) {
        return postList.stream()
                .map(this::mapToPostResponse)
                .toList();
    }

    public List<PostResponse> mapToListPostWithoutUserResponse(List<Post> postList) {
        return postList.stream()
                .map(this::mapToPostWithoutUserResponse)
                .toList();
    }
}
