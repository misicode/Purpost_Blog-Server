package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.services.INewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {
    private INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("allNews", newsService.getNews());
        return "home-page";
    }

    @GetMapping("/{id}")
    public String newsById(@PathVariable Long id, ModelMap model) {
        model.addAttribute("news", newsService.getNewsById(id));
        return "news-page";
    }

    @GetMapping("/my-news")
    public String newsByAuthor(ModelMap model) {
        model.addAttribute("allNews", newsService.getNews());
        return "my-news-page";
    }

    @GetMapping("/my-news/create")
    public String showCreateNews(ModelMap model) {
        model.addAttribute("subtitle", "Crear Noticia");
        model.addAttribute("sectionTitle", "Nuevo");
        model.addAttribute("btnName", "Guardar");
        model.addAttribute("news", new News());
        return "form-news-page";
    }

    @PostMapping("/my-news/form")
    public String formNews(News news) {
        newsService.saveNews(news);
        return "redirect:../my-news";
    }

    @GetMapping("/my-news/edit/{id}")
    public String showEditNews(@PathVariable Long id, ModelMap model) {
        model.addAttribute("subtitle", "Editar Noticia");
        model.addAttribute("sectionTitle", "Editar");
        model.addAttribute("btnName", "Actualizar");
        model.addAttribute("news", newsService.getNewsById(id));
        return "form-news-page";
    }

    @GetMapping("/my-news/delete/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteBook(id);
        return "redirect:/my-news";
    }
}
