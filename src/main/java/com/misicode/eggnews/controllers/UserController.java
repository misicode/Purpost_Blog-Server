package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.*;
import com.misicode.eggnews.mapper.NewsMapper;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.services.auth.IAuthService;
import com.misicode.eggnews.services.news.INewsService;
import com.misicode.eggnews.services.user.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(
        name = "User Controller",
        description = "Controlador con las rutas de las peticiones de usuario:" +
                "\n- Ver perfil de usuario" +
                "\n- Editar perfil de usuario" +
                "\n- Ver noticias del usuario" +
                "\n- Crear noticia" +
                "\n- Editar noticia" +
                "\n- Borrar noticia"
)
public class UserController {
    private IAuthService authService;
    private INewsService newsService;
    private IUserService userService;

    public UserController(IAuthService authService, INewsService newsService, IUserService userService) {
        this.authService = authService;
        this.newsService = newsService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    @Operation(
            summary = "Ver perfil del usuario",
            description = "Esta petición permite ver la información personal del usuario logueado."
    )
    public ResponseEntity<UserResponse> getProfile() {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByEmail(authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/profile")
    @Operation(
            summary = "Editar perfil del usuario",
            description = "Esta petición permite editar la información personal del usuario logueado."
    )
    public ResponseEntity<UserResponse> updateProfile(@RequestBody @Valid UserUpdateRequest user) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.updateUser(user, authService.getUsernameAuthenticated()))
        );
    }

    @GetMapping("/news")
    @Operation(
            summary = "Ver noticias del usuario",
            description = "Esta petición permite ver las noticias registradas del usuario logueado."
    )
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(
                NewsMapper.mapToListNewsResponse(newsService.getNewsByUser(authService.getUsernameAuthenticated()))
        );
    }

    @PostMapping("/news")
    @Operation(
            summary = "Crear noticia",
            description = "Esta petición permite crear una noticia."
    )
    public ResponseEntity<NewsResponse> createNews(@RequestBody @Valid NewsCreateRequest news) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.saveNews(news, authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/news/{id}")
    @Operation(
            summary = "Editar noticia",
            description = "Esta petición permite editar una noticia por su ID."
    )
    public ResponseEntity<NewsResponse> updateNews(@PathVariable String id, @RequestBody @Valid NewsUpdateRequest news) {
        return ResponseEntity.ok(
                NewsMapper.mapToNewsResponse(newsService.updateNews(id, news))
        );
    }

    @DeleteMapping("/news/{id}")
    @Operation(
            summary = "Eliminar noticia",
            description = "Esta petición permite borrar una noticia por su ID."
    )
    public ResponseEntity<String> deleteNewsById(@PathVariable String id) {
        newsService.deleteNews(id);

        return ResponseEntity.ok(
            "Noticia eliminada exitosamente!"
        );
    }
}
