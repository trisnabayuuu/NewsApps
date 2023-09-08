package com.example.newsApps.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "image_news")
public class StoreImage {
    @Id
    @UuidGenerator
    private String id;
    private String sharedUrl;
    private String imageName;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @JsonIgnore
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updateAt;

    @JsonIgnore
    private Boolean isDeleted = false;

    public StoreImage(String imageName, byte[] data, News news) {
        this.imageName = imageName;
        this.data = data;
        this.news = news;
    }

    
}
