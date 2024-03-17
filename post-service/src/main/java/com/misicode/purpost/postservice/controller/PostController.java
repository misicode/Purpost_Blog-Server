package com.misicode.purpost.postservice.controller;

import com.misicode.purpost.postservice.dto.PostCreateRequest;
import com.misicode.purpost.postservice.dto.PostResponse;
import com.misicode.purpost.postservice.dto.PostUpdateRequest;
import com.misicode.purpost.postservice.mappers.PostMapper;
import com.misicode.purpost.postservice.services.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> getPosts() {
        return ResponseEntity.ok(
                PostMapper.mapToListPostResponse(postService.getPosts())
        );
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<PostResponse>> getPostsByUser(@PathVariable String email) {
        return ResponseEntity.ok(
                PostMapper.mapToListPostWithoutUserResponse(postService.getPostsByUser(email))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(
                PostMapper.mapToPostResponse(postService.getPostById(id))
        );
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> createPost(@ModelAttribute @Valid PostCreateRequest post) {
        return ResponseEntity.ok(
                PostMapper.mapToPostResponse(postService.createPost(post))
        );
    }

    @PutMapping(consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> updatePost(@ModelAttribute @Valid PostUpdateRequest post) {
        return ResponseEntity.ok(
                PostMapper.mapToPostResponse(postService.updatePost(post))
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        postService.deletePost(id);

        return ResponseEntity.ok(
                "Publicación eliminada exitosamente!"
        );
    }
}
