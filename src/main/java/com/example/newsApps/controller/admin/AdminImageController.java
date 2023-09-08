package com.example.newsApps.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.newsApps.services.image.ImageService;

@RestController
public class AdminImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/admin/files/book")
    public ResponseEntity<?> storeImage(@RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "bookId") String bookId) throws IOException {
        return imageService.storeImage(file, bookId);
    }

    @GetMapping("/files/book/{imageId}")
    public ResponseEntity<?> loadImage(@PathVariable String imageId) {
        return imageService.loadImage(imageId);
    }
}
