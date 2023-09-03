package com.example.newsApps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.services.news.NewsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping
    public ResponseEntity<?> createNews(@RequestBody NewsRequest request) {
        return newsService.addNewsService(request);
    }
    
    @GetMapping
    public ResponseEntity<?> getNews(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted){
        return newsService.getNewsService(isDeleted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsByid(@PathVariable String id ){
        return newsService.getNewsByIdService(id);
    }
}
