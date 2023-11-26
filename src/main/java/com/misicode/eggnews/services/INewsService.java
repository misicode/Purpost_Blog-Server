package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;

import java.util.List;

public interface INewsService {
    List<News> getNews();

    News getNewsById(Long id);

    void saveNews(News news);

    void deleteBook(Long id);
}
