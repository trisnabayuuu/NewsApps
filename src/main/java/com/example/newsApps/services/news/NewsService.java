package com.example.newsApps.services.news;

import org.springframework.http.ResponseEntity;

import com.example.newsApps.payload.request.NewsRequest;

public interface NewsService {
    ResponseEntity<?> addNewsService(NewsRequest request);

    ResponseEntity<?> addRecomendedService(String id);

    ResponseEntity<?> getRecomendedService(Boolean isDeleted);

    ResponseEntity<?> getTrendingService(Boolean isDeleted);

    ResponseEntity<?> getNewsService(Boolean isDeleted);
    
    ResponseEntity<?> getNewsByIdService(String id);
}
