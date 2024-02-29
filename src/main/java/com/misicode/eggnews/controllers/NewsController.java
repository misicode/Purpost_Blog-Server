package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.news.NewsResponse;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.services.news.INewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@Tag(
        name = "News Controller",
        description = "Controlador con las rutas de las peticiones de noticias:" +
                "\n- Listar noticias" +
                "\n- Ver noticias por ID"
)
public class NewsController {
    private INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping()
    @Operation(
            summary = "Listar noticias",
            description = "Esta petición permite listar todas las noticias registradas."
    )
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsResponse(newsService.getNews())
        );
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ver noticias por ID",
            description = "Esta petición permite ver la información completa de una noticia por su ID."
    )
    public ResponseEntity<NewsResponse> getNewsById(@PathVariable String id) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.getNewsById(id))
        );
    }
}
