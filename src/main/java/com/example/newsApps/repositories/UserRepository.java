package com.example.newsApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsApps.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByIsDeleted(Boolean isDeleted);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    User findByUsername(String username);
}
