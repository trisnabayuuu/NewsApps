package com.example.newsApps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.KomentarRequest;
import com.example.newsApps.services.komentar.KomentarService;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    KomentarService komentarService;

    @PostMapping
    public ResponseEntity<?> createKomentar(@RequestBody KomentarRequest request) {
        return komentarService.addKomentarService(request);
    }

    @GetMapping
    public ResponseEntity<?> getKomentar(){
        return komentarService.getKomentarService();
    }

    
}
