package com.example.newsApps.controller.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.payload.request.RecomendedNewsRequest;
import com.example.newsApps.services.news.NewsService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user/news")
public class CreatorNewsController {
    @Autowired
    NewsService newsService;

    @PostMapping
    public ResponseEntity<?> createNews(@RequestBody NewsRequest request) {
        return newsService.addNewsService(request);
    }

    // @GetMapping
    // public ResponseEntity<?> getNews(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
    //     return newsService.getNewsService(isDeleted);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsByid(@PathVariable String id) {
        return newsService.getNewsByIdService(id);
    }

    

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNews() {
        return newsService.getLatestNews();
    }

    @GetMapping("/recomended")
    public ResponseEntity<?> getRecomendedNews() {
        return newsService.getRecomendedService();
    }

    
}