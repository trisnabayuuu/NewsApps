package com.example.newsApps.services.news;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.News;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.NewsRequest;
import com.example.newsApps.payload.request.RecomendedNewsRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.NewsRepository;
import com.example.newsApps.repositories.UserRepository;
import com.example.newsApps.validator.NewsValidation;
import com.example.newsApps.validator.UserValidation;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NewsValidation newsValidation;

    @Autowired
    UserValidation userValidation;

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
    public ResponseEntity<?> getRecomendedService() {
        List<News> recommendedNews = newsRepository.findByIsRecomendedIsTrue();
        return ResponseHandler.responseData(200, "sukses", recommendedNews);
    }

    @Override
    public ResponseEntity<?> addRecomendedService(RecomendedNewsRequest request) {
        // User user = userRepository.findById(request.getUserId()).orElseThrow(() -> {
        //     throw new NoSuchElementException("id user is not found!");
        // });
        // userValidation.validateUser(user);

        News news = newsRepository.findById(request.getNewsId()).orElseThrow(() -> {
            throw new NoSuchElementException("id news is not found!");
        });

        newsValidation.validateNews(news);

        news.setIsRecomended(true);
        newsRepository.save(news);
        
        // if (userisDeleted == true) {

            return ResponseHandler.responseMessage(201, "succses", true);
        // } else {
            // return ResponseHandler.responseError(401, "eror", false);
        // }
    }

    @Override
    public ResponseEntity<?> getLatestNews() {
        List<News> latestNews = newsRepository.findFirst10ByOrderByCreateAtDesc();

        return ResponseHandler.responseData(200, "success", latestNews);
    }

    @Override
    public ResponseEntity<?> getTrendingService(Boolean isDeleted) {
        int pageSize = 5;

        Pageable pageable = PageRequest.of(0, pageSize, Sort.by(Sort.Order.desc("count")));

        List<News> trendingNews = newsRepository.findByIsDeletedOrderByCountDesc(isDeleted, pageable);

        return ResponseHandler.responseData(200, "success", trendingNews);
    }

    @Override
    public ResponseEntity<?> getNewsByIdService(String id) {
        News news = newsRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("news id tidak ditemukan");
        });
        // apakahvvalsdi
        newsValidation.validateNews(news);
        int addCount = news.getCount() + 1;
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

    @Override
    public ResponseEntity<?> deleteNews(String id) {
        News news = newsRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found!");
        });

        // set is deleted menjadi true
        news.setIsDeleted(true);

        // save ke db
        newsRepository.save(news);
        return ResponseHandler.responseMessage(200, "data berhasil di hapus", true);
    }

}
