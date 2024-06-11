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
    private final PostMapper postMapper;

    public PostController(IPostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> getPosts() {
        return ResponseEntity.ok(
                postMapper.mapToListPostResponse(postService.getPosts())
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(
                postMapper.mapToPostResponse(postService.getPostById(id))
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<PostResponse>> getPostsByUser(@PathVariable String email) {
        return ResponseEntity.ok(
                postMapper.mapToListPostResponse(postService.getPostsByUser(email))
        );
    }

    @PostMapping(value="/private", consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> createPost(@ModelAttribute @Valid PostCreateRequest post) {
        return ResponseEntity.ok(
                postMapper.mapToPostResponse(postService.createPost(post))
        );
    }

    @PutMapping(value="/private", consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> updatePost(@ModelAttribute @Valid PostUpdateRequest post) {
        return ResponseEntity.ok(
                postMapper.mapToPostResponse(postService.updatePost(post))
        );
    }

    @DeleteMapping("/private/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        postService.deletePost(id);

        return ResponseEntity.ok(
                "Publicación eliminada exitosamente!"
        );
    }
}
