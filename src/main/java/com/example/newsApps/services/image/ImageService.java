package com.example.newsApps.services.image;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ResponseEntity<?> storeImage(MultipartFile file, String newsId) throws IOException;

    ResponseEntity<?> loadImage(String imageId);
}
