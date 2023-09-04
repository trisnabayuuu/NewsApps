package com.example.newsApps.services.komentar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.Komentar;
import com.example.newsApps.models.News;
import com.example.newsApps.payload.request.KomentarRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.KomentarRepository;
import com.example.newsApps.repositories.NewsRepository;
import com.example.newsApps.validator.KomentarValidation;
import com.example.newsApps.validator.NewsValidation;

@Service
public class KomentarServiceImpl implements KomentarService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    NewsValidation newsValidation;

    @Autowired
    KomentarRepository komentarRepository;

    @Autowired
    KomentarValidation komentarValidation;

    @Override
    public ResponseEntity<?> addKomentarService(KomentarRequest request) {
        News news = newsRepository.findById(request.getNewsId()).orElseThrow(() -> {
            throw new NoSuchElementException("news id tidak ditemukan");
        });

        // apakahvvalsdi
        newsValidation.validateNews(news);
        Komentar komentar = new Komentar(request.getUser(), news, request.getKomentar());

        komentarRepository.save(komentar);
        return ResponseHandler.responseMessage(201, "komentar berhasil ditambahkan!", true);
    }

    @Override
    public ResponseEntity<?> deleteKomentarService(String id) {
        Komentar komentar = komentarRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id is not found!");
        });

        // set is deleted menjadi true
        komentar.setIsDeleted(true);

        // save ke db
        komentarRepository.save(komentar);
        return ResponseHandler.responseMessage(200, "data berhasil di hapus", true);
    }

    @Override
    public ResponseEntity<?> getKomentarByIdService(String id) {
        Komentar komentar = komentarRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id user is not found!");
        });
    return ResponseHandler.responseData(200, "Success", komentar);
    }

    @Override
    public ResponseEntity<?> getKomentarService() {
        List<Komentar> komentar = new ArrayList<>();

        if (komentar != null) {
            komentar = komentarRepository.findKomentar();
        }

        return ResponseHandler.responseData(200, "success", komentar);
    }

}
