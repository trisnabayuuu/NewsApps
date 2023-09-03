package com.example.newsApps.services.news;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.News;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.NewsRepository;
import com.example.newsApps.repositories.UserRepository;


@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;
    

    @Override
    public ResponseEntity<?> addNewsService(NewsRequest request) {

            User user = userRepository.findById(request.getPenulis()).orElseThrow(() -> {
            throw new NoSuchElementException("id book is not found!");
        });

            News news = new News(request.getHeadline(), request.getArticle(), user);
            newsRepository.save(news);    
                return ResponseHandler.responseMessage(201, "News successfully added!", true);    
    }

    @Override
    public ResponseEntity<?> addRecomendedService(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> addTrendingService(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getRecomendedService(Boolean isDeleted) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getTrendingService(Boolean isDeleted) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
