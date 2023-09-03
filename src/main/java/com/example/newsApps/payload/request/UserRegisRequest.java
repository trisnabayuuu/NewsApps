package com.example.newsApps.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * UserRequest
 */
@Data
public class UserRegisRequest {
    @NotEmpty(message = "nama tidak boleh kosong")
    private String name;
    @NotEmpty(message = "username tidak boleh kosong")
    private String username;
    @NotEmpty(message = "email tidak boleh kosong")
    private String email;
    @NotEmpty(message = "password tidak boleh kosong")
    @Size(min = 8, max = 15, message = "password minimal 8 character dan maksimal 15 character")
    private String password;
    @NotNull(message = "role harus diisi")
    private Boolean isAdmin;
    
}