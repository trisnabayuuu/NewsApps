package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewsRequest {
    @NotEmpty(message = "headline tidak boleh kosong")
    private String headline;
    
    @NotEmpty(message = "article tidak boleh kosong")
    private String article;

    // @NotEmpty(message = "image tidak boleh kosong")
    // private Blob image;

    @NotEmpty(message = "penulis tidak boleh kosong")
    private String penulis;
}
