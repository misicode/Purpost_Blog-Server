package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;

import java.util.List;

public interface INewsService {
    List<News> getNews();

    List<News> getNewsByUser(User user);

    News getNewsById(String id);

    void saveNews(News news);

    void deleteNews(String id);
}
