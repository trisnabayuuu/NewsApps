package com.example.newsApps.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "komentar")
public class Komentar {

    @Id
    @UuidGenerator
    private String id;

    private String user;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    private String isiKomentar;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    private Boolean isDeleted = false;


    public Komentar(String user, News news, String isiKomentar) {
        this.user = user;
        this.news = news;
        this.isiKomentar = isiKomentar;
    }

    
}
