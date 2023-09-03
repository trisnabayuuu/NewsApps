package com.example.newsApps.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * News
 */

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @UuidGenerator
    private String id;
    
    private String headline;
    private Long article;
    // private Blob image;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    private Boolean isDeleted = false;

    public News(String headline, Long article, User user) {
        this.headline = headline;
        this.article = article;
        this.user = user;
    }

}