package com.misicode.eggnews.services.news;

import com.misicode.eggnews.domain.Image;
import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.news.NewsCreateRequest;
import com.misicode.eggnews.dto.news.NewsUpdateRequest;
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
    public News saveNews(NewsCreateRequest news, String email) {
        User user = userService.getUserByEmail(email);
        Image image = imageService.saveImage(news.getImage());

        News savedNews = new News();
        savedNews.setTitle(news.getTitle());
        savedNews.setBody(news.getBody());
        savedNews.setUser(user);
        savedNews.setImage(image);

        return newsRepository.save(savedNews);
    }

    @Override
    public News updateNews(String id, NewsUpdateRequest news) {
        News updatedNews = getNewsById(id);

        updatedNews.setTitle(news.getTitle());
        updatedNews.setBody(news.getBody());

        if(news.getImage() != null) {
            Image image = imageService.saveImage(news.getImage());
            updatedNews.setImage(image);
        }

        return newsRepository.save(updatedNews);
    }

    @Override
    public void deleteNews(String id) {
        getNewsById(id);
        newsRepository.softDelete(id);
    }
}
