package com.example.newsApps.services.news;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.News;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.NewsRepository;
import com.example.newsApps.repositories.UserRepository;
import com.example.newsApps.validator.NewsValidation;


@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    NewsValidation newsValidation;


    @Override
    public ResponseEntity<?> addNewsService(NewsRequest request) {

            User user = userRepository.findById(request.getPenulis()).orElseThrow(() -> {
            throw new NoSuchElementException("id user is not found!");
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
    public ResponseEntity<?> getRecomendedService(Boolean isDeleted) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getTrendingService(Boolean isDeleted) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> getNewsByIdService(String id) {
        News news = newsRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("news id tidak ditemukan");
        });
        //apakahvvalsdi
        newsValidation.validateNews(news);
        int addCount = news.getCount() +1 ; 
        news.setCount(addCount);
        newsRepository.save(news);

        return ResponseHandler.responseData(200, "success", news);
    }

    @Override
    public ResponseEntity<?> getNewsService(Boolean isDeleted) {
        List<News> news = new ArrayList<>();

        if (isDeleted == null) {
            news = newsRepository.findAll();
        } else {
            news = newsRepository.findByIsDeleted(isDeleted);
        }
        return ResponseHandler.responseData(200, "success", news);
    }
    
}
