package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.Image;
import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.NewsRequest;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.repositories.NewsRepository;
import com.misicode.eggnews.services.image.IImageService;
import com.misicode.eggnews.services.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements INewsService {
    private IImageService imageService;
    private NewsRepository newsRepository;
    private IUserService userService;

    public NewsServiceImpl(IImageService imageService, NewsRepository newsRepository, IUserService userService) {
        this.imageService = imageService;
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
    public News saveNews(NewsRequest news, String email) {
        User user = userService.getUserByEmail(email);
        Image image = imageService.saveImage(news.getImage());

        News newNews = new News();
        newNews.setTitle(news.getTitle());
        newNews.setBody(news.getBody());
        newNews.setUser(user);
        newNews.setImage(image);

        return newsRepository.save(newNews);
    }

    @Override
    public void deleteNews(String id) {
        newsRepository.softDelete(id);
    }
}
