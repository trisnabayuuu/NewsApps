package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.newsApps.models.News;

public interface NewsRepository extends JpaRepository<News, String> {
    List<News> findByIsDeleted(Boolean isDeleted);

    // @Query(value = "SELECT * FROM news WHERE is_recomended = 1; ")
    List<News> findByIsRecomendedIsTrue();
    List<News> findByIsDeletedOrderByCountDesc(Boolean isDeleted, Pageable pageable);

    List<News> findFirst10ByOrderByCreateAtDesc();  

}
