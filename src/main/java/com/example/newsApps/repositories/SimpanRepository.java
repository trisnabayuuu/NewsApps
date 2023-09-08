package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsApps.models.Simpan;

public interface SimpanRepository  extends JpaRepository<Simpan, String>{
    List<Simpan> findByIsDeleted(Boolean isDeleted);
}
