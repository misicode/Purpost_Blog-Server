package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.dto.news.NewsCreateRequest;
import com.misicode.eggnews.dto.news.NewsUpdateRequest;

import java.util.List;

public interface INewsService {
    List<News> getNews();

    News getNewsById(String id);

    List<News> getNewsByUser(String email);

    News saveNews(NewsCreateRequest news, String email);

    News updateNews(String id, NewsUpdateRequest news);

    void deleteNews(String id);
}
