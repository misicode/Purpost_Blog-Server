package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.*;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.services.auth.IAuthService;
import com.misicode.eggnews.services.news.INewsService;
import com.misicode.eggnews.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private IAuthService authService;
    private INewsService newsService;
    private IUserService userService;

    public UserController(IAuthService authService, INewsService newsService, IUserService userService) {
        this.authService = authService;
        this.newsService = newsService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile() {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByEmail(authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@RequestBody @Valid UserUpdateRequest user) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.updateUser(user, authService.getUsernameAuthenticated()))
        );
    }

    @GetMapping("/news")
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsResponse(newsService.getNewsByUser(authService.getUsernameAuthenticated()))
        );
    }

    @PostMapping("/news")
    public ResponseEntity<NewsResponse> createNews(@RequestBody @Valid NewsCreateRequest news) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.saveNews(news, authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/news/{id}")
    public ResponseEntity<NewsResponse> updateNews(@PathVariable String id, @RequestBody @Valid NewsUpdateRequest news) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.updateNews(id, news))
        );
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<String> deleteNewsById(@PathVariable String id) {
        newsService.deleteNews(id);

        return ResponseEntity.ok(
            "Noticia eliminada exitosamente!"
        );
    }
}
