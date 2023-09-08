package com.example.newsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsApps.models.StoreImage;

public interface ImageRepository extends JpaRepository<StoreImage, String> {
    
}
