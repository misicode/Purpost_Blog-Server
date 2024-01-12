package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.dto.NewsDto;

import java.util.List;

public class NewsMapper {
    public static NewsDto mapToNewsDto(News news) {
        return new NewsDto(
                news.getIdNews(),
                news.getTitle(),
                news.getBody(),
                UserMapper.mapToUserDto(news.getUser()),
                ImageMapper.mapToImageDto(news.getImage()),
                news.getCreatedAt(),
                news.getActive()
        );
    }

    public static List<NewsDto> mapToListNewsDto(List<News> newsList) {
        return newsList.stream()
                .map(news -> mapToNewsDto(news))
                .toList();
    }
}
