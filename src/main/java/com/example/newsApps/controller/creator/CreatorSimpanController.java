package com.example.newsApps.controller.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.SimpanRequest;
import com.example.newsApps.services.simpan.SimpanService;

@RestController
public class CreatorSimpanController {
    @Autowired
    SimpanService simpanService;
    @PostMapping("/user/simpan")
    public ResponseEntity<?> createSimpan(@RequestBody SimpanRequest request) {
        return simpanService.simpanBerita(request);
    }

    @GetMapping("/user/simpan")
    public ResponseEntity<?> getSimpan(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
        return simpanService.getBerita(isDeleted);
    }
}
