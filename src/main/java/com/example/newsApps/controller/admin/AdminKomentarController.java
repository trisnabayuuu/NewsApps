package com.example.newsApps.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.services.komentar.KomentarService;

@RestController
public class AdminKomentarController {
    @Autowired
    KomentarService komentarService;
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKomentar(@PathVariable(value = "id") String id){
        return komentarService.deleteKomentarService(id);
    }
}
