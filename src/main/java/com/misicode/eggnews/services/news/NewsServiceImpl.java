package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.NewsDto;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.repositories.NewsRepository;
import com.misicode.eggnews.services.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements INewsService {
    private NewsRepository newsRepository;
    private IUserService userService;

    public NewsServiceImpl(NewsRepository newsRepository, IUserService userService) {
        this.newsRepository = newsRepository;
        this.userService = userService;
    }

    @Override
    public List<News> getNews() {
        return newsRepository.findByIsActiveTrueOrderByCreatedAtDesc();
    }

    @Override
    public News getNewsById(String id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ErrorResponseEnum.NEWS_NOT_FOUND, Map.of("id", id)));
    }

    @Override
    public List<News> getNewsByUser(String email) {
        User user = userService.getUserByEmail(email);

        return newsRepository.findByUserAndIsActiveTrueOrderByCreatedAtDesc(user);
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
