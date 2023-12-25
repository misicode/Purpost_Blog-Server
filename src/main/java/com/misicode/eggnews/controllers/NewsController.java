package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.INewsService;
import com.misicode.eggnews.services.IUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {
    private IAuthService authService;
    private INewsService newsService;

    public NewsController(IAuthService authService, INewsService newsService) {
        this.authService = authService;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("allNews", newsService.getNews());
        return "home-page";
    }

    @GetMapping("/news/{id}")
    public String newsById(@PathVariable Long id, ModelMap model) {
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
        model.addAttribute("btnName", "Guardar");
        model.addAttribute("news", new News());
        return "form-news-page";
    }

    @GetMapping("/my-news/edit/{id}")
    public String showEditNews(@PathVariable Long id, ModelMap model) {
        model.addAttribute("subtitle", "Editar Noticia");
        model.addAttribute("sectionTitle", "Editar");
        model.addAttribute("btnName", "Actualizar");
        model.addAttribute("news", newsService.getNewsById(id));
        return "form-news-page";
    }

    @PostMapping("/my-news/form")
    public String formNews(News news) {
        news.setUser(authService.getUserAuthenticated());
        newsService.saveNews(news);
        return "redirect:../my-news";
    }

    @GetMapping("/my-news/delete/{id}")
    public String deleteNewsById(@PathVariable Long id) {
        newsService.deleteNews(id);
        return "redirect:/my-news";
    }
}
