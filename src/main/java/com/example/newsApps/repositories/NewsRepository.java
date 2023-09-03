package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.newsApps.models.News;

public interface NewsRepository extends JpaRepository<News, String> {
    List<News> findByIsDeleted(Boolean isDeleted);


    // @Query(value = "select t.id, t.created_at, t.updated_at, \n" + //
    // "t.is_returned, t.book_id, b.title,\n" + //
    // "t.user_id, u.email\n" + //
    // "from librarydb.transactions t\n" + //
    // "join librarydb.books b on t.book_id = b.id\n" + //
    // "join librarydb.users u on u.id = t.user_id;", nativeQuery = true)
    // List<News> getRecomended();

}
