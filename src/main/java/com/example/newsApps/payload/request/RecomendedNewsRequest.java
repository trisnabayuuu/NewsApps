package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RecomendedNewsRequest {
    @NotEmpty(message = "userId tidak boleh kosong")
    private String userId;
    @NotEmpty(message = "newsId tidak boleh kosong")
    private String newsId;
}
