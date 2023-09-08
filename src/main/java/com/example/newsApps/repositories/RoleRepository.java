package com.example.newsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsApps.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
