package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.NewsResponse;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.services.news.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping()
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsResponse(newsService.getNews())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getNewsById(@PathVariable String id) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.getNewsById(id))
        );
    }
}
