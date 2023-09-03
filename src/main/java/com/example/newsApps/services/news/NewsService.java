package com.example.newsApps.services.news;

import org.springframework.http.ResponseEntity;

import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.payload.request.RecomendedNewsRequest;

public interface NewsService {
    ResponseEntity<?> addNewsService(NewsRequest request);

    ResponseEntity<?> addRecomendedService(RecomendedNewsRequest request);

    ResponseEntity<?> getRecomendedService();

    ResponseEntity<?> getTrendingService(Boolean isDeleted);

    ResponseEntity<?> getNewsService(Boolean isDeleted);

    ResponseEntity<?> getNewsByIdService(String id);
    
    ResponseEntity<?> getLatestNews();
}
