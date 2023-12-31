package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.IImageService;
import com.misicode.eggnews.services.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewsController {
    private IAuthService authService;
    private IImageService imageService;
    private INewsService newsService;

    public NewsController(IAuthService authService, IImageService imageService, INewsService newsService) {
        this.authService = authService;
        this.imageService = imageService;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("allNews", newsService.getNews());
        return "home-page";
    }

    @GetMapping("/news/{id}")
    public String newsById(@PathVariable String id, ModelMap model) {
        model.addAttribute("news", newsService.getNewsById(id));
        return "news-page";
    }

    @GetMapping("/my-news")
    public String newsByAuthor(ModelMap model) {
        model.addAttribute("allNews", newsService.getNewsByUser(authService.getUserAuthenticated()));
        return "my-news-page";
    }

    @GetMapping("/my-news/create")
    public String showCreateNews(ModelMap model) {
        model.addAttribute("subtitle", "Crear Noticia");
        model.addAttribute("sectionTitle", "Nuevo");
        model.addAttribute("isNew", true);
        model.addAttribute("btnName", "Guardar");
        model.addAttribute("news", new News());
        return "form-news-page";
    }

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
    }
}
