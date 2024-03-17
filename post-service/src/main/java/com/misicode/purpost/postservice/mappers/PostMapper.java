package com.misicode.purpost.postservice.mappers;

import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostResponse;

import java.util.List;

public class PostMapper {
    private PostMapper() {
        throw new UnsupportedOperationException();
    }

    public static PostResponse mapToPostResponse(Post post) {
        return new PostResponse.Builder()
                .idPost(post.getIdPost())
                .title(post.getTitle())
                .body(post.getBody())
                //.user(UserMapper.mapToUserResponse(post.getIdUser()))
                //.image(ImageMapper.mapToImageResponse(post.getIdImage()))
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
}
