package com.example.newsApps.services.komentar;

import org.springframework.http.ResponseEntity;

import com.example.newsApps.payload.request.KomentarRequest;

public interface KomentarService {
    ResponseEntity<?> addKomentarService(KomentarRequest request);

    ResponseEntity<?> getKomentarByIdService(String id);
    
    ResponseEntity<?> getKomentarService();
    
    ResponseEntity<?> deleteKomentarService(String id);
}
