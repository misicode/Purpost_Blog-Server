package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.NewsResponse;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.services.image.IImageService;
import com.misicode.eggnews.services.news.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private IImageService imageService;
    private INewsService newsService;

    public NewsController(IImageService imageService, INewsService newsService) {
        this.imageService = imageService;
        this.newsService = newsService;
    }

    @GetMapping()
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(NewsMapper.mapToListNewsResponse(newsService.getNews()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getNewsById(@PathVariable String id) {
        return ResponseEntity.ok(NewsMapper.mapToNewsResponse(newsService.getNewsById(id)));
    }

    /*
    @GetMapping("/my-news/edit/{id}")
    public String showEditNews(@PathVariable String id, ModelMap model) {
        model.addAttribute("subtitle", "Editar Noticia");
        model.addAttribute("sectionTitle", "Editar");
        model.addAttribute("isNew", false);
        model.addAttribute("btnName", "Actualizar");
        model.addAttribute("news", newsService.getNewsById(id));
        return "form-news-page";
    }

    @PostMapping("/my-news/form")
    public String formNews(News news, @RequestParam("file-upload") MultipartFile file) {
        if(news.getIdNews() != null) {
            News mNews = newsService.getNewsById(news.getIdNews());

            mNews.setTitle(news.getTitle());
            mNews.setBody(news.getBody());

            if(!file.isEmpty()) mNews.setImage(imageService.saveImage(file));

            newsService.saveNews(mNews);
        } else {
            news.setUser(authService.getUserAuthenticated());
            news.setImage(imageService.saveImage(file));

            newsService.saveNews(news);
        }

        return "redirect:../my-news";
    }

    @GetMapping("/my-news/delete/{id}")
    public String deleteNewsById(@PathVariable String id) {
        newsService.deleteNews(id);
        return "redirect:/my-news";
    }*/
}
