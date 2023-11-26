package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.News;
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
    @Transactional(readOnly = true)
    public List<News> getNews() {
        return newsRepository.findByIsActiveTrueOrderByCreatedAtDesc();
    }

    @Override
    @Transactional(readOnly = true)
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveNews(News news) {
        newsRepository.save(news);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        newsRepository.softDelete(id);
    }
}
