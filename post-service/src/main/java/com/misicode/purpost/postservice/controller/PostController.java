package com.misicode.purpost.postservice.controller;

import com.misicode.purpost.postservice.dto.PostResponse;
import com.misicode.purpost.postservice.mappers.PostMapper;
import com.misicode.purpost.postservice.services.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> getPost() {
        return ResponseEntity.ok(
                PostMapper.mapToListPostResponse(postService.getPosts())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(
                PostMapper.mapToPostResponse(postService.getPostById(id))
        );
    }
}
