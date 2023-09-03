package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class KomentarRequest {
    @NotEmpty(message = "user tidak boleh kosong")
    private String user;
    @NotEmpty(message = "komentar tidak boleh kosong")
    private String komentar;
    @NotEmpty(message = "news id tidak boleh kosong")
    private String newsId;
}
