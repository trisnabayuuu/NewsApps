package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsApps.models.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, String>{
    List<Komentar> findByIsDeleted(Boolean isDeleted);
}
