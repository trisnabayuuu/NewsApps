package com.example.newsApps.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.KomentarRequest;
import com.example.newsApps.services.komentar.KomentarService;

@RestController
@RequestMapping("/guest/komentar")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKomentar(@PathVariable(value = "id") String id){
        return komentarService.deleteKomentarService(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKomentarById(@PathVariable(value = "id") String id){
        return komentarService.getKomentarByIdService(id);
    }
}
