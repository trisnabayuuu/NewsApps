package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotEmpty(message = "username tidak boleh kosong")
    private String username;
    @NotEmpty(message = "email tidak boleh kosong")
    private String password;
}
