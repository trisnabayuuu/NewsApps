package com.example.newsApps.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.services.image.ImageService;

@RestController
public class GuestImageController {
    @Autowired
    ImageService imageService;
    @GetMapping("/guest/files/news/{imageId}")
    public ResponseEntity<?> loadImage(@PathVariable String imageId) {
        return imageService.loadImage(imageId);
    }
}
