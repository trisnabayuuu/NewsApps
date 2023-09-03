package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForgotRequest {
    @NotEmpty(message = "password tidak boleh kosong")
    @Size(min = 8, max = 15, message = "password minimal 8 character dan maksimal 15 character")
    private String password;

}
