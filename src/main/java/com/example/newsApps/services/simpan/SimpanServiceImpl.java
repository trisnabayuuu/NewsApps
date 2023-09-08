package com.example.newsApps.services.simpan;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.News;
import com.example.newsApps.models.Simpan;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.SimpanRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.NewsRepository;
import com.example.newsApps.repositories.SimpanRepository;
import com.example.newsApps.repositories.UserRepository;

@Service
public class SimpanServiceImpl implements SimpanService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    SimpanRepository simpanRepository;

    @Override
    public ResponseEntity<?> getBerita(Boolean isDeleted) {
        List<Simpan> simpan = new ArrayList<>();

        if (isDeleted == null) {
            simpan = simpanRepository.findAll();
        } else {
            simpan = simpanRepository.findByIsDeleted(isDeleted);
        }
        return ResponseHandler.responseData(200, "success", simpan);
    }

    @Override
    public ResponseEntity<?> simpanBerita(SimpanRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> {
            throw new NoSuchElementException("id user is not found!");
        });

        News news = newsRepository.findById(request.getNewsId()).orElseThrow(() -> {
            throw new NoSuchElementException("id user is not found!");
        });

        Simpan simpan = new Simpan(user, news);
        simpanRepository.save(simpan);
        return ResponseHandler.responseData(201, "success", simpan);
    }
    
}
