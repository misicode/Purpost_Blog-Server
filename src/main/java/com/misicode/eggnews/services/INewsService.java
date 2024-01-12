package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.NewsDto;

import java.util.List;

public interface INewsService {
    List<NewsDto> getNews();

    List<News> getNewsByUser(User user);

    NewsDto getNewsById(String id);

    void saveNews(News news);

    void deleteNews(String id);
}
