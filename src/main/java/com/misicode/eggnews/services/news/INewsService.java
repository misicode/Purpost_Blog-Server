package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.dto.NewsRequest;

import java.util.List;

public interface INewsService {
    List<News> getNews();

    News getNewsById(String id);

    List<News> getNewsByUser(String email);

    News saveNews(NewsRequest news, String email);

    void deleteNews(String id);
}
