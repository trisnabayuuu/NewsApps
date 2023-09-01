package com.example.newsApps.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @UuidGenerator
    private String id;

    @Column(length = 255)
    private String name;
    @Column(length = 20, unique = true)
    private String username;
    @Column(length = 100, unique = true)
    private String email;
    
    private String password;
    private Boolean isAdmin;
    private Boolean isDeleted= false;

    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;

    public User(String name, String username, String email, String password, Boolean isAdmin) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    


}
