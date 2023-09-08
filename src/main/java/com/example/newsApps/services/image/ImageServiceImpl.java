package com.example.newsApps.services.image;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.newsApps.models.News;
import com.example.newsApps.models.StoreImage;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.ImageRepository;
import com.example.newsApps.repositories.NewsRepository;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    NewsRepository newsRepository;

    @Override
    public ResponseEntity<?> loadImage(String imageId) {
        StoreImage image = imageRepository.findById(imageId)
        .orElseThrow(() -> new NoSuchElementException("Image is not found!"));

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getImageName() + "\"")
        .body(image.getData());
    }

    @Override
    public ResponseEntity<?> storeImage(MultipartFile file, String newsId) throws IOException {
        // ambil nama gambar
        String imgName = StringUtils.cleanPath(file.getOriginalFilename());
        // cari entitas news
        News news = newsRepository.findById(newsId).orElseThrow(()
        -> new NoSuchElementException("news tidak ditemukan"));


        // buatkan entitas image news
    StoreImage image = new StoreImage(imgName, file.getBytes(), news);
    imageRepository.save(image); // menyimpan id

    // buatkan sharedUrl
    /*
     * endpoint untuk upload: /admin/files/news -> POST
     * endpoint untuk load: /files/news/{uuidGambar} ->GET
     */
    String sharedUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath() // localhost:9098
        .path("/files/news/")
        .path(image.getId()) // id gambar
        .toUriString();

    // set sharedurl ke obj image news
    image.setSharedUrl(sharedUrl);
    imageRepository.save(image);
        return ResponseHandler.responseData(201, "success", image);
    }

    
}
