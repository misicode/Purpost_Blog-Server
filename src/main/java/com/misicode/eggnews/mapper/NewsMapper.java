package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.dto.NewsResponse;

import java.util.List;

public class NewsMapper {
    private NewsMapper() {
        throw new UnsupportedOperationException();
    }

    public static NewsResponse mapToNewsResponse(News news) {
        return new NewsResponse.Builder()
                .idNews(news.getIdNews())
                .title(news.getTitle())
                .body(news.getBody())
                .user(UserMapper.mapToUserResponse(news.getUser()))
                .image(ImageMapper.mapToImageResponse(news.getImage()))
                .isActive(news.getActive())
                .createdAt(news.getCreatedAt())
                .updatedAt(news.getUpdatedAt())
                .build();
    }

    public static List<NewsResponse> mapToListNewsResponse(List<News> newsList) {
        return newsList.stream()
                .map(NewsMapper::mapToNewsResponse)
                .toList();
    }
}
