package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.repositories.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    private NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getNews() {
        return newsRepository.findByIsActiveTrueOrderByCreatedAtDesc();
    }

    @Override
    public List<News> getNewsByUser(User user) {
        return newsRepository.findByUserAndIsActiveTrueOrderByCreatedAtDesc(user);
    }

    @Override
    public News getNewsById(String id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public void saveNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(String id) {
        newsRepository.softDelete(id);
    }
}
