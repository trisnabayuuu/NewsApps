package com.example.newsApps.services.simpan;

import org.springframework.http.ResponseEntity;

import com.example.newsApps.payload.request.SimpanRequest;

public interface SimpanService {

    ResponseEntity<?> simpanBerita(SimpanRequest request);
    
    ResponseEntity<?> getBerita(Boolean isDeleted);
}
