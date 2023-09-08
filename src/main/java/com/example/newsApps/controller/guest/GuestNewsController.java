package com.example.newsApps.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.services.news.NewsService;

@RestController
public class GuestNewsController {
    @Autowired
    NewsService newsService;

    @GetMapping("/guest/trending")
    public ResponseEntity<?> getTrending(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        return newsService.getTrendingService(isDeleted);
    }
    @GetMapping("/guest/{id}")
    public ResponseEntity<?> getNewsByid(@PathVariable String id) {
        return newsService.getNewsByIdService(id);
    }
    @GetMapping("/guest/latest")
    public ResponseEntity<?> getLatestNews() {
        return newsService.getLatestNews();
    }
    @GetMapping("/guest/recomended")
    public ResponseEntity<?> getRecomendedNews() {
        return newsService.getRecomendedService();
    }
}
