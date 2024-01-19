package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.NewsDto;
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
    public ResponseEntity<List<NewsDto>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsDto(newsService.getNewsByUser(authService.getUsernameAuthenticated()))
        );
    }
}
