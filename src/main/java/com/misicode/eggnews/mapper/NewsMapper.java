package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.dto.NewsResponse;

import java.util.List;

public class NewsMapper {
    public static NewsResponse mapToNewsResponse(News news) {
        return new NewsResponse(
                news.getIdNews(),
                news.getTitle(),
                news.getBody(),
                UserMapper.mapToUserResponse(news.getUser()),
                ImageMapper.mapToImageResponse(news.getImage()),
                news.getActive(),
                news.getCreatedAt(),
                news.getUpdatedAt()
        );
    }

    public static List<NewsResponse> mapToListNewsResponse(List<News> newsList) {
        return newsList.stream()
                .map(news -> mapToNewsResponse(news))
                .toList();
    }
}
