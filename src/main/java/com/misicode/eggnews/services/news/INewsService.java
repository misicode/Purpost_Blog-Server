package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;

import java.util.List;

public interface INewsService {
    List<News> getNews();

    News getNewsById(String id);

    List<News> getNewsByUser(String email);

    void saveNews(News news);

    void deleteNews(String id);
}
