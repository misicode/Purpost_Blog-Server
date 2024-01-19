package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.NewsRequest;
import com.misicode.eggnews.dto.NewsResponse;
import com.misicode.eggnews.dto.UserDto;
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
    public ResponseEntity<UserDto> getProfile() {
        return ResponseEntity.ok(
                UserMapper.mapToUserDto(userService.getUserByEmail(authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDto> updateProfile(@RequestBody @Valid UserDto user) {
        return ResponseEntity.ok(
                UserMapper.mapToUserDto(userService.updateUser(user, authService.getUsernameAuthenticated()))
        );
    }

    @GetMapping("/news")
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsResponse(newsService.getNewsByUser(authService.getUsernameAuthenticated()))
        );
    }

    @PostMapping("/news")
    public ResponseEntity<NewsResponse> createNews(@RequestBody @Valid NewsRequest news) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.saveNews(news, authService.getUsernameAuthenticated()))
        );
    }
}
