package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.newsApps.models.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, String>{
    @Query(value = "SELECT k.id, k.news_id , k.create_at, k.update_at, k.user ,k.isi_komentar, k.is_deleted \n" + //
    "FROM news_apps.komentar k \n" + //
    "JOIN news_apps.news n on k.news_id = n.id;", nativeQuery = true)
    List<Komentar> findKomentar();
}
