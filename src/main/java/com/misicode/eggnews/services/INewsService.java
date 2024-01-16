package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.NewsDto;

import java.util.List;

public interface INewsService {
    List<NewsDto> getNews();

    NewsDto getNewsById(String id);

    List<News> getNewsByUser(User user);

    void saveNews(News news);

    void deleteNews(String id);
}
