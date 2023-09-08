package com.example.newsApps.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.RecomendedNewsRequest;
import com.example.newsApps.services.news.NewsService;

import jakarta.validation.Valid;

@RestController
public class AdminNewsController {

    @Autowired
    NewsService newsService;

    @PostMapping("/admin/recomended")
    public ResponseEntity<?> addRecomended(@RequestBody @Valid RecomendedNewsRequest request) {
        return newsService.addRecomendedService(request);
    }

    @GetMapping("/admin/news")
    public ResponseEntity<?> getNews(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        return newsService.getNewsService(isDeleted);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable(value = "id") String id){
        return newsService.deleteNews(id);
    }
}
